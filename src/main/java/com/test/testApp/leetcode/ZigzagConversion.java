package com.test.testApp.leetcode;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        int stepSize = stepSize(s, numRows);
        int singleStepWide = numRows - 1;
        int tempCharWide = ((s.length() / stepSize) + 1) * singleStepWide;
        Character[][] tempChar = new Character[numRows][tempCharWide];
        char[] retStrChar = new char[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            tempChar[getY(s, i, numRows)][getX(s, i, numRows)] = chars[i];
        }
        int retStrCharIndex = 0;
        for (int j = 0; j < tempChar.length; j++) {
            for (int k = 0; k < tempChar[j].length; k++) {
                if (tempChar[j][k] != null) {
                    retStrChar[retStrCharIndex] = tempChar[j][k];
                    retStrCharIndex++;
                }
            }
        }
        return new String(retStrChar);
    }

    public int getX(String s, int index, int numRows) {
        int x;
        int stepSize = stepSize(s, numRows);
        int innerIndex = index % stepSize;
        if (innerIndex < numRows) {
            x = (index / stepSize) * (numRows - 1);
        } else {
            x = (index / stepSize) * (numRows - 1) + (innerIndex - numRows + 1);
        }
        return x;
    }

    public int getY(String s, int index, int numRows) {
        int y;
        int stepSize = stepSize(s, numRows);
        int innerIndex = index % stepSize;
        if (innerIndex < numRows) {
            y = innerIndex;
        } else {
            y = numRows - (innerIndex - numRows + 2);
        }
        return y;
    }

    public int stepSize(String s, int numRows) {
        return numRows * 2 - 2;
    }

    public static void main(String[] args) {
        ZigzagConversion zigzagConversion = new ZigzagConversion();
        String paypalishiring = zigzagConversion.convert("PAYPALISHIRING", 4);
        System.out.println(paypalishiring);
    }

}
