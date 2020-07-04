package com.bridgelabz.greetingapi.service;

import com.bridgelabz.greetingapi.model.Message;

public interface MessageService {

    Integer addMessage(Message message);

    Message getMessage(int messageId);
}
