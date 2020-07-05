package com.bridgelabz.greetingapi.service;

import com.bridgelabz.greetingapi.model.Message;

public interface MessageService {

    Message addMessage(Message message);

    Message getMessage(int messageId);

    Message updateMessage(Message message, Message newMessage);

    Message deleteMessage(int messageId);
}
