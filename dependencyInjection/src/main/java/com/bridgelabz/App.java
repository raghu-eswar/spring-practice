package com.bridgelabz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class App {
    private final static Logger LOGGER = Logger.getAnonymousLogger();
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Company company = (Company) context.getBean("company");
        LOGGER.info(company.toString());
    }
}
