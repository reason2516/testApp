package com.test.testApp.leetcode.re02;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAStream703 {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargestElementInAStream703().new KthLargest(3, new int[]{7, 3, 4, 5});
        System.out.println(kthLargest.add(8));
        System.out.println(kthLargest.add(6));
    }

    /**
     * 解题思路
     * 1. 创建一个 k位小顶堆
     * 2. 添加元素
     * 3. 当元素数量小于k个的时候 无条件添加
     * 4. 当元素数量大于k个的时候 判断堆顶元素与 当前被添加元素val的大小
     * 5. 如果堆顶元素小于当前被添加的元素 移除堆顶元素 插入新元素
     */
    class KthLargest {
        private int k;
        private int[] nums;
        PriorityQueue<Integer> queue;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.nums = nums;
            Comparator<Integer> comparator = new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            };
            this.queue = new PriorityQueue<>(k, comparator);
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (queue.size() < k) {
                queue.add(val);
            } else if (queue.peek() < val) {
                queue.poll(); // 移除对堆顶元素
                queue.offer(val);
            }
            return queue.peek();
        }
    }
}
