package com.epam.framework.collectors.report.classes;

import java.util.List;

public class Row {
    private List<String> cells;
    private Long line;

    public List<String> getCells() {
        return cells;
    }

    public void setCells(List<String> cells) {
        this.cells = cells;
    }

    public Long getLine() {
        return line;
    }

    public void setLine(Long line) {
        this.line = line;
    }
}
