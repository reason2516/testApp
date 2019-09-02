package com.test.testApp.leetcode.re02;

public class LongestCommonPrefix0014 {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix0014().new Solution();
        String[] strs = new String[]{
                "abc",
                "abcd",
                "abed",
                "afer",
                "efer",
        };
        System.out.println(solution.longestCommonPrefix(strs));
    }

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return  "";
            }
            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++) {
                while (strs[i].indexOf(prefix) != 0){
                    prefix = prefix.substring(0,prefix.length()-1);
                    if(prefix.isEmpty()){
                        return prefix;
                    }
                }
            }
            return prefix;
        }
    }
}
