package org.example.service.core;

import java.util.List;

public interface BaseService<T> {
    T find(Long id);
    List<T> findAll();
    void save(T entity);
    void update(T entity);
    void delete(Long id);
}
