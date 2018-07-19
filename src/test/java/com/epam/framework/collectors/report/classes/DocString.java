package com.epam.framework.collectors.report.classes;

public class DocString {

    private String content_type = null;
    private Long line;
    private String value = null;

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public Long getLine() {
        return line;
    }

    public void setLine(Long line) {
        this.line = line;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
