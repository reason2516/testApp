package com.test.testApp.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        char[] strChars = s.toCharArray();
        int beginIndex = 0;
        Map<Character, Integer> subStrCache = new HashMap<>();
        for (int i = 0; i < strChars.length; i++) {
            if (subStrCache.get(strChars[i]) != null && beginIndex <= subStrCache.get(strChars[i])) {
                beginIndex = subStrCache.get(strChars[i]) + 1;
            }
            subStrCache.put(strChars[i], i);
            maxLength = Math.max(maxLength, i - beginIndex + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int out = lengthOfLongestSubstring("abcabcbb");
        System.out.println(out);
    }
}
