package com.nazar.springmvc.service;

import java.util.List;

import com.nazar.springmvc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nazar.springmvc.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    public User findById(long id) {
        return userDao.findById(id);
    }

    public User findByName(String name) {
        return userDao.findByName(name);
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUserById(long id) {
        userDao.deleteUserById(id);
    }

    public boolean isUserExist(User user) {
        return userDao.isUserExist(user);
    }

    public void deleteAllUsers() {
        userDao.deleteAllUsers();
    }

}