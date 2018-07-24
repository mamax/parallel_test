package com.epam.framework.collectors;


import com.epam.framework.Log;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

/**
 * #Summary:
 * #Author: Andrii_Marchenko1
 * #Author’s Email:
 * #Creation Date: 5/29/2018
 * #Comments:
 */
public class RerunCollector extends BaseCollector {

    private void mergeFiles(String outputRerunFile, List<File> rerunFileList) {
        File rerunFile = new File(outputRerunFile);
        for (File file : rerunFileList) {
            String fileTextContent = null;
            try {
                fileTextContent = FileUtils.readFileToString(file);
            } catch (IOException e) {
                Log.error(String.format("Unexpected error happened: %s", e.getMessage()));
            }
            try {
                FileUtils.write(rerunFile, fileTextContent, true);
                Log.info(String.format("File '%s' was merged successfully", file.getAbsoluteFile()));
            } catch (IOException e) {
                Log.error(String.format("Unexpected error happened: %s", e.getMessage()));
            }
        }
    }

    private void collect(String inputDir, String outputFile) {
        deleteFile(outputFile);
        List<File> rerunFileList = getFilesFromDir(inputDir, new String[]{"txt"});
        rerunFileList.sort((o1, o2) -> (o1.getName().compareToIgnoreCase(o2.getName())));
        mergeFiles(outputFile, rerunFileList);
    }

    public static void main(String[] args) {
        System.setProperty("input.rerun.dir", USER_DIR + "/target/cucumber-results/");
        System.setProperty("output.rerun.file", USER_DIR + "/target/cucumber-results/rerun_failed_scenarios.txt");
        String inputDir = Paths.get(System.getProperty("input.rerun.dir")).toString();
        String outputRerunFile = Paths.get(System.getProperty("output.rerun.file")).toString();
        new RerunCollector().collect(inputDir, outputRerunFile);
    }
}
