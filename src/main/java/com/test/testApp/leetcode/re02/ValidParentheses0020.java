package com.test.testApp.leetcode.re02;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses0020 {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses0020().new Solution();
        String str = "()";
        boolean valid = solution.isValid(str);
        System.out.println(valid);

    }

    /**
     * 解题思路: 栈
     * 1. 从左到右遍历所有元素
     * 2. 如果元素a是左括号,推入栈
     * 3. 如果元素a是右括号, 判断栈是否已经是空的 如果是示false;栈顶弹出一个元素b 判断 a.equals b 不相等false
     * 4. 遍历完所有的元素,判断栈是否为空,如果栈不为空说明有剩余的左括号 false
     */
    class Solution {
        Map<Character, Character> maps = new HashMap<>();

        {
            maps.put('}', '{');
            maps.put(']', '[');
            maps.put(')', '(');
        }

        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!maps.containsKey(c)) {
                    stack.push(c);
                } else if (stack.isEmpty() || !stack.pop().equals(maps.get(c))) {
                    return false;
                }

            }
            return stack.empty();
        }
    }
}
