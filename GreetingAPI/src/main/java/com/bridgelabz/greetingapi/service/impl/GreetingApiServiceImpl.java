package com.bridgelabz.greetingapi.service.impl;

import com.bridgelabz.greetingapi.model.Message;
import com.bridgelabz.greetingapi.model.User;
import com.bridgelabz.greetingapi.service.GreetingApiService;
import com.bridgelabz.greetingapi.service.MessageService;
import com.bridgelabz.greetingapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GreetingApiServiceImpl implements GreetingApiService {

    @Autowired
    UserService userService;

    @Autowired
    MessageService messageService;

    @Override
    @Transactional
    public Integer addGreeting(User user, Message message) {
        userService.addUser(user);
        return messageService.addMessage(message);
    }
}
