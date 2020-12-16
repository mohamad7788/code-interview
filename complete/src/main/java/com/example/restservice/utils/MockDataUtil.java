package com.example.restservice.utils;

import com.example.restservice.model.AvailableDate;
import com.example.restservice.model.Provider;

import java.util.*;


public class MockDataUtil {

    public static Map<String, Provider> getProviders()  {
        Map<String, Provider> providers = new HashMap<>();
        String name = "Jake Chambers";
        String[] specialties = {"Primary Care", "Cardiologist"};
        float score = (float) 8.9;
        AvailableDate[] dates = {new AvailableDate(1571637600000L, 1571666400000L), new AvailableDate(1579518000000L, 1579528800000L)};
        providers.put(name, new Provider(name, Arrays.asList(specialties), Arrays.asList(dates), score));


        name = "Roland Deschain";
        score = 10;
        specialties = new String[]{"Neurology", "Cardiologist"};
        dates = new AvailableDate[]{new AvailableDate(1571569200000L, 1571580000000L), new AvailableDate(1571637600000L, 1571666400000L)};
        providers.put(name, new Provider(name, Arrays.asList(specialties), Arrays.asList(dates), score));


        name = "Susannah Dean";
        score = (float) 9.2;
        specialties = new String[]{"Neuropathy"};
        dates = new AvailableDate[]{new AvailableDate(1571569200000L, 1571580000000L)};
        providers.put(name, new Provider(name, Arrays.asList(specialties), Arrays.asList(dates), score));

        name = "Eddie Dean";
        score = (float) 8.2;
        specialties = new String[]{"Pain Assistanc", "Internist"};
        dates = new AvailableDate[]{};
        providers.put(name, new Provider(name, Arrays.asList(specialties), Arrays.asList(dates), score));


        name = "Oy Midworld";
        score = (float) 9.2;
        specialties = new String[]{"Neonatal"};
        dates = new AvailableDate[]{new AvailableDate(814172400000L, 1634803200000L)};
        providers.put(name, new Provider(name, Arrays.asList(specialties), Arrays.asList(dates), score));


        name = "Randall Flagg";
        score = (float) 0.1;
        specialties = new String[]{"Physiologist"};
        dates = new AvailableDate[]{new AvailableDate(1808982000000L, 1808982000000L)};
        providers.put(name, new Provider(name, Arrays.asList(specialties), Arrays.asList(dates), score));

        return  providers;
    }

}