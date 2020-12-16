package com.example.restservice.controller;


import com.example.restservice.dao.ProviderDao;
import com.example.restservice.model.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class ProviderController {


    Logger logger = LoggerFactory.getLogger(ProviderController.class);


    @GetMapping(value = "/appointments")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<String> getAppointments(
            @RequestParam String specialty,
            @RequestParam Long date,
            @RequestParam float minScore) {

        // Get the updated provides list
        List<Provider> providersList = new ProviderDao().getAll();
        List<Provider> filteredProviders = new ArrayList<>();

        // Get all providers that match the parameters
        try {
            for (Provider provider : providersList) {
                if (provider.getScore() >= minScore &&
                        provider.getSpecialties().contains(specialty) &&
                        provider.isAvailable(date)
                ) {
                    filteredProviders.add(provider);
                }
            }
        } catch (Exception e) {
            logger.error("Error occur while retrieve matching providers : GET /appointments , see below error message :-");
            logger.error(e.getMessage());
        }

        // Sort the matched providers by score & build a list of providers names
        Collections.sort(filteredProviders);
        List<String> filteredProvidersNames = new ArrayList<>();
        for (Provider provider : filteredProviders) {
            filteredProvidersNames.add(provider.getName());
        }

        return filteredProvidersNames;
    }


    @PostMapping(value = "/appointments", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> postAppointments(
            @RequestBody String name,
            @RequestBody Long date
    ) {
        // Get the updated provides list
        List<Provider> providersList = new ProviderDao().getAll();
        for (Provider provider : providersList) {
            if (provider.getName().equalsIgnoreCase(name) && provider.isAvailable(date)) {
                logger.info("POST /appointments " + name + date + " is valid");
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        logger.info("POST /appointments " + name + date + " isn't valid");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
