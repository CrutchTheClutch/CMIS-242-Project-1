package Employees;

import java.text.DecimalFormat;

/**
 * File: Employee.java
 * Author: William Crutchfield
 * Date: Jan 17, 2017
 * Purpose: Create the "Employee" Class. Contains name, monthlySalary.
 */
public class Employee {

    // Variables
    private String name;
    private double monthlySalary;
    static DecimalFormat df = new DecimalFormat("###");

    // Constructor
    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    // annualSalary Method
    public double annualSalary() {
        return monthlySalary * 12;
    }

    // toString Method
    public String toString() {
        return "\n\tName: " + name + "\n\tMonthly Salary: $" + df.format(this.monthlySalary) + "\n\tAnnual Salary: $" + df.format(this.annualSalary());
    }
}