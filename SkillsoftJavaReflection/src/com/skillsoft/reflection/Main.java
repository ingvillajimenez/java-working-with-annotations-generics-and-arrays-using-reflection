package com.skillsoft.reflection;

public class Main {

    public static void main(String[] args) {

        // NOTE: You cannot tell what type your object has been parameterized to
        // You can tell that this is a parameterized instance, but you cannot tell
        // the type of parameter
        System.out.println("****************** Parameterizable class");

        Container<String> container = new Container<>("Hello");

        Class<?> containerClass = container.getClass();

        System.out.println("Container class: " + containerClass); // class com.skillsoft.reflection.Container
        System.out.println("Container class (generic string): " +
                containerClass.toGenericString()); // public class com.skillsoft.reflection.Container<T>
        System.out.println("Container class (superclass): " +
                containerClass.getSuperclass()); // class java.lang.Object
        System.out.println("Container class (generic superclass): " +
                containerClass.getGenericSuperclass()); // class java.lang.Object

        System.out.println();

        // NOTE: In this derived class, we can tell what type parameter we used to
        // define this class when we inherited from the base class.
        Container<Integer> integerContainer = new IntegerContainer(123);

        System.out.println("************* Non-parameterizable derived class (integer)");

        Class<?> integerContainerClass = integerContainer.getClass();

        System.out.println("IntegerContainer class: " + integerContainerClass); // class com.skillsoft.reflection.IntegerContainer
        System.out.println("IntegerContainer class (generic string): " +
                integerContainerClass.toGenericString()); // public class com.skillsoft.reflection.IntegerContainer
        System.out.println("IntegerContainer class (superclass): " +
                integerContainerClass.getSuperclass()); // class com.skillsoft.reflection.Container
        System.out.println("IntegerContainer class (generic superclass): " +
                integerContainerClass.getGenericSuperclass()); // com.skillsoft.reflection.Container<java.lang.Integer>
                // no information was lost
        System.out.println();

        // NOTE: In this derived class, we can tell what type parameter we used to
        // define this class when we inherited from the base class.
        Container<String> stringContainer = new StringContainer("Hello");

        System.out.println("************** Non-parameterizable derived class (string)");

        Class<?> stringContainerClass = stringContainer.getClass();

        System.out.println("StringContainer class: " + stringContainerClass); // class com.skillsoft.reflection.StringContainer
        System.out.println("StringContainer class (generic string): " +
                stringContainerClass.toGenericString()); // // public class com.skillsoft.reflection.StringContainer
        System.out.println("StringContainer class (superclass): " +
                stringContainerClass.getSuperclass()); // class com.skillsoft.reflection.Container
        System.out.println("StringContainer class (generic superclass): " +
                stringContainerClass.getGenericSuperclass()); // com.skillsoft.reflection.Container<java.lang.String>
                // type parameter of the superclass is java.lang.String
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