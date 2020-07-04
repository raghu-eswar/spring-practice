package com.bridgelabz.greetingapi.service.impl;

import com.bridgelabz.greetingapi.dao.GreetingDao;
import com.bridgelabz.greetingapi.model.Greeting;
import com.bridgelabz.greetingapi.service.GreetingApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GreetingApiServiceImpl implements GreetingApiService {

    @Autowired
    GreetingDao greetingDao;

    @Override
    @Transactional
    public Integer addGreeting(Greeting greeting) {
        return greetingDao.addGreeting(greeting);
    }
}
