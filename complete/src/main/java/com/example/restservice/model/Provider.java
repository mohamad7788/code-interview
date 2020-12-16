package com.example.restservice.model;

import javafx.util.Pair;

import java.util.List;
import java.util.Objects;

public class Provider implements Comparable {


    private String name;
    private List<String> specialties;
    private List<AvailableDate> availableDates;
    private float score;


    public Provider() {
    }

    public Provider(String name, List<String> specialties, List<AvailableDate> availableDates, float score) {
        this.name = name;
        this.specialties = specialties;
        this.availableDates = availableDates;
        this.score = score;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Provider provider = (Provider) o;
        return Float.compare(provider.score, score) == 0 &&
                Objects.equals(name, provider.name) &&
                Objects.equals(specialties, provider.specialties) &&
                Objects.equals(availableDates, provider.availableDates);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<String> specialties) {
        this.specialties = specialties;
    }

    public List<AvailableDate> getAvailableDates() {
        return availableDates;
    }

    public void setAvailableDates(List<AvailableDate> availableDates) {
        this.availableDates = availableDates;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, specialties, availableDates, score);
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        if (o == null || getClass() != o.getClass()) return 1;
        Provider provider = (Provider) o;
        if (this.score > provider.score)
            return 1;
        if (this.score < provider.score)
            return -1;
        return 0;
    }


    public boolean isAvailable(Long date){
        for(AvailableDate obj : this.getAvailableDates()){
            if(obj.isAvailable(date))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "name='" + name + '\'' +
                ", specialties=" + specialties +
                ", availableDates=" + availableDates +
                ", score=" + score +
                '}';
    }
}
