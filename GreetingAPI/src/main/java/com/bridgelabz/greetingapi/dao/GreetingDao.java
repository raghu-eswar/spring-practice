package com.bridgelabz.greetingapi.dao;

import com.bridgelabz.greetingapi.model.Greeting;

public interface GreetingDao {
    Integer addGreeting(Greeting greeting);

    Greeting getGreeting(int greetingId);
}
