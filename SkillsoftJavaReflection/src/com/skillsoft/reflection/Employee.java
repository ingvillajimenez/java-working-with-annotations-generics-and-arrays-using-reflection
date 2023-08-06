package com.skillsoft.reflection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Required
public class Employee {

    private static final Random employeeIdGenerator = new Random();

    @Required
    private final int employeeId;

    @Required
    private String name;

    @Required
    private String title;

    @Required
    @InRange(minValue = 10000, maxValue = 1000000)
    private double salary;

    @Deprecated
    private String department = "Unknown";

    public Employee(String name, String title, double salary) {
        this.employeeId = Math.abs(employeeIdGenerator.nextInt());
        this.name = name;
        this.title = title;
        this.salary = salary;
    }

    @Required
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Deprecated // a function or method which is no longer going to be supported in future versions
    public String getDepartment() {
        return department;
    }

    @Deprecated(forRemoval = true, since = "v9") // flag for removal, in future versions there will be
    // a break and backward compatibility will no longer be maintained, since v9 method has been deprecated
    public void setDepartment(String department) {
        this.department = department;
    }

    @Deprecated
    @SuppressWarnings("unchecked") // tell the compiler not to flag certain operations with a warning,
    // those that have to do with unchecked data (we've suppressed warnings on unchecked type operations)
    public void printEmployeeDetails() {
        System.out.println(employeeId + name);

        List someList = new ArrayList<>(); // lacks type safety because we have not specified a type parameter
        someList.add("element in unchecked list");
    }

    @Override // overrides an implementation from some base class
    public String toString() {
        return String.format("ID: %d, Name: %s, Title: %s, Salary: %.1f",
                employeeId, name, title, salary);
    }
}
