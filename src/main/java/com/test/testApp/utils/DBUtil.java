package com.test.testApp.utils;

import java.util.HashMap;
import java.util.Map;

public class DBUtil {

    public final static String FIELD_SEPARATOR = "__";

    public static Map resultToMap(Map<String, Object> originResult) {
        Map<String, Object> newResult = new HashMap<>();
        if (originResult == null) {
            return newResult;
        }

        for (Map.Entry<String, Object> next : originResult.entrySet()) {
            String key = next.getKey();
            String[] split = key.split(FIELD_SEPARATOR);
            Object value = next.getValue();
            Map<String, Object> filedMap = newResult;
            for (int i = 0; i < split.length; i++) {
                String splitKey = split[i];
                if (i == split.length - 1) {
                    filedMap.put(splitKey, value);
                } else {
                    Object newFieldMap = filedMap.get(splitKey);
                    if (!(newFieldMap instanceof Map)) {
                        newFieldMap = new HashMap<String, Object>();
                    }
                    filedMap.put(splitKey, newFieldMap);
                    filedMap = (Map<String, Object>) newFieldMap;
                }
            }
        }
        return newResult;
    }

    public static void main(String[] args) {
        HashMap<String, Object> row01 = new HashMap<>();
        row01.put("A__f1","001");
        row01.put("A__f5","005");
        row01.put("A__B__f2","002");
        row01.put("A__B__f4","004");
        row01.put("A__B__C__f8","004");
        row01.put("f9","003");
        row01.put("f10","003");
        row01.put("f11","003");

        Map map = resultToMap(row01);
        System.out.println(map);
    }
}
