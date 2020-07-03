package com.bridgelabz.greetingapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class GreetingController {

    @RequestMapping(value = {"", "home"})
    public String sayHello() {
        return "Hello World!...";
    }

    @GetMapping("user")
    public String sayHello(@RequestParam(value = "name") String name) {
        return "Hello "+name+" ...";
    }

}
