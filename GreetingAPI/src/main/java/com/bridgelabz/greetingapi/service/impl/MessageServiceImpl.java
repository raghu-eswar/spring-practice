package com.bridgelabz.greetingapi.service.impl;

import com.bridgelabz.greetingapi.dao.MessageDao;
import com.bridgelabz.greetingapi.model.Message;
import com.bridgelabz.greetingapi.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageDao messageDao;

    @Override
    public Integer addMessage(Message message) {
        return messageDao.addMessage(message);
    }

    @Override
    public Message getMessage(int messageId) {
        return messageDao.getMessage(messageId);
    }
}
