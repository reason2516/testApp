package com.test.testApp.leetcode;

public class StringToIntegerAtoi {

    /**
     * Implement atoi which converts a string to an integer.
     * <p>
     * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
     * <p>
     * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
     * <p>
     * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
     * <p>
     * If no valid conversion could be performed, a zero value is returned.
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        int num = 0;
        boolean start = false;
        boolean minus = false;
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            // not start
            if (!start) {
                if ((temp == ' ' || temp == '\t')) {
                    continue;
                }
                if (temp == '+' || temp == '-' || (temp >= '0' && temp <= '9')) {
                    if (temp == '-') minus = true;
                    else if (temp == '+') minus = false;
                    else num = temp - '0';
                } else {
                    return num;
                }
                start = true;
            } else {
                if ((temp < '0' || temp > '9')) {
                    return minus ? 0 - num : num;
                }
                int nextVal = temp - '0';
                if (minus && Integer.MIN_VALUE / 10 > 0 - num || (Integer.MIN_VALUE / 10 == 0 - num && 0 - nextVal < Integer.MIN_VALUE % 10)) {
                    return Integer.MIN_VALUE;
                }
                if (!minus && (Integer.MAX_VALUE / 10 < num || (Integer.MAX_VALUE / 10 == num && nextVal > Integer.MAX_VALUE % 10))) {
                    return Integer.MAX_VALUE;
                }
                num = num * 10 + (temp - '0');
            }
        }
        return minus ? 0 - num : num;
    }
}
