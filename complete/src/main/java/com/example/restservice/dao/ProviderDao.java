package com.example.restservice.dao;

import com.example.restservice.model.AvailableDate;
import com.example.restservice.model.Provider;
import com.example.restservice.utils.MockDataUtil;
import javafx.util.Pair;

import java.util.*;

public class ProviderDao implements Dao<Provider, String> {

    private Map<String, Provider> providers;

    public ProviderDao() {
        providers = MockDataUtil.getProviders();
    }

    @Override
    public Optional<Provider> get(String name) {
        if(providers.containsKey(name))
            return Optional.ofNullable(providers.get(name));
        return null;
    }

    @Override
    public List<Provider> getAll() {
        return new ArrayList<>(providers.values());
    }

    @Override
    public void save(Provider provider) {
        providers.put(provider.getName(),provider);
    }

    @Override
    public void update(Provider provider) {
        providers.put(provider.getName(),provider);
    }

    @Override
    public void delete(Provider provider) {
        providers.remove(provider.getName());
    }
}