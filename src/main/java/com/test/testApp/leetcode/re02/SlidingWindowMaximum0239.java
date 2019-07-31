package com.test.testApp.leetcode.re02;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximum0239 {
    /**
     * 解题思路:
     * 1. 创建一个 k 大小的有限队列(大顶堆)
     * 2. 移动滑块将值不断的写入 队列
     * 3. 当队列第一次数据量达到k个的时候(即:对应键 k-1)
     *  开始记录大顶堆顶部的值,并剔除滑块最左端的值(即:对应键 i- k + 1)
     */
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0 || k <= 0 || k > nums.length) {
                return new int[]{};
            }
            int[] ret = new int[nums.length - k + 1];
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
            int retIdx = 0;
            for (int i = 0; i < nums.length; i++) {
                maxHeap.add(nums[i]);
                // 当游标抵达 k-1 即:游标内的数字数量第一次充满k个的时候 开始记录最大值
                if (i >= k - 1) {
                    ret[retIdx++] = maxHeap.peek();
                    // 剔除最左端的元素对应的值
                    maxHeap.remove(nums[i - k + 1]);
                }
            }
            return ret;
        }
    }
}
