package com.bridgelabz.greetingapi.dao;

import com.bridgelabz.greetingapi.model.Message;

public interface MessageDao {

    Integer addMessage(Message message);

    Message getMessage(int messageId);
}
