package com.test.testApp.thread.chapter01.wait.demo;

import java.util.ArrayList;
import java.util.List;

public class Queue {
    public static int MAX_SIZE = 10;
    private List<String> list = new ArrayList<>();

    public void add(String s) {
        list.add(s);
        System.out.println(s + ": be add");
    }

    public String take() {
        String remove = list.remove(size() - 1);
        System.out.println(remove + ": be take");
        return remove;
    }

    public int size() {
        return list.size();
    }
}
