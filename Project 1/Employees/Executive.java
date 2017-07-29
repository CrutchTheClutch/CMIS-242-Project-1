package Employees;

/**
 * File: Salesman.java
 * Author: William Crutchfield
 * Date: Jan 17, 2017
 * Purpose: Create the Employee SubClass "Salesman". Contains name, monthlySalary, stockPrice.
 */
public class Executive extends Employee {

    // Variables
    private double stockPrice;
    private double annualSalary = super.annualSalary();

    // Constructor
    public Executive(String name, double monthlySalary, double stockPrice) {
        super(name, monthlySalary);
        this.stockPrice = stockPrice;
    }

    // annualSalary
    @Override
    public double annualSalary() {
        // bonus calculation
        double bonus;
        if (stockPrice > 50) {
            bonus = 30000;
        } else {
            bonus = 0;
        }

        // Annual Salary calculation
        this.annualSalary += bonus;

        return annualSalary;
    }

    // toString Method
    @Override
    public String toString() {
        return super.toString() + "\n\tStock Price: $" + df.format(this.stockPrice);
    }
}
