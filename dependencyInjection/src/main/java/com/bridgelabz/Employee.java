package com.bridgelabz;

public class Employee {
    public String name;
    public String phoneNo;
    public Address address;

    public Employee(String name, String phoneNo, Address address) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", address=" + address +
                '}';
    }
}
