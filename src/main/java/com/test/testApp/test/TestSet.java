package com.test.testApp.test;

import java.util.LinkedHashSet;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set<String> objects = new LinkedHashSet<>();
        objects.add("projectID01");
        objects.add("projectID01");
        objects.add("projectID02");
        objects.add("projectID03");

        for (String object : objects) {
            System.out.println(object);
        }
    }
}
