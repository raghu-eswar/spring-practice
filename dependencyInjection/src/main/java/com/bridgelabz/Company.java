package com.bridgelabz;

import java.util.List;

public class Company {
    public List<Employee> employees;
    public String name;

    public Company(String name, List<Employee> employees) {
        this.employees = employees;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "employees=" + employees +
                ", name='" + name + '\'' +
                '}';
    }
}
