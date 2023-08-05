package com.skillsoft.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        Class<?> employeeClass = Class.forName("com.skillsoft.reflection.Employee");

        System.out.println("*************** Field annotations");

        Field[] fields = employeeClass.getDeclaredFields();

        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            if (annotations.length > 0) {
                System.out.println("----------");
                System.out.println(field.getName());
                System.out.println("Annotations: " + Arrays.toString(annotations));
            }
            //----------
            //department
            //Annotations: [@java.lang.Deprecated(forRemoval=false, since="")]
        }

        System.out.println("****************** Method annotations");

        Method[] methods = employeeClass.getDeclaredMethods();

        // NOTE: @Override and @SuppressWarnings annotations are not available at runtime
        // The JVM does not have access to these annotations
        for (Method method : methods) {
            Annotation[] annotations = method.getAnnotations();
            if (annotations.length > 0) {
                System.out.println("-----------");
                System.out.println(method.getName());
                System.out.println("Annotations: " + Arrays.toString(annotations));
            }
            //-----------
            //getDepartment
            //Annotations: [@java.lang.Deprecated(forRemoval=false, since="")]
            //-----------
            //setDepartment
            //Annotations: [@java.lang.Deprecated(forRemoval=true, since="v9")]
            //-----------
            //printEmployeeDetails
            //Annotations: [@java.lang.Deprecated(forRemoval=false, since="")]
        }
    }

}

// https://docs.oracle.com/javase/8/docs/api/java/lang/annotation/Annotation.html
// Java Docs for Reflection APIs for java.lang.annotation.Annotation

// @SuppressWarnings() - retention policy of source
// @Override - retention policy of source
// @Deprecated - retention policy of runtime