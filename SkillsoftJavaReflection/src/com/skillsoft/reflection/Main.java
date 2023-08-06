package com.skillsoft.reflection;

import java.lang.annotation.Annotation; // interface Annotation
import java.lang.reflect.Field; // Class

public class Main {

    private static void checkEmployeeObjectForValidity(Employee employee)
            throws IllegalAccessException {

        boolean valid = true;
        Field[] fields = employee.getClass().getDeclaredFields();

        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();

            for (Annotation annotation : annotations) {
                if (annotation instanceof Required) {
                    field.setAccessible(true);

                    if (field.get(employee) == null) {
                        valid = false;
                        System.out.println("** Field is null: " + field.getName());
                    }
                }

                if (annotation instanceof InRange) {
                    InRange inRange = (InRange) annotation;

                    double value = field.getDouble(employee);

                    if (value < inRange.minValue() || value > inRange.maxValue()) {
                        valid = false;
                        System.out.println(String.format("** Field is not in range: %s (%.1f %.1f)",
                                field.getName(), inRange.minValue(), inRange.maxValue()));
                    }
                }
            }
        }

        if (valid) {
            System.out.println("All fields are valid! " + employee);
        } else {
            System.out.println("Please fix issues with invalid fields " + employee);
        }

    }

    public static void main(String[] args) throws IllegalAccessException {

        System.out.println("************* object is valid");
        Employee employee = new Employee("John", "VP", 112000);
        checkEmployeeObjectForValidity(employee);
        // All fields are valid! ID: 1566738542, Name: John, Title: VP, Salary: 112000.0

        System.out.println("*********** object is invalid");
        employee = new Employee("Jill", null, 112000);
        checkEmployeeObjectForValidity(employee);
        //** Field is null: title
        //Please fix issues with invalid fields ID: 1519452568, Name: Jill, Title: null, Salary: 112000.0

        System.out.println("************* objedct is invalid");
        employee = new Employee(null, null, 112000);
        checkEmployeeObjectForValidity(employee);
        //** Field is null: name
        //** Field is null: title
        //Please fix issues with invalid fields ID: 989137496, Name: null, Title: null, Salary: 112000.0

        System.out.println("*********** object is invalid");
        employee = new Employee("Nick", "Manager", 5000);
        checkEmployeeObjectForValidity(employee);
        //** Field is not in range: salary (10000.0 1000000.0)
        //Please fix issues with invalid fields ID: 440619892, Name: Nick, Title: Manager, Salary: 5000.0
    }

}

// https://docs.oracle.com/javase/8/docs/api/java/lang/annotation/Annotation.html
// Java Docs for Reflection APIs for java.lang.annotation.Annotation

// @SuppressWarnings() - retention policy of source
// @Override - retention policy of source
// @Deprecated - retention policy of runtime

// https://docs.oracle.com/javase/8/docs/api/java/lang/annotation/Target.html
// https://docs.oracle.com/javase/8/docs/api/java/lang/annotation/Retention.html
// Java Docs for Retention and Target policies