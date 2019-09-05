package com.test.testApp.jvm;

import java.util.ArrayList;

public class OOMTestClass {
    public void run() {
        int[] a;
        ArrayList<Object> objects = new ArrayList<>();
        while (true) {
            a = new int[100];
            objects.add(a);
        }
    }
}
