package com.bridgelabz.greetingapi.controller;

import com.bridgelabz.greetingapi.model.Greeting;
import com.bridgelabz.greetingapi.service.GreetingApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("GreetingAPI")
public class GreetingController {

    @Autowired
    GreetingApiService greetingApiService;

    @GetMapping("GetGreeting/{userId}")
    public Greeting getGreeting(@PathVariable("userId") int userId) {
        return greetingApiService.getGreeting(userId);
    }

    @PostMapping("AddGreeting")
    public Greeting addGreeting(@RequestBody Greeting greeting) {
        return greetingApiService.addGreeting(greeting);
    }

    @PutMapping("updateGreeting/{userId}")
    public Greeting updateGreeting(@RequestBody Greeting greeting, @PathVariable("userId") int userId) {
        return greetingApiService.updateGreeting(greeting, userId);
    }

    @DeleteMapping("deleteGreeting/{userId}")
    public Greeting deleteGreeting(@PathVariable("userId") int userId) {
        return greetingApiService.deleteGreeting(userId);
    }

}
