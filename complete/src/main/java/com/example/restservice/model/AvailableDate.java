package com.example.restservice.model;

import javafx.util.Pair;

public class AvailableDate {

    private Long from;
    private Long to;

    public AvailableDate(Long from, Long to) {
        this.from = from;
        this.to = to;
    }

    public Pair<Long, Long> getAvailableDate() {
        return new Pair<>(from, to);
    }

    public void setAvailableDate(Long from, Long to) {
        this.from = from;
        this.to = to;
    }

    public boolean isAvailable(Long time) {
        return time > this.from && time < this.to;
    }

}
