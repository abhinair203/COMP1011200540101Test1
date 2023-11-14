package com.example.comp1011200540101test1.Model;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Employee {
    private int id;
    private String name;
    private Date birthday;
    private String department;
    private String email;
    private int salary;

    public Employee(int id, String firstName, String lastName, Date birthday, String department, String email, int salary) {
        if (!(id > 0)) {
            throw new IllegalArgumentException("Id should be greater than zero");
        }
        if (firstName.trim().isEmpty() || firstName.startsWith(" ") || firstName.endsWith(" ")) {
            throw new IllegalArgumentException("First Name should not be blank and should not start or end with blank");
        }
        if (lastName.trim().isEmpty() || lastName.startsWith(" ") || lastName.endsWith(" ")) {
            throw new IllegalArgumentException("Last Name should not be blank and should not start or end with blank");
        }
        if (birthday.after(new Date())) {
            throw new IllegalArgumentException("Birthday should not be in the future");
        }

        Set<String> validDepartments = new HashSet<>(Arrays.asList("Sales", "Marketing", "Finance", "HR", "IT", "Research"));
        if (!validDepartments.contains(department)) {
            throw new IllegalArgumentException("Department should be one of: Sales, Marketing, Finance, HR, IT, Research");
        }

        email = email.trim();
        if (email.length() < 5 || !email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Email should be at least 5 characters and contain '@' and '.'");
        }

        if (salary <= 50000) {
            throw new IllegalArgumentException("Salary should be greater than 50,000");
        }

        this.id = id;
        this.name=firstName+' ' +lastName;
        this.birthday = birthday;
        this.department = department;
        this.email = email;
        this.salary = salary;
    }

    public int getAge() {
        return Period.between(this.birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears();
    }
}
