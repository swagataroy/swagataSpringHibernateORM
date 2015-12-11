package com.swagata.persistence.hibernate.impl;


import org.springframework.stereotype.Repository;

import com.swagata.entity.User;
import com.swagata.persistence.UserPersistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
public class UserPersistenceImpl implements UserPersistence<User> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findUsers() {
        return em.createQuery("From User", User.class).getResultList();
    }

    @Override
    public User findById(Long id) {

        User user = em.find(User.class, id);
        System.out.println();
        return user;
    }

    @Override
    public void create(User user) {

        em.persist(user);
    }

    @Override
    public void update(User user) {

        em.merge(user);
    }

    @Override
    public void delete(Long id) {
        User user = new User();
        user.setUserId(id);
        Object o = em.merge(user);
        em.remove(o);

    }
}
