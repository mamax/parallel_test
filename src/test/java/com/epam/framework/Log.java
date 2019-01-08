package com.epam.framework;

import com.epam.framework.context.ContextFI;
import com.epam.framework.utils.DirUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;

import java.io.File;

public class Log {
    private static final String FILE_APPENDER_NAME = "file";
    private static final String BASE_LOG_PATH;
    private static final String BASE_LOG_NAME;
    private static final String LOG_EXTENSION;

    static {
        Appender appender = Logger.getRootLogger().getAppender(FILE_APPENDER_NAME);
        if (appender instanceof FileAppender) {
            FileAppender fileAppender = ((FileAppender) appender);
            String oldFileName = fileAppender.getFile();
            BASE_LOG_PATH = FilenameUtils.getPath(oldFileName);
            BASE_LOG_NAME = FilenameUtils.getBaseName(oldFileName);
            LOG_EXTENSION = FilenameUtils.getExtension(oldFileName);
        } else {
            BASE_LOG_PATH = "";
            BASE_LOG_NAME = "";
            LOG_EXTENSION = "";
        }
    }

    public static synchronized void info(Object message) {
        String name = getCallerClassName();
        Logger log = getLog(name);
        log.info(message);
    }

    public static synchronized void error(Object message) {
        String name = getCallerClassName();
        Logger log = getLog(name);
        log.error(message);
    }

    private static String getCallerClassName() {
        StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
        String className = stElements[3].getClassName();
        try {
            return Class.forName(className).getName();
        } catch (ClassNotFoundException e) {
            Log.error(e.getMessage());
            return null;
        }
    }

    private static void changeFileNameInFileAppenderOfRootLogger(String scenarioName) {
        Appender appender = Logger.getRootLogger().getAppender(FILE_APPENDER_NAME);
        if (appender instanceof FileAppender) {
            FileAppender fileAppender = ((FileAppender) appender);
//            TODO: нужен рефакторинг, т.к. при создании каждой строки логирования, создается новый экземпляр File объекта.
            String fileName = new File(FilenameUtils.concat(BASE_LOG_PATH, scenarioName + "." + LOG_EXTENSION)).getAbsolutePath();
            fileAppender.setFile(fileName);
            fileAppender.activateOptions();
        } else {
            System.out.println(String.format("Appender %s does not extend %s class", appender.getName(), FileAppender.class));
        }
    }

    private static String getLogFileName() {
        String scenarioName = ContextFI.getScenarioName();
        String logFileName = scenarioName == null ? BASE_LOG_NAME : scenarioName;
        return DirUtils.normalizeFileName(logFileName);
    }

    private static Logger getLog(String name) {
        String scenarioNameNew = getLogFileName();
        changeFileNameInFileAppenderOfRootLogger(scenarioNameNew);
        return Logger.getLogger(name);
    }
}
