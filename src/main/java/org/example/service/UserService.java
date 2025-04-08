package org.example.service;

import org.example.model.User;
import org.example.service.core.BaseService;

import java.util.List;

public interface UserService extends BaseService<User> {
    @Override
    User find(Long id);

    @Override
    List<User> findAll();

    @Override
    void save(User entity);

    @Override
    void update(User entity);

    @Override
    void delete(Long id);
}
