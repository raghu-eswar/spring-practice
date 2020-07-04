package com.bridgelabz.greetingapi.service;

import com.bridgelabz.greetingapi.model.Message;
import com.bridgelabz.greetingapi.model.User;

public interface GreetingApiService {

    Integer addGreeting(User user, Message message);
}
