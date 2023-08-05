package com.skillsoft.reflection;

import java.lang.annotation.Retention; // @interface
import java.lang.annotation.RetentionPolicy; // enum

@Retention(RetentionPolicy.RUNTIME)
public @interface InRange {

    double minValue();

    double maxValue();
}
