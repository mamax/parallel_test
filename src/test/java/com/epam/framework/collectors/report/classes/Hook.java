package com.epam.framework.collectors.report.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Hook {
    private Result result = null;
    private Match match = null;
    @JsonProperty("output")
    private List<Output> outputs;
    private List<Embedding> embeddings;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public List<Output> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<Output> outputs) {
        this.outputs = outputs;
    }

    public List<Embedding> getEmbeddings() {
        return embeddings;
    }

    public void setEmbeddings(List<Embedding> embeddings) {
        this.embeddings = embeddings;
    }
}
