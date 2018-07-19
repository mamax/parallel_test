package com.epam.framework.collectors.report.classes;

import java.util.List;

public class Match {
    private List<Argument> arguments;
    private String location = null;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Argument> getArguments() {
        return arguments;
    }

    public void setArguments(List<Argument> arguments) {
        this.arguments = arguments;
    }
}
