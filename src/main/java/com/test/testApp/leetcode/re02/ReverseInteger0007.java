package com.test.testApp.leetcode.re02;


public class ReverseInteger0007 {

    public static void main(String[] args) {
        Solution s = new ReverseInteger0007().new Solution();
        s.reverse(-2147483412);

    }

    /**
     * 解题思路
     * 重点考虑问题 整形溢出问题，以及小数问题
     * 1. x%10得余数tail
     * 2. ret = ret*10+tail
     * 3. x = x/10
     */
    class Solution {
        public int reverse(int x) {
            int ret = 0;
            int tail = 0;
            boolean positive = x >= 0;
            while (x != 0) {
                tail = x % 10;
                if (positive && (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && tail > Integer.MAX_VALUE % 10))) {
                    return 0;
                }
                if (!positive && (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && tail < Integer.MIN_VALUE % 10))) {
                    return 0;
                }
                ret = ret * 10 + x % 10;
                x = x / 10;
            }

            return ret;
        }
    }

}
