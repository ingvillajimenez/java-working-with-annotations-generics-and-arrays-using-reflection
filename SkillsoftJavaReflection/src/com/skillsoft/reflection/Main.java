package com.skillsoft.reflection;

import java.lang.reflect.Field; // class Field
import java.lang.reflect.Method; // class Method
import java.lang.reflect.ParameterizedType; // interface ParameterizedType extends Type
import java.lang.reflect.Type; // interface Type
import java.util.Arrays; // class Arrays

public class Main {

    private static void printParameterizedTypeDetails(ParameterizedType parameterizedType) {
        Type[] typeArguments = parameterizedType.getActualTypeArguments();

        for (Type typeArgument : typeArguments) {
            System.out.println("Type: " + typeArgument);
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {

        Container<String> container = new Container<>("Hello");
        ContainerWrapper containerWrapper = new ContainerWrapper(container); // Raw use of parameterized class 'ContainerWrapper'
//        ContainerWrapper<String> containerWrapper = new ContainerWrapper<>(container);

        System.out.println("************ Parameterized return type");
        Method getContainerMethod = containerWrapper.getClass().getMethod("getContainer");

        System.out.println("getContainer() return type: " + getContainerMethod.getReturnType()); // class com.skillsoft.reflection.Container
        System.out.println("getContainer() generic return type: " + getContainerMethod.getGenericReturnType()); // com.skillsoft.reflection.Container<T>

        printParameterizedTypeDetails((ParameterizedType) getContainerMethod.getGenericReturnType()); // T

        System.out.println();

        System.out.println("************* Parameterized input parameters");

        Method setContainerMethod = containerWrapper.getClass().getMethod("setContainer", Container.class);

        System.out.println("setContainer(Container) parameter type: " +
                Arrays.toString(setContainerMethod.getParameterTypes())); // [class com.skillsoft.reflection.Container]
        System.out.println("setContainer(Container) generic parameter type: " +
                Arrays.toString(setContainerMethod.getGenericParameterTypes())); // [com.skillsoft.reflection.Container<T>]

        printParameterizedTypeDetails((ParameterizedType) (setContainerMethod.getGenericParameterTypes()[0])); // T

        System.out.println();

        System.out.println("************* Parameterized field");

        Field containerField = containerWrapper.getClass().getDeclaredField("container");

        System.out.println("container field type: " + containerField.getType()); // class com.skillsoft.reflection.Container
        System.out.println("container field generic type: " + containerField.getGenericType()); // com.skillsoft.reflection.Container<T>

        printParameterizedTypeDetails((ParameterizedType) (containerField.getGenericType())); // T

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

// generics and reflection don't mix very well. They aren't very reliable when used together