package com.bridgelabz.greetingapi.model;

public class Greeting {
    private Message message;
    private User user;

    public Greeting() {    }

    public Greeting(Message message, User user) {
        this.message = message;
        this.user = user;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
