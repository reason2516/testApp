package com.test.testApp.leetcode.re02;

import java.util.Stack;

public class ImplementQueueUsingStacks0232 {
    public static void main(String[] args) {
        MyQueue queue = new ImplementQueueUsingStacks0232().new MyQueue();
        boolean empty = queue.empty();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.peek();
        queue.pop();
        queue.peek();
        queue.pop();
        queue.pop();
    }

    /**
     * 解题思路:
     * 1. 创建两个stack input / output
     * 2. input 负责 接收push的元素
     * 3. output负责 pop peek 当
     * 4. 当pop 或 peek时 如果output为空 将 input中所有元素 导入到 output
     * 5. empty判断逻辑 input 与 output 全部为空
     */
    class MyQueue {
        private Stack<Integer> input;
        private Stack<Integer> output;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            input = new Stack<>();
            output = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            input.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            elementShift();
            return output.pop();
        }

        private void elementShift() {
            if (output.empty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
        }

        /**
         * Get the front element.
         */
        public int peek() {
            elementShift();
            return output.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return input.empty() && output.empty();
        }
    }
}
