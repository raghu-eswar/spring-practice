package com.bridgelabz.greetingapi.service;

import com.bridgelabz.greetingapi.model.Greeting;

public interface GreetingApiService {

    Integer addGreeting(Greeting greeting);

    Greeting getGreeting(int greetingId);
}
