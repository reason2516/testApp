package com.test.testApp.leetcode;

public class AddTwoNumbers {

    // List Node
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = null;
        ListNode pre = null;

        int nextVal = 0;
        int thisVal = 0;
        while (l1 != null || l2 != null || nextVal!=0) {
            if (l1 != null) {
                nextVal += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                nextVal += l2.val;
                l2 = l2.next;
            }
            thisVal = nextVal % 10;
            nextVal = nextVal / 10;
            ListNode current = new ListNode(thisVal);
            if (pre != null) {
                pre.next = current;
                pre = current;
            } else {
                pre = ret = current;
            }
        }

        return ret;
    }
}
