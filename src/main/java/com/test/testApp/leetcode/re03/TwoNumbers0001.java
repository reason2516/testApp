package com.test.testApp.leetcode.re03;

import java.util.HashMap;
import java.util.Map;

public class TwoNumbers0001 {
    public static void main(String[] args) {
        Solution solution = new TwoNumbers0001().new Solution();
        int[] ints = solution.twoSum(new int[]{1, 3, 4, 5, 6, 78, 9}, 15);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    return new int[]{map.get(target - nums[i]), i};
                }
                map.put(nums[i], i);
            }
            return new int[]{};
        }
    }
}
