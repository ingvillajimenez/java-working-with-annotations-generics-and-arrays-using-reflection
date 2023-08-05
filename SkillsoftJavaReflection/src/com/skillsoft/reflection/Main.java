package com.skillsoft.reflection;

import java.lang.annotation.Annotation;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException,
            NoSuchMethodException {

        Class<?> employeeClass = Class.forName("com.skillsoft.reflection.Employee");

        // NOTE: This accesses annotations that are "present" on an element
        System.out.println("*********** @Required annotation using getAnnotation()");

        Annotation requiredClassAnnotation = employeeClass.getAnnotation(Required.class); // Annotation 'Required.class' is not retained for reflective access
        Annotation requiredFieldAnnotation = employeeClass
                .getDeclaredField("employeeId").getAnnotation(Required.class); // Annotation 'Required.class' is not retained for reflective access
        Annotation requiredMethodAnnotation = employeeClass
                .getDeclaredMethod("getEmployeeId").getAnnotation(Required.class); // Annotation 'Required.class' is not retained for reflective access

        System.out.println("Required class annotation: " + requiredClassAnnotation); // null for retention policies: source and class, @com.skillsoft.reflection.Required() for retention policy: runtime
        System.out.println("Required field annotation: " + requiredFieldAnnotation); // null for retention policies: source and class, @com.skillsoft.reflection.Required() for retention policy: runtime
        System.out.println("Required method annotation: " + requiredMethodAnnotation); // null for retention policies: source and class, @com.skillsoft.reflection.Required() for retention policy: runtime

        System.out.println();

        // NOTE: This access annotations that are "directly present" on an element
        System.out.println("********* @Required annotation using getDeclaredAnnotation()");

        requiredClassAnnotation = employeeClass.getDeclaredAnnotation(Required.class);
        requiredFieldAnnotation = employeeClass
                .getDeclaredField("employeeId").getDeclaredAnnotation(Required.class);
        requiredMethodAnnotation = employeeClass
                .getDeclaredMethod("getEmployeeId").getDeclaredAnnotation(Required.class);

        System.out.println("Required class annotation: " + requiredClassAnnotation); // null for retention policies: source and class, @com.skillsoft.reflection.Required() for retention policy: runtime
        System.out.println("Required field annotation: " + requiredFieldAnnotation); // null for retention policies: source and class, @com.skillsoft.reflection.Required() for retention policy: runtime
        System.out.println("Required method annotation: " + requiredMethodAnnotation); // null for retention policies: source and class, @com.skillsoft.reflection.Required() for retention policy: runtime

        System.out.println();
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