package com.test.testApp.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class MyStringUtil {
    public static String join(Iterable iterable, String connector) {
        if (iterable == null) {
            throw new NullPointerException();
        }
        Iterator iterator = iterable.iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            if (next == null) {
                continue;
            }
            sb.append(next);
            if (connector != null) {
                sb.append(connector);
            }
        }
        String str = sb.toString();
        if (str.length() > 0) {
            int cLength = connector != null ? connector.length() : 0;
            return str.substring(0, str.length() - cLength);
        } else {
            return str;
        }
    }

    public static String join(Object[] objects, String connector) {
        if (objects == null) {
            throw new NullPointerException();
        }
        return join(new ArrayList<>(Arrays.asList(objects)), connector);
    }

    public static String joinSpecifiedField(Iterable iterable, String field, String connector) {
        if (iterable == null || field == null) {
            throw new NullPointerException();
        }
        return join(fileSpecifiedFieldToList(iterable, field), connector);
    }

    public static List<Object> fileSpecifiedFieldToList(Iterable iterable, String field) {
        if (iterable == null || field == null) {
            throw new NullPointerException();
        }
        ArrayList<Object> list = new ArrayList<>();
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            if (next != null) {
                Object fieldValue = null;
                if (next instanceof Map) {
                    fieldValue = ((Map) next).get(field);
                } else {
                    // next.getField();
                    try {
                        StringBuilder sb = new StringBuilder();
                        // field to getField
                        sb.append("get")
                                .append(field.substring(0, 1).toUpperCase())
                                .append(field.substring(1));
                        Method method = next.getClass().getDeclaredMethod(sb.toString());
//                        method.setAccessible(true);
                        fieldValue = method.invoke(next);
                    } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
//                        e.printStackTrace();
                    }

                    if (fieldValue == null) {
                        // next.field;
                        try {
                            Field declaredField = next.getClass().getDeclaredField(field);
                            fieldValue = declaredField.get(next);
                        } catch (NoSuchFieldException | IllegalAccessException e) {
//                            e.printStackTrace();
                        }
                    }
                }
                list.add(fieldValue);
            }
        }

        return list;
    }
}
