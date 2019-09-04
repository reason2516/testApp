package com.test.testApp.leetcode.re03;

public class AddTwoNumbers0002 {
    public static void main(String[] args) {
        int nextBit = 0;

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode retHead = null;
            ListNode retPre = null;
            int nextBit = 0;
            while (l1 != null || l2 != null || nextBit != 0) {
                int sum = nextBit;
                if (l1 != null) {
                    sum = sum + l1.val;
                    l1 = l1.next;
                }

                if (l2 != null) {
                    sum = sum + l2.val;
                    l2 = l2.next;
                }

                nextBit = sum / 10;
                ListNode curNode = new ListNode(sum % 10);

                if (retHead == null) {
                    retHead = curNode;
                }

                if (retPre != null) {
                    retPre.next = curNode;
                }
                retPre = curNode;

            }

            return retHead;
        }
    }
}
