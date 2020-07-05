package com.bridgelabz.greetingapi.service.impl;

import com.bridgelabz.greetingapi.model.Greeting;
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
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public Integer addGreeting(Greeting greeting) {
        Integer messageId = messageService.addMessage(greeting.getMessage());
        return userService.addUser(greeting.getUser(), messageId);
    }

    @Override
    public Greeting getGreeting(int userId) {
        User user = userService.getUser(userId);
        Message message = messageService.getMessage(user.getMessageId());
        return new Greeting(message, user);
    }
}
