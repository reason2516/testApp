package com.test.reflect;

import java.lang.annotation.*;

@Target(value = {ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAnnotation {
    String[] value() default {};
}
