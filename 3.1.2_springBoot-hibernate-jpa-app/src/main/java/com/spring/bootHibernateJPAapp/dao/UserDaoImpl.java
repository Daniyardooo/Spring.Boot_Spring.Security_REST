package com.spring.bootHibernateJPAapp.dao;

import com.spring.bootHibernateJPAapp.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;


    @Transactional(readOnly = true)
    public List<User> getUsers() {
        TypedQuery<User> query = em.createQuery("select p from User p", User.class);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public User getUserById(int id) {
        User user = em.find(User.class, id);
        if (user != null) {
            return user;
        } else {
            throw new RuntimeException("User does not exist");
        }
    }

    @Transactional
    public void createUser(User user) {
        em.persist(user);
    }

    @Transactional
    public void updateUserById(int id, User updatedUser) {
        User existingUser = em.find(User.class, id);
        if (existingUser != null) {
            existingUser.setName(updatedUser.getName());
            existingUser.setAge(updatedUser.getAge());
            existingUser.setEmail(updatedUser.getEmail());
            em.merge(existingUser);
        } else throw new RuntimeException("Error updating user");

    }

    @Transactional
    public void removeUserById(int id) {
        User existingUser = em.find(User.class, id);
        if (existingUser != null) {
            em.remove(existingUser);
        } else throw new RuntimeException("Error removing user");

    }
}
