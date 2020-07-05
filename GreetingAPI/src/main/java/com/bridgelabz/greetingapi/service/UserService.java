package com.bridgelabz.greetingapi.service;

import com.bridgelabz.greetingapi.model.User;

public interface UserService {
    User addUser(User user, int messageId);

    User getUser(int user_id);

    User updateUser(User user, User newUser);
}
