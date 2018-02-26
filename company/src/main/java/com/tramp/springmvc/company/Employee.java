package com.tramp.springmvc.company;

import java.math.BigDecimal;

public class Employee {
    private String firstname;
    private String lastname;
    private BigDecimal salary;

    public Employee(String firstname, String lastname, BigDecimal salary) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}
