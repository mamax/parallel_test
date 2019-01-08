package com.epam.framework.collectors;

import com.epam.framework.collectors.report.classes.Element;
import com.epam.framework.collectors.report.classes.Feature;
import com.epam.framework.exceptions.ReportCollectorException;
import com.epam.framework.utils.JsonUtils;
import javafx.util.Pair;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.nio.file.Paths;
import java.util.*;

/**
 * #Summary:
 * #Author: Andrii_Marchenko1
 * #Author’s Email:
 * #Creation Date: 5/23/2018
 * #Comments:
 */
public class ReportCollector extends BaseCollector {
    private static final String REPORT_FILE_NAME = "cucumber_report.json";

    private List<Feature> readFeaturesFromJson(List<File> jsonFiles) {
        List<Feature> featureList = new LinkedList<>();
        List<File> listFilesWithViolations = new ArrayList<>();
        for (File jsonFile1 : jsonFiles) {
            processCucumberFile(jsonFile1, featureList, listFilesWithViolations);
        }
        if (!checkViolateFiles(listFilesWithViolations)) {
            return Collections.emptyList();
        }
        return featureList;
    }

    private void writeFeaturesToFile(String outputDir, List<Feature> featureList) {
        JsonUtils jsonUtils = new JsonUtils();
        jsonUtils.writeJsonToFile(FilenameUtils.concat(outputDir, REPORT_FILE_NAME), featureList);
    }

    private boolean isTheSameFeature(Feature feature1, Feature feature2) {
        if (!feature1.getId().equals(feature2.getId())) {
            return false;
        }
        if (!feature1.getName().equals(feature2.getName())) {
            return false;
        }
        if (!feature1.getDescription().equals(feature2.getDescription())) {
            return false;
        }
        if (!feature1.getKeyword().equals(feature2.getKeyword())) {
            return false;
        }
        return feature1.getTags().equals(feature2.getTags());
    }

    private void reduceFeatureUri(Feature feature) {
        feature.setUri(Paths.get(feature.getUri()).toString().replace(USER_DIR, ""));
    }

    private void mergeFeatures(Feature feature1, Feature feature2) {
        feature1.getElements().addAll(feature2.getElements());
    }

    private List<Feature> processingFeature(List<Feature> featureList, Feature featureToValidate) {
        boolean isMerged = false;
        for (Feature feature : featureList) {
            if (isTheSameFeature(feature, featureToValidate)) {
                mergeFeatures(feature, featureToValidate);
                isMerged = true;
                break;
            }
        }
        if (!isMerged) {
            featureList.add(featureToValidate);
        }
        return featureList;
    }

    private List<Feature> parseFeatures(List<Feature> initialFeatures) {
        List<Feature> featureList = new LinkedList<>();
        for (Feature feature : initialFeatures) {
            reduceFeatureUri(feature);
            featureList = processingFeature(featureList, feature);
        }
        return featureList;
    }

    private void sortScenariosInFeature(List<Feature> mergedFeatureList) {
        for (Feature feature : mergedFeatureList) {
            sortScenariosInFeature(feature);
        }
    }

    private void sortScenariosInFeature(Feature feature) {
        List<Pair<Element, Element>> pairBackgroundScenario = new ArrayList<>();
        List<Element> elementList = feature.getElements();
        if (!"background".equalsIgnoreCase(elementList.get(0).getType())) {
            elementList.sort(Comparator.comparing(Element::getLine));
        } else if (elementList.size() % 2 == 0) {
            for (int i = 0; i < elementList.size(); i = i + 2) {
                Pair<Element, Element> elementPair = new Pair<>(elementList.get(i), elementList.get(i + 1));
                pairBackgroundScenario.add(elementPair);
            }
            pairBackgroundScenario.sort(Comparator.comparing(o -> o.getValue().getLine()));
            List<Element> sortedList = new ArrayList<>();
            for (Pair<Element, Element> elementPair : pairBackgroundScenario) {
                sortedList.add(elementPair.getKey());
                sortedList.add(elementPair.getValue());
            }
            feature.setElements(sortedList);
        } else {
            throw new ReportCollectorException("First element is not equal to 'background' and elements size cannot be divided to 2 the whole.");
        }
    }

    private void collect(String inputDir, String outputDir) {
        deleteDir(outputDir);
        List<File> jsonFiles = getFilesFromDir(inputDir, new String[]{"json"});
        List<Feature> initialFeatureList = readFeaturesFromJson(jsonFiles);
        List<Feature> mergedFeatureList = parseFeatures(initialFeatureList);
        mergedFeatureList.sort((feature1, feature2) -> feature1.getName().compareToIgnoreCase(feature2.getName()));
        sortScenariosInFeature(mergedFeatureList);
        writeFeaturesToFile(outputDir, mergedFeatureList);
    }

    public static void main(String[] args) {
//        System.setProperty("input.json.dir", USER_DIR + "/target/cucumber-results/");
//        System.setProperty("output.json.dir", USER_DIR + "/target/report-json/");
        String inputDir = Paths.get(System.getProperty("input.json.dir")).toString();
        String outputDir = Paths.get(System.getProperty("output.json.dir")).toString();
        new ReportCollector().collect(inputDir, outputDir);
    }
}
