package org.example.dao.core;

import java.util.List;

public interface BaseDao<T> {
    T find(Long id);
    List<T> findAll();
    void save(T entity);
    void update(T entity);
    void delete(Long id);
}
