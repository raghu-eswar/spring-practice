package com.bridgelabz;

import java.util.List;

public class Company {
    public List<Employee> employees;
    public String name;

    public Company() {    }

    public Company(String name, List<Employee> employees) {
        this.employees = employees;
        this.name = name;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

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
