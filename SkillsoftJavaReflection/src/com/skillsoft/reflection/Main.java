package com.skillsoft.reflection;

import java.lang.reflect.Array; // class Array
import java.util.Arrays; // class Arrays

public class Main {

    public static void main(String[] args) {

        System.out.println("******* creating arrays");

        int[] intArray = (int[]) Array.newInstance(int.class, 3);
        String[] stringArray = (String[]) Array.newInstance(String.class, 3);

        System.out.println(intArray.getClass()); // class [I
        System.out.println(stringArray.getClass()); // class [Ljava.lang.String;

        System.out.println();

        System.out.println("***** set and get on int array");

        Array.set(intArray, 0, 10);
        Array.set(intArray, 1, 20);
        Array.set(intArray, 2, 30);

        System.out.println(Arrays.toString(intArray)); // [10, 20, 30]

        System.out.println("Element at index 2: " + Array.get(intArray, 2)); // 30
        System.out.println("Element at index 1: " + Array.get(intArray, 1)); // 20
        System.out.println("Element at index 0: " + Array.get(intArray, 0)); // 10

        System.out.println();

        System.out.println("***** set and get on string array");

        Array.set(stringArray, 0, "Jason");
        Array.set(stringArray, 1, "Julie");
        Array.set(stringArray, 2, "Jonas");

        System.out.println(Arrays.toString(stringArray)); // [Jason, Julie, Jonas]

        System.out.println("Element at index 2: " + Array.get(stringArray, 2)); // Jonas
        System.out.println("Element at index 1: " + Array.get(stringArray, 1)); // Julie
        System.out.println("Element at index 0: " + Array.get(stringArray, 0)); // Jason

        System.out.println();

//        System.out.println("************* primitive types");
//
//        int[] intArray = new int[] {10, 20, 30};
//        float[] floatArray = new float[] {10.1f, 20.2f, 30.3f};
//        boolean[] booleanArray = new boolean[] {true, false, true};
//
//        System.out.println(intArray.getClass()); // class [I
//        System.out.println(floatArray.getClass()); // class [F
//        System.out.println(booleanArray.getClass()); // class [Z
//
//        System.out.println();
//
//        System.out.println("*********** objects");
//
//        Integer[] integerArray = new Integer[] {10, 20, 30};
//        Double[] doubleArray = new Double[] {10.1, 20.2, 30.3};
//        String[] stringArray = new String[] {"Alice", "Bob", "Charlie"};
//
//        System.out.println(integerArray.getClass()); // class [Ljava.lang.Integer;
//        System.out.println(doubleArray.getClass()); // class [Ljava.lang.Double;
//        System.out.println(stringArray.getClass()); // class [Ljava.lang.String;
//
//        System.out.println();
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