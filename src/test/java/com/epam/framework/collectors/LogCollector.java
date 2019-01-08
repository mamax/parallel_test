package com.epam.framework.collectors;

import com.epam.framework.Log;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.zeroturnaround.zip.ZipUtil;

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
public class LogCollector extends BaseCollector {
    private static final String LOG_FILE_NAME = "final_log_file.log";
    private static final String ZIP_FILE_NAME = "final_log_file.zip";

    private void mergeFiles(String outputLogFile, List<File> logFileList) {
        File logFile = new File(outputLogFile);
        for (File file : logFileList) {
            String fileTextContent = null;
            try {
                fileTextContent = FileUtils.readFileToString(file);
                if (fileTextContent.length() == 0) {
                    Log.error(String.format("Something goes wrong with file '%s'", file.getAbsoluteFile()));
                }
            } catch (IOException e) {
                Log.error(String.format("Unexpected error happened: %s", e.getMessage()));
            }
            try {
                FileUtils.write(logFile, fileTextContent, true);
                Log.info(String.format("File '%s' was merged successfully", file.getAbsoluteFile()));
            } catch (IOException e) {
                Log.error(String.format("Unexpected error happened: %s", e.getMessage()));
            }
        }
    }

    private void collect(String inputDir, String outputDir) {
        deleteDir(outputDir);
        String outputLogFile = FilenameUtils.concat(outputDir, LOG_FILE_NAME);
        String outputZipFile = FilenameUtils.concat(outputDir, ZIP_FILE_NAME);
        List<File> logFileList = getFilesFromDir(inputDir, new String[]{"log"});
        logFileList.sort((o1, o2) -> (o1.getName().compareToIgnoreCase(o2.getName())));
        mergeFiles(outputLogFile, logFileList);
        zipLogFile(outputLogFile, outputZipFile);
        deleteFile(outputLogFile);
    }

    private void zipLogFile(String outputLogFile, String outputZipFile) {
        ZipUtil.packEntry(new File(outputLogFile), new File(outputZipFile));
    }

    public static void main(String[] args) {
        // System.setProperty("input.log4j.log.dir", USER_DIR + "/target/logs/");
        // System.setProperty("output.log4j.log.dir", USER_DIR + "/target/final-log-file/");
        String inputDir = Paths.get(System.getProperty("input.log4j.log.dir")).toString();
        String outputDir = Paths.get(System.getProperty("output.log4j.log.dir")).toString();
        new LogCollector().collect(inputDir, outputDir);
    }
}
