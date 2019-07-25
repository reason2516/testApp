package com.test.testApp.leetcode.re02;

public class LongestPalindromicSubstring0005 {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring0005().new Solution();
        String s = "babad";
        String s1 = solution.longestPalindrome(s);
        System.out.println(s1);
    }

    /**
     * 思路 中心扩展法 算法复杂度 O(n*n)
     * 1. 以每一个index作为中心点从两边扩散 lIndex rIndex 比较 s[lIndex] 与 s[rIndex]是否相等
     * 2. 由于不确定是否存在 abba这种场景所以需要单独处理奇数偶数的场景
     * 3. 假设奇数：lIndex = index; rIndex = index;  假设偶数 lIndex = index; rIndex = index+1;
     * 4. 得出奇数偶数的最长串结果：curLongest
     * 5. 比较 curLongest 与 tempLongest 取 暂存长的结果到 tempLongest
     */
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null) {
                throw new IllegalArgumentException();
            }
            String longStr = "";
            for (int i = 0; i < s.length(); i++) {
                String oddStr = calSub(s, i, i);// 奇数
                String evenStr = calSub(s, i, i + 1); // 偶数
                if (oddStr.length() > longStr.length()) {
                    longStr = oddStr;
                }
                if (evenStr.length() > longStr.length()) {
                    longStr = evenStr;
                }
            }

            return longStr;
        }

        public String calSub(String s, int left, int right) {
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right))
                    break;
                left--;
                right++;

            }
            // right最大值为 s.length()  s.substring(a,b) 范围为{a,b] a取值范围 (0 ~ length-1) b取值范围 0 ~ length
            return s.substring(left + 1, right);
        }
    }
}
