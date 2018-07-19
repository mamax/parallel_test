package com.epam.framework.collectors.report.classes;

import net.masterthought.cucumber.json.support.Status;

import java.util.List;

public class Element {
    private List<Hook> before;
    private Long line = null;
    private String name = null;
    private String description = null;
    private String id = null;
    private List<Hook> after;
    private String type = null;
    private String keyword = null;
    private List<Step> steps;
    private List<Tag> tags;


    private Status elementStatus = null;
    private Status beforeStatus = null;
    private Status afterStatus = null;
    private Status stepsStatus = null;
    private Feature feature = null;
    private Long duration = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getLine() {
        return line;
    }

    public void setLine(Long line) {
        this.line = line;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public List<Hook> getBefore() {
        return before;
    }

    public void setBefore(List<Hook> before) {
        this.before = before;
    }

    public List<Hook> getAfter() {
        return after;
    }

    public void setAfter(List<Hook> after) {
        this.after = after;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Status getElementStatus() {
        return elementStatus;
    }

    public void setElementStatus(Status elementStatus) {
        this.elementStatus = elementStatus;
    }

    public Status getBeforeStatus() {
        return beforeStatus;
    }

    public void setBeforeStatus(Status beforeStatus) {
        this.beforeStatus = beforeStatus;
    }

    public Status getAfterStatus() {
        return afterStatus;
    }

    public void setAfterStatus(Status afterStatus) {
        this.afterStatus = afterStatus;
    }

    public Status getStepsStatus() {
        return stepsStatus;
    }

    public void setStepsStatus(Status stepsStatus) {
        this.stepsStatus = stepsStatus;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}
