package com.bridgelabz.greetingapi.controller;

import com.bridgelabz.greetingapi.model.Greeting;
import com.bridgelabz.greetingapi.model.Message;
import com.bridgelabz.greetingapi.model.User;
import com.bridgelabz.greetingapi.service.GreetingApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("GreetingAPI")
public class GreetingController {

    @Autowired
    GreetingApiService greetingApiService;

    @PostMapping("user")
    public Message greetUser(@RequestBody User user) {
        Message message = new Message();
        message.setId(user.getId());
        message.setMessage("Hello");
        message.setUser(user);
        return message;
    }

    @PostMapping("AddGreeting")
    public Integer addGreeting(@RequestBody Greeting greeting) {
        return greetingApiService.addGreeting(greeting.getUser(), greeting.getMessage());
    }

}
