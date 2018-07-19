package com.epam.framework.collectors.report.classes;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Tag {
    private Long line;
    private String name = null;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Tag tag = (Tag) o;

        return new EqualsBuilder()
                .append(line, tag.line)
                .append(name, tag.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(line)
                .append(name)
                .toHashCode();
    }
}
