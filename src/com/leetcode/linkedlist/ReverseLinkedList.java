package com.leetcode.linkedlist;

/**
 * Reverse a singly linked list.
 */
public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode solution(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = pre;
            pre = current;
            current = nextTemp;
        }
        return pre;
    }
}
