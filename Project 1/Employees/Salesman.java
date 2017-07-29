package Employees;

/**
 * File: Salesman.java
 * Author: William Crutchfield
 * Date: Jan 17, 2017
 * Purpose: Create the Employee Subclass "Salesman". Contains name, monthlySalary, annualSales.
 */
public class Salesman extends Employee {

    // Variables
    private double annualSales;
    private double annualSalary = super.annualSalary();

    // Constructor
    public Salesman(String name, double monthlySalary, double annualSales) {
        super(name, monthlySalary);
        this.annualSales = annualSales;
    }

    // annualSalary
    @Override
    public double annualSalary() {
        // commission calculation
        double commission = annualSales * 0.02f;
        if (commission > 20000) {
            commission = 20000;
        }

        // Annual Salary calculation
        this.annualSalary += commission;

        return annualSalary;
    }

    // toString Method
    @Override
    public String toString() {
        return super.toString() + "\n\tAnnual Sales: $" + df.format(this.annualSales);
    }
}