package com.bridgelabz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Employee {
    private String name;
    private String phoneNo;
    private Address address;
    public Company company;

    public Employee(String name, String phoneNo) {
        this.name = name;
        this.phoneNo = phoneNo;
    }

    public Employee(String name, String phoneNo, Address address) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Autowired
    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    @PostConstruct
    private void init() {
        this.address.employee = this;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", address=" + address +
                ", company=" + company.getName() +
                '}';
    }
}
