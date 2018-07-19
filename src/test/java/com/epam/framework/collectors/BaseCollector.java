package com.epam.framework.collectors;

import com.epam.framework.Log;
import com.epam.framework.collectors.report.classes.Feature;
import com.epam.framework.exceptions.ReportCollectorException;
import com.epam.framework.utils.DirUtils;
import com.epam.framework.utils.JsonUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

/**
 * #Summary:
 * #Author: Andrii_Marchenko1
 * #Author’s Email:
 * #Creation Date: 5/31/2018
 * #Comments:
 */
public class BaseCollector {
    private JsonUtils jsonUtils = new JsonUtils();
    protected static final String USER_DIR;

    static {
        USER_DIR = Paths.get(System.getProperty("user.dir")).toString();
    }

    protected List<File> getFilesFromDir(String dir, String[] extensionsPattern) {
        try {
            return DirUtils.getFilesFromDirByExtensions(dir, extensionsPattern, true);
        } catch (FileNotFoundException e) {
            throw new ReportCollectorException(String.format("File/Directory '%s' does not exist.", dir));
        }
    }

    protected void deleteDir(String dirName) {
        File directoryName = new File(dirName);
        try {
            FileUtils.deleteDirectory(directoryName);
        } catch (IOException e) {
            throw new ReportCollectorException(String.format("Directory '%s' cannot be deleted.", dirName));
        }
    }

    protected void deleteFile(String fileName) {
        File file = new File(fileName);
        boolean result = file.delete();
        if (result) {
            Log.info(String.format("File '%s' was deleted successfully.", file));
        }
    }

    private String readFileToString(File fileName) {
        try {
            return FileUtils.readFileToString(fileName);
        } catch (IOException e) {
            throw new ReportCollectorException(String.format("File '%s' cannot be read.", fileName));
        }
    }

    private void printFileContent(List<File> fileList) {
        for (File file : fileList) {
            Log.info(String.format("Content of file '%s'", file.getAbsoluteFile()));
            Log.info(readFileToString(file));
        }
    }

    protected void processCucumberFile(File file, List<Feature> featureList, List<File> listFilesWithViolations) {
        String jsonFile = file.getAbsolutePath();
        try {
            List<Feature> features = jsonUtils.readFromFileAsArrayListOfClass(Feature.class, jsonFile);
            featureList.addAll(features);
            Log.info(String.format(
                    "File '%s' was parsed successfully. Found '%s' features.",
                    file.getAbsoluteFile(),
                    features.size()));
        } catch (IllegalStateException e) {
            Log.error(String.format("File '%s' does not contain JSON.", jsonFile));
            listFilesWithViolations.add(file);
        }
    }

    protected boolean checkViolateFiles(List<File> listFilesWithViolations) {
        if (!listFilesWithViolations.isEmpty()) {
            printFileContent(listFilesWithViolations);
            return false;
        } else {
            return true;
        }
    }
}
