package com.spring.bootHibernateJPAapp.service;

import com.spring.bootHibernateJPAapp.dao.UserDao;
import com.spring.bootHibernateJPAapp.models.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void createUser(User user) {
        userDao.createUser(user);

    }

    @Override
    public void updateUserById(int id, User updatedUser) {
        userDao.updateUserById(id, updatedUser);
    }

    @Override
    public void removeUserById(int id) {
        userDao.removeUserById(id);

    }
}
