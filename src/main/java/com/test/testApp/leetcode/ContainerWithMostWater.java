package com.test.testApp.leetcode;

public class ContainerWithMostWater {
    /**
     * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
     * <p>
     * Note: You may not slant the container and n is at least 2.
     * 思路
     * 双指针指(left right)向两端，计算area
     * 判断两个指针的height 大小，left小的话 left指针右移 反之 right指针左移 (原理 反证法：如果小的height 不动，大的移动得到的总面积必然比移动前小)
     * 算法复杂度 O(n)
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int maxArea = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;

        while (leftIndex <= rightIndex) {
            maxArea = Math.max(maxArea, Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex));
            if (height[leftIndex] > height[rightIndex])
                rightIndex--;
            else
                leftIndex++;
        }
        return maxArea;
    }

    // 方法2 暴力枚举法 复杂度 O(n^2)
}
