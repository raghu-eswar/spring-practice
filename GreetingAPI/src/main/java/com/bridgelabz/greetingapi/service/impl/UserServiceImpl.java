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
    public User addUser(User user, int messageId) {
        return userDao.addUser(user, messageId);
    }

    @Override
    public User getUser(int userId) {
        return userDao.getUser(userId);
    }

    @Override
    public User updateUser(User user, User newUser) {
        if (!user.getFirstName().equals(newUser.getFirstName()) || !user.getLastName().equals(newUser.getLastName()) ||
                user.getMessageId() != newUser.getMessageId()) {
            newUser.setId(user.getId());
            return userDao.updateUser(newUser);
        }
        return newUser;
    }
}
