package Employees;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

/**
 * File: Salesman.java
 * Author: William Crutchfield
 * Date: Jan 17, 2017
 * Description: Reads a txt file of Employee data and puts the data into one of two arrays.
 * There is an array for 2014 data, and one for 2015 data. Then, prints out both arrays, as well as the
 * average salaries for each year.
 */
public class TestEmployees {

    // Variables
    private static DecimalFormat df = new DecimalFormat("###");
    private Employee[] arr2014 = new Employee[5];   // Array for 2014 Employees
    private Employee[] arr2015 = new Employee[5];   // Array for 2015 Employees
    private int count2014 = -1;                     // Count for 2014 Employees
    private int count2015 = -1;                     // Count for 2015 Employees

    private void file() throws FileNotFoundException {

        // Reads txt file
        Scanner input = new Scanner(new File("EmployeeInfo.txt"));

        // Loops for each line in file with data
        while (input.hasNext()) {
            int year = input.nextInt();
            String pos = input.next();
            String name = input.next();
            double monthlySalary = input.nextDouble();

            // Increments count for appropriate year
            if (year == 2014) {         // 2014
                count2014 += 1;
            } else if (year == 2015) {  // 2015
                count2015 += 1;
            }

            // Adds data to array for appropriate type of Employee
            switch (pos) {
                case "Salesman":    // Salesman
                    double annualSales = input.nextDouble();
                    if (year == 2014) {
                        arr2014[count2014] = (new Salesman(name, monthlySalary, annualSales));
                    } else if (year == 2015) {
                        arr2015[count2015] = (new Salesman(name, monthlySalary, annualSales));
                    }
                    break;
                case "Executive":   // Executive
                    double stockPrice = input.nextDouble();
                    if (year == 2014) {
                        arr2014[count2014] = (new Executive(name, monthlySalary, stockPrice));
                    } else if (year == 2015) {
                        arr2015[count2015] = (new Executive(name, monthlySalary, stockPrice));
                    }
                    break;
                default:            // Employee (default)
                    if (year == 2014) {
                        arr2014[count2014] = (new Employee(name, monthlySalary));
                    } else if (year == 2015) {
                        arr2015[count2015] = (new Employee(name, monthlySalary));
                    }
                    break;
            }
        }
    }

    private void display() {

        // Variables
        double average2014 = 0;
        double average2015 = 0;

        // Print each employee 2014
        System.out.println("2014:");
        for (Employee e : arr2014) {
            System.out.println(e.toString());   // Employee toString
            average2014 += e.annualSalary();    // calculate average
        }

        // Calculate Average Salary 2014
        average2014 = average2014 / arr2014.length;
        System.out.println("\n2014 Average Salary: $" + df.format(average2014));
        System.out.println("==============================");

        // Print each employee 2015
        System.out.println("\n2015:");
        for (Employee e : arr2015) {
            System.out.println(e.toString());   // Employee toString
            average2015 += e.annualSalary();    // calculate average
        }

        // Calculate Average Salary 2015
        average2015 = average2015 / arr2015.length;
        System.out.println("\n2015 Average Salary: $" + df.format(average2015));
        System.out.println("==============================");
    }

    public static void main(String[] args) throws FileNotFoundException {
        TestEmployees main = new TestEmployees();
        main.file();
        main.display();
    }
}
