package com.test.testApp.test.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestReflect {
    public static void main(String[] args) throws InterruptedException {
        Class<TestInterface> testInterfaceClass = TestInterface.class;
        Method[] declaredMethods = testInterfaceClass.getDeclaredMethods();
        Thread.sleep(10000000);
        for (Method declaredMethod : declaredMethods) {
            Annotation[] annotations = declaredMethod.getAnnotations();
            for (Annotation annotation : annotations) {
                if(annotation instanceof TestAnnotation){
                    String[] value = ((TestAnnotation) annotation).value();
                    System.out.println(1);
                }
            }
        }
//        while (true);
    }
}
