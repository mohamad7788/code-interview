package com.example.restservice.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T,KEY> {

    Optional<T> get(KEY name);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(T t);
}
