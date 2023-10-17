package com.sapient;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//Method Level Custom Annotation
@Target(ElementType.METHOD) //Meta Annotation
public @interface MyAnnotation {

}
