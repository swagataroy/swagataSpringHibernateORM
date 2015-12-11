package com.swagata.persistence;

import java.util.List;

public interface UserPersistence<User> {

    List<User> findUsers();

    User findById(Long id);

    void create(User user);

    void update(User user);

    void delete(Long id);

}
