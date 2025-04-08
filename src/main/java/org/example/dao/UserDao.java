package org.example.dao;

import org.example.dao.core.BaseDao;
import org.example.model.User;

import java.util.List;

public interface UserDao extends BaseDao<User> {
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
