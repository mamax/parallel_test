package com.epam.framework.collectors.report.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
    @JsonProperty("duration")
    private Long duration;
    @JsonProperty("error_message")
    private String error_message;
    @JsonProperty("status")
    private Status status;

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
