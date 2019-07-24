package com.test.testApp.algorithms.string;

import java.util.ArrayList;
import java.util.List;

public class TwoBigNumAdd {
    public static void main(String[] args) {
        String num1 = "-22";
        String num2 = "+10";
        System.out.println(methodAdd(num1, num2));
    }

    public static String methodAdd(String num1, String num2) {

        // 获取正负
        char symbol01 = strSymbol(num1);
        char symbol02 = strSymbol(num2);

        // 移除正负
        num1 = removeSymbol(num1);
        num2 = removeSymbol(num2);

        int index01 = num1.length() - 1;
        int index02 = num2.length() - 1;

        List<Integer> list = new ArrayList<>();
        int nextBit = 0; //进位
        int bitSum = 0;
        while (index01 >= 0 || index02 >= 0 || nextBit != 0) {
            // 进位相加处理
            bitSum += nextBit;

            // 位相加处理
            if (index01 >= 0) {
                bitSum += charToInt(num1.charAt(index01), symbol01);
            }
            if (index02 >= 0) {
                bitSum += charToInt(num2.charAt(index02), symbol02);
            }

            list.add(Math.abs(bitSum % 10));
            nextBit = nextBit(bitSum);
            bitSum = 0;
            index01--;
            index02--;
        }
        return listToString(list);
    }

    public static int nextBit(int bitSum) {
        if (bitSum >= 10) {
            return 1;
        } else if (bitSum < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public static int charToInt(char bitNum, char bitSymbol) {
        int num = bitNum - '0';
        if (num < 0 || num > 9) {
            throw new IllegalArgumentException();
        }
        return bitSymbol == '-' ? 0 - num : num;
    }

    public static char strSymbol(String num) {
        if (num.charAt(0) == '-') {
            return '-';
        } else {
            return '+';
        }
    }

    public static String removeSymbol(String num) {
        if (num.charAt(0) == '+' || num.charAt(0) == '-') {
            return num.substring(1, num.length());
        } else {
            return num;
        }
    }

    public static String listToString(List list) {
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

}
