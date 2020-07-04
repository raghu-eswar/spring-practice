package com.bridgelabz.greetingapi.service.impl;

import com.bridgelabz.greetingapi.dao.UserDao;
import com.bridgelabz.greetingapi.model.User;
import com.bridgelabz.greetingapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public Integer addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User getUser(int userId) {
        return userDao.getUser(userId);
    }
}
