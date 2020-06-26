package com.bridgelabz;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean(name = "company")
    public Company getCompany() {
        return new Company("bridglabz");
    }

    @Bean(name = "employees")
    public List<Employee> getEmployees() {
        return Arrays.asList(getEmployee1(), getEmployee2());
    }
    @Bean(name = "employee1")
    public Employee getEmployee1() {
        return new Employee("employee1", "111111111");
    }

    @Bean(name = "employee2")
    public Employee getEmployee2() {
        return new Employee("employee2", "111111111");
    }

    @Bean(name = "address")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Address getAddress() {
        return new Address("city", "state", "zip");
    }
}
