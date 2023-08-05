package com.skillsoft.reflection;

import java.lang.annotation.Annotation; // interface Annotation
import java.lang.reflect.Constructor; // class Constructor<T>
import java.lang.reflect.Method; // class Method

public class Main {

    private static void printParameterDetailsAndAnnotations(
            Class<?>[] parameterTypes, Annotation[][] parameterAnnotations) {

        int index = 0;
        for (Class<?> parameterType : parameterTypes) {
            System.out.println("----------------------");
            System.out.println(parameterType);

            Annotation[] parameterAnnotation = parameterAnnotations[index];
            for (Annotation annotation : parameterAnnotation) {
                System.out.println(annotation);
            }
            index++;
        }

        System.out.println();
    }

    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchMethodException {

        Class<?> employeeClass = Class.forName("com.skillsoft.reflection.Employee");

        System.out.println("************* Annotations on constructor parameters");

        Constructor<?> constructor = employeeClass.getConstructor(String.class, String.class, double.class);

        Class<?>[] parameterTypes = constructor.getParameterTypes(); // array of class objects (parameters)
        Annotation[][] parameterAnnotations = constructor.getParameterAnnotations(); // two dimensional array of annotations objects

        printParameterDetailsAndAnnotations(parameterTypes, parameterAnnotations);
        //----------------------
        //class java.lang.String
        //@com.skillsoft.reflection.Required()
        //----------------------
        //class java.lang.String
        //@com.skillsoft.reflection.Required()
        //----------------------
        //double
        //@com.skillsoft.reflection.Required()
        //@com.skillsoft.reflection.InRange(minValue=10000.0, maxValue=1000000.0)

        Method setNameMethod = employeeClass.getMethod("setName", String.class);
        printParameterDetailsAndAnnotations(
                setNameMethod.getParameterTypes(), setNameMethod.getParameterAnnotations());
        //----------------------
        //class java.lang.String
        //@com.skillsoft.reflection.Required()

        Method setTitleMethod = employeeClass.getMethod("setTitle", String.class);
        printParameterDetailsAndAnnotations(
                setTitleMethod.getParameterTypes(), setTitleMethod.getParameterAnnotations());
        //----------------------
        //class java.lang.String
        //@com.skillsoft.reflection.Required()
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