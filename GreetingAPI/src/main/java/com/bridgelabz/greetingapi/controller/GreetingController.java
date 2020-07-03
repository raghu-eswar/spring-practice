package com.bridgelabz.greetingapi.controller;

import com.bridgelabz.greetingapi.model.Message;
import com.bridgelabz.greetingapi.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class GreetingController {

    @PostMapping("user")
    public Message greetUser(@RequestBody User user) {
        Message message = new Message();
        message.setId(user.getId());
        message.setMessage("Hello");
        message.setUser(user);
        return message;
    }

}
