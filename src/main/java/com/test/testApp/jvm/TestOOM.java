package com.test.testApp.jvm;

import java.util.ArrayList;

public class TestOOM {
    public static void main(String[] args) {
        OOMTestClass oomTestClass = new OOMTestClass();
        oomTestClass.run();
    }
}
