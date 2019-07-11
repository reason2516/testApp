package com.test.testApp.test.reflect;

public interface TestInterface {

    @TestAnnotation(value = {"SELECT * FROM fh_order WHERE 1=1"})
    void testFun();
}
