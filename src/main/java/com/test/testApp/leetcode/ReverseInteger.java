package com.test.testApp.leetcode;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 * 重点：溢出判断
 */
public class ReverseInteger {
    public int reverse(int x) {
        int i = 10;
        int revNum = 0;

        while (x != 0) {
            int pop = x % i;
            x = x / 10;
            if (revNum > Integer.MAX_VALUE / 10 || (revNum == Integer.MAX_VALUE / 10 && pop > (Integer.MAX_VALUE / 10) % 10)) {
                return 0;
            }
            if (revNum < Integer.MIN_VALUE / 10 || (revNum == Integer.MIN_VALUE / 10 && pop < (Integer.MIN_VALUE / 10) % 10)) {
                return 0;
            }
            revNum = revNum * 10 + pop;
        }

        return revNum;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(-900));
    }
}
