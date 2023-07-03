package com.spring.bootHibernateJPAapp.service;

import com.spring.bootHibernateJPAapp.models.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUserById(int id);

    void createUser(User user);

    void updateUserById(int id, User updatedUser);

    void removeUserById(int id);
}
