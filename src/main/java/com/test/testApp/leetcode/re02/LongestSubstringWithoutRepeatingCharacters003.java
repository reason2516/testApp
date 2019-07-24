package com.test.testApp.leetcode.re02;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters003 {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        if (s == null || s.equals("")) {
            return 0;
        }
        HashMap<Character, Integer> charTemp = new HashMap<>();
        int beginIndex = 0;
        for (int index = 0; index < s.length(); index++) {
            char c = s.charAt(index);
            Integer originIndex = charTemp.get(c);

            // 存在缓存char beginIndex = 缓存charIndex
            if (originIndex != null && beginIndex < originIndex) {
                beginIndex = originIndex;
            }
            // 更新当前char的坐标
            charTemp.put(c, index);

            // 更新最大长度 当前坐标 - 计数起始坐标
            maxLength = Math.max((index - beginIndex), maxLength);
        }

        return maxLength;
    }
}
