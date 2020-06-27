package com.bridgelabz;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.bridgelabz");
        context.refresh();
        Person person = (Person) context.getBean("person");
        person.eat();
        person.sleep();
    }
}
