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

    @GetMapping("GetGreeting/{greetingId}")
    public Greeting getGreeting(@PathVariable("greetingId") int greetingId) {
        return greetingApiService.getGreeting(greetingId);
    }

    @PostMapping("AddGreeting")
    public Integer addGreeting(@RequestBody Greeting greeting) {
        return greetingApiService.addGreeting(greeting);
    }

}
