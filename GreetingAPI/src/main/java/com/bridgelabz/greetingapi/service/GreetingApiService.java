package com.bridgelabz.greetingapi.service;

import com.bridgelabz.greetingapi.model.Greeting;

public interface GreetingApiService {

    Greeting addGreeting(Greeting greeting);

    Greeting getGreeting(int greetingId);

    Greeting updateGreeting(Greeting greeting, int userId);
}
