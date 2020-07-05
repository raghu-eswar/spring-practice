package com.bridgelabz.greetingapi.dao;

import com.bridgelabz.greetingapi.model.Message;

public interface MessageDao {

    Message addMessage(Message message);

    Message getMessage(int messageId);

    Message updateMessage(int messageId, Message message);

    Message deleteMessage(int messageId);
}
