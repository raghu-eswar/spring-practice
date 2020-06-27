package com.bridgelabz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class Company {
    public List<Employee> employees;
    public String name;

    public Company() { }

    public Company(String name, List<Employee> employees) {
        this.employees = employees;
        this.name = name;
    }

    @Autowired
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Value("bridgelabz")
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @PostConstruct
    private void init() {
        this.employees.forEach(employee -> employee.company = this);
    }

    @Override
    public String toString() {
        return "Company{" +
                "employees=" + employees +
                ", name='" + name + '\'' +
                '}';
    }
}
