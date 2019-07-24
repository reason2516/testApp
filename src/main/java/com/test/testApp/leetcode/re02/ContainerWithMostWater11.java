package com.test.testApp.leetcode.re02;

class Solution {
    /**
     * 解题思路：
     * 1. 双指针分别从头尾开始 head tail
     * 2. 比较 height[head] 和 height[tail]的高度 取 min*distance（指针距离）
     * 3. min指针位移一步 继续比较
     * 4. 直到高矮指针回合
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int maxWater = 0;
        int head = 0;
        int tail = height.length - 1;
        while (head != tail) {
            if (height[head] > height[tail]) {
                maxWater = Math.max(height[tail] * (tail - head), maxWater);
                tail--;
            } else {
                maxWater = Math.max(height[head] * (tail - head), maxWater);
                head++;
            }
        }

        return maxWater;
    }
}

public class ContainerWithMostWater11 {

}
