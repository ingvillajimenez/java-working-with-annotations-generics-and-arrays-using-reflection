package com.skillsoft.reflection;

import java.lang.reflect.Array; // class Array
import java.util.Arrays; // class Arrays

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        int[] intArray = (int[]) Array.newInstance(int.class, 3);
        String[] stringArray = (String[]) Array.newInstance(String.class, 3);

        System.out.println("***** Class");

        System.out.println(intArray.getClass()); // class [I
        System.out.println(stringArray.getClass()); // class [Ljava.lang.String;

        System.out.println();

        System.out.println("***** IsArray");

        System.out.println("intArray: " + intArray.getClass().isArray()); // true
        System.out.println("stringArray: " + stringArray.getClass().isArray()); // true

        System.out.println();

        System.out.println("intArray: " + intArray.getClass().getComponentType()); // int
        System.out.println("stringArray: " + stringArray.getClass().getComponentType()); // class java.lang.String

        System.out.println();
//
//        System.out.println("***** creating multi-dimensional int arrays");
//
//        Class<?> intArrayClass = Class.forName("[I");
//
//        System.out.println(intArrayClass); // class [I
//
//        int[][] intArray = (int[][]) Array.newInstance(intArrayClass, 3);
//
//        Array.set(intArray, 0, new int[] {123});
//        Array.set(intArray, 1, new int[] {456});
//        Array.set(intArray, 2, new int[] {789});
//
//        for (int[] oneArray : intArray) {
//            System.out.println(Arrays.toString(oneArray));
//            //[123]
//            //[456]
//            //[789]
//        }
//
//        System.out.println();
//
//        System.out.println("***** creating multi-dimensional string arrays");
//
//        Class<?> stringArrayClass = Class.forName("[Ljava.lang.String;");
//
//        System.out.println(stringArrayClass); // class [Ljava.lang.String;
//
//        String[][] stringArray = (String[][]) Array.newInstance(stringArrayClass, 3);
//
//        Array.set(stringArray, 0, new String[] {"Alice"});
//        Array.set(stringArray, 1, new String[] {"Bob"});
//        Array.set(stringArray, 2, new String[] {"Charlie"});
//
//        for (String[] oneArray : stringArray) {
//            System.out.println(Arrays.toString(oneArray));
//            //[Alice]
//            //[Bob]
//            //[Charlie]
//        }
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