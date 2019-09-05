package com.test.testApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MySplit {

    public static List<String> split(String str, String[] tokens) {
        if (str == null || tokens == null) {
            throw new IllegalArgumentException();
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < tokens.length; i++) {
            if (i == 0) {
                list = new ArrayList<>(Arrays.asList(str.split(tokens[i])));
            } else {
                List<String> tmp = new ArrayList<>();
                for (String strTmp : list) {
                    tmp.addAll(Arrays.asList(strTmp.split(tokens[i])));
                }
                list = tmp;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String str = "abc,def.ghi";
        String[] tokens = new String[]{"ef", "c"};
        List<String> split = split(str, null);
        for (String s : split) {
            System.out.println(s);
        }
    }
}
