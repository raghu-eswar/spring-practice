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
    public Greeting addGreeting(Greeting greeting) {
        Message message = messageService.addMessage(greeting.getMessage());
        User user = userService.addUser(greeting.getUser(), message.getId());
        return new Greeting(message, user);
    }

    @Override
    public Greeting getGreeting(int userId) {
        User user = userService.getUser(userId);
        Message message = messageService.getMessage(user.getMessageId());
        return new Greeting(message, user);
    }

    @Override
    @Transactional
    public Greeting updateGreeting(Greeting greeting, int userId) {
        User user = userService.getUser(userId);
        Message message = messageService.getMessage(user.getMessageId());
        message = messageService.updateMessage(message, greeting.getMessage());
        User newUser = greeting.getUser();
        if (newUser != null) {
            newUser.setMessageId(message.getId());
            user = userService.updateUser(user, newUser);
        }
        return new Greeting(message, user);
    }
}
