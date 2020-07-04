package com.bridgelabz.greetingapi.dao;

import com.bridgelabz.greetingapi.model.User;

public interface UserDao {

    Integer addUser(User user);

    User getUser(int userId);
}
