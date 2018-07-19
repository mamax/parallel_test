package com.epam.framework.collectors.report.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Feature {
    private Long line = null;
    private List<Element> elements;
    private String name = null;
    private String description = null;
    private String id = null;
    private String keyword = null;
    @JsonProperty("uri")
    private String uri = null;
    private List<Tag> tags;

    private String jsonFile = null;
    private String reportFileName = null;
    private String deviceName = null;
    private List<Element> scenarios;
    private StatusCounter elementsCounter;
    private StatusCounter stepsCounter;
    private Status featureStatus = null;
    private Long duration = null;

    public Long getLine() {
        return line;
    }

    public void setLine(Long line) {
        this.line = line;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getJsonFile() {
        return jsonFile;
    }

    public void setJsonFile(String jsonFile) {
        this.jsonFile = jsonFile;
    }

    public String getReportFileName() {
        return reportFileName;
    }

    public void setReportFileName(String reportFileName) {
        this.reportFileName = reportFileName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public List<Element> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<Element> scenarios) {
        this.scenarios = scenarios;
    }

    public StatusCounter getElementsCounter() {
        return elementsCounter;
    }

    public void setElementsCounter(StatusCounter elementsCounter) {
        this.elementsCounter = elementsCounter;
    }

    public StatusCounter getStepsCounter() {
        return stepsCounter;
    }

    public void setStepsCounter(StatusCounter stepsCounter) {
        this.stepsCounter = stepsCounter;
    }

    public Status getFeatureStatus() {
        return featureStatus;
    }

    public void setFeatureStatus(Status featureStatus) {
        this.featureStatus = featureStatus;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}
