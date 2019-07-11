package com.test.testApp.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TowSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{};
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            Integer index;
            if ((index = map.get(target - nums[j])) != null && index != j) {
                return new int[]{j, index};
            }
        }

        return new int[]{};
    }
}
