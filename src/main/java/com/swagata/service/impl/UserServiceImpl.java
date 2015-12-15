package com.swagata.service.impl;


import com.swagata.entity.User;
import com.swagata.persistence.UserPersistence;
import com.swagata.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService<User> {

    @Autowired
    private UserPersistence up;

    @Transactional(readOnly = true)
    @Override
    public List<User> getUserList() {
        return up.findUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(Long userId) {

        if (userId == 0) {
            return new User();
        } else {
            return (User) up.findById(userId);
        }
    }

    @Transactional
    @Override
    public void saveOrUpdate(User user) {

        if (user.getUserId() == null) {
            up.create(user);
        } else {
            up.update(user);
        }
    }

    @Transactional
    @Override
    public void delete(Long id) {
        up.delete(id);
    }
}
