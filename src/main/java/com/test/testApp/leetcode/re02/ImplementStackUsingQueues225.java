package com.test.testApp.leetcode.re02;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues225 {

    /**
     * 解题思路
     * 1. 创建两个queue 一个是备份
     * 2. push时 queue 直接add, top记录最新的数字 O(1)
     * 3. pop时 从头到尾遍历worker 不断更新top  直到size为1 交换worker与backup指向的对象 弹出backup O(n)
     * 4. peek时 直接返回 top O(1)
     * 5. empty时 判断work.empty()
     */
    class MyStack {
        private Queue<Integer> worker;
        private Queue<Integer> backup;
        private int top;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            worker = new LinkedList<>();
            backup = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            top = x;
            worker.add(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            while (worker.size() > 1) {
                Integer remove = worker.remove();
                backup.add(remove);
                top = remove;
            }
            Queue<Integer> temp;
            temp = worker;
            worker = backup;
            backup = temp;
            return backup.remove();

        }

        /**
         * Get the top element.
         */
        public int top() {
            return top;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return worker.isEmpty();
        }
    }
}
