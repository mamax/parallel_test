package com.epam.framework.utils;

import com.epam.framework.Log;
import gherkin.deps.com.google.gson.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public <T> List<T> getDeserializedListOfClass(Class<T> resultClass, String jsonBody) {
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonArray = jsonParser.parse(jsonBody).getAsJsonArray();
        List<T> objs = new ArrayList<>();
        for (JsonElement jsonElement : jsonArray) {
            objs.add(gson.fromJson(jsonElement.toString(), resultClass));
        }
        return objs;
    }

    public String getJsonFromClass(Object object) {
        return gson.toJson(object);
    }

    public void writeJsonToFile(String fileName, Object object) {
        File fileNameJSON = new File(fileName).getAbsoluteFile();
        String json = getJsonFromClass(object);
        FileWriter fileWriter = null;
        try {
            if (!fileNameJSON.exists()) {
                boolean isDirCreated = fileNameJSON.getParentFile().mkdirs();
                Log.info(String.format("Method mkdirs() returned '%s' for directory '%s'.", isDirCreated, fileNameJSON.getParentFile()));
                boolean isFileCreated = fileNameJSON.createNewFile();
                Log.info(String.format("Method createNewFile() returned '%s' for file '%s'.", isFileCreated, fileNameJSON));
            }
        } catch (IOException e) {
            Log.error(e.getMessage());
        }
        try {
            fileWriter = new FileWriter(fileNameJSON);
            fileWriter.write(json);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            Log.error(e.getMessage());
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    Log.error(e.getMessage());
                }
            }
        }
    }

    public String readJsonFromFile(String file) {
        try {
            return StreamUtils.inputStreamToString(new FileInputStream(new File(file).getAbsoluteFile()));
        } catch (FileNotFoundException e) {
            Log.error(e.getMessage());
            return null;
        }
    }

    public <T> List<T> readFromFileAsArrayListOfClass(Class<T> resultClass, String jsonFile) {
        List<T> arrayOut = new ArrayList<>();
        File file = new File(jsonFile).getAbsoluteFile();
        if (file.exists()) {
            String json = readJsonFromFile(jsonFile);
            arrayOut = getDeserializedListOfClass(resultClass, json);
        }
        return arrayOut;
    }
}