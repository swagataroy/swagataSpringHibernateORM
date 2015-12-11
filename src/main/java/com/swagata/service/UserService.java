package com.swagata.service;


import java.util.List;

public interface UserService<User> {

    List<User> getUserList();

    User getUserById(Long id);

//    void create(User user);
//
//    void update(User user);

    void saveOrUpdate(User user);

    void delete(Long id);


}
