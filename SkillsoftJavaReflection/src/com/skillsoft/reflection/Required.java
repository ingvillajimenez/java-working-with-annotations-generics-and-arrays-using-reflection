package com.skillsoft.reflection;

import java.lang.annotation.Retention; // @interface (Retention annotation)
import java.lang.annotation.RetentionPolicy; // enum

// NOTE: Annotations are to be recorded in the class file by the compiler and retained by
// the VM at run time, so they may be read reflectively
@Retention(RetentionPolicy.RUNTIME)

//// NOTE: Annotations are to be recorded in the class file by the compiler but
//// need not be retained by the VM at run time
//@Retention(RetentionPolicy.CLASS)

// NOTE: Annotation can be discarded by the compiler
//@Retention(RetentionPolicy.SOURCE)
public @interface Required {
}
