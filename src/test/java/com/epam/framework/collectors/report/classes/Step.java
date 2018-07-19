package com.epam.framework.collectors.report.classes;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Step {
    private Result result;
    private List<Embedding> embeddings;
    private Long line = null;
    private String name = null;
    private Match match = null;
    private List<Long> matchedColumns;
    private List<Row> rows;
    private String keyword = null;

    @JsonProperty("output")
    private List<Output> outputs;
    @JsonProperty("doc_string")
    private DocString doc_string = null;


    public List<Long> getMatchedColumns() {
        return matchedColumns;
    }

    public void setMatchedColumns(List<Long> matchedColumns) {
        this.matchedColumns = matchedColumns;
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public List<Embedding> getEmbeddings() {
        return embeddings;
    }

    public void setEmbeddings(List<Embedding> embeddings) {
        this.embeddings = embeddings;
    }

    public List<Output> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<Output> outputs) {
        this.outputs = outputs;
    }

    public DocString getDoc_string() {
        return doc_string;
    }

    public void setDoc_string(DocString doc_string) {
        this.doc_string = doc_string;
    }
}
