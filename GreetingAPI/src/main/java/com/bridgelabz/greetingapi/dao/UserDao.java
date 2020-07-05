package com.bridgelabz.greetingapi.dao;

import com.bridgelabz.greetingapi.model.User;

public interface UserDao {

    User addUser(User user, int messageId);

    User getUser(int userId);

    User updateUser(User newUser);
}
