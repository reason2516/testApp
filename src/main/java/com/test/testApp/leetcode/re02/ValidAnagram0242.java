package com.test.testApp.leetcode.re02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ValidAnagram0242 {
    /**
     * 解题思路
     * 1. 遍历字字符串中所有字符 存入hashmap 并计数
     * 2. 比较两个map是否相等
     */
    class Solution {
        public boolean isAnagram(String s, String t) {
            Map<Character, Integer> map01 = stringToMap(s);
            Map<Character, Integer> map02 = stringToMap(t);
            if (map01.size() != map02.size()) {
                return false;
            }

            Set<Character> characters = map01.keySet();
            for (Character character : characters) {
                if (map02.get(character) == null) {
                    return false;
                }
                if (!map01.get(character).equals(map02.get(character))) {
                    return false;
                }
            }

            return true;
        }

        private Map<Character, Integer> stringToMap(String str) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
            return map;
        }
    }

    /**
     * 思路2 自定义数组型哈希表
     */
    class Solution02 {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] maps = new int[26];
            for (int i = 0; i < s.length(); i++) {
                maps[s.charAt(i) - 'a']++;
                maps[t.charAt(i) - 'a']--;
            }
            for (int count : maps) {
                if (count != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 思路3 自定义数组型哈希表 优化比对
     */
    class Solution03 {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] maps = new int[26];
            for (int i = 0; i < s.length(); i++) {
                maps[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < t.length(); i++) {
                maps[t.charAt(i) - 'a']--;
                if (maps[t.charAt(i) - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 解题思路04 数组排序 排序后比较
     */
    class Solution04 {
        public boolean isAnagram(String s, String t) {
            char[] c01 = s.toCharArray();
            char[] c02 = t.toCharArray();
            Arrays.sort(c01);
            Arrays.sort(c02);
            return Arrays.equals(c01, c02);
        }
    }

}
