package com.test;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();

        map.put("001","001");
        map.put("001","001");
        map.put("002","002");
        map.put("003","003");

        for (Map.Entry entry : map.entrySet()) {
            System.out.println("requestId is: "+ entry.getKey() + " projectNo is: " + entry.getValue());
        }
    }
}
