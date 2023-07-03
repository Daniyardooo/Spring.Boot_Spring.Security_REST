package com.spring.bootHibernateJPAapp.dao;

import com.spring.bootHibernateJPAapp.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    User getUserById(int id);

    void createUser(User user);

    void updateUserById(int id, User updatedUser);

    void removeUserById(int id);
}
