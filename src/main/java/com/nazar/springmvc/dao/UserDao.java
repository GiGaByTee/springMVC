package com.nazar.springmvc.dao;

import com.nazar.springmvc.model.User;

import java.util.List;

public interface UserDao {

    User findById(long id);

    User findByName(String name);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);

    List<User> findAllUsers();

    void deleteAllUsers();

    boolean isUserExist(User user);
}
