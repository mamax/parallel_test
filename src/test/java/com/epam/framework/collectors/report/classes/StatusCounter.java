package com.epam.framework.collectors.report.classes;

import java.util.EnumMap;

public class StatusCounter {
    private EnumMap<Status, Integer> counter = new EnumMap(Status.class);
    private Status finalStatus;
    private int size;

    public EnumMap<Status, Integer> getCounter() {
        return counter;
    }

    public void setCounter(EnumMap<Status, Integer> counter) {
        this.counter = counter;
    }

    public Status getFinalStatus() {
        return finalStatus;
    }

    public void setFinalStatus(Status finalStatus) {
        this.finalStatus = finalStatus;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
