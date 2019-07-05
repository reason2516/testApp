package com.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

// Definition for singly-linked list.


/**
 *  * Given a linked list, determine if it has a cycle in it.
 *  * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *  * 判断linkedList 是否有环
 *  * 思路1 缓存已遍历的数据放到hashSet，当前遍历项 与 hashSet已有项比对 已存在则有环
 *  * 思路2 快慢指针法 a指针步长1 b指针步长2  a，b指针相遇表示有环
 */
public class LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 方法1 遍历 存储到HashSet
    public boolean Solution01(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode cur = head;
        Set<ListNode> nodeSet = new HashSet<>();
        while (cur.next != null) {
            if (nodeSet.contains(cur)) {
                return true;
            }
            nodeSet.add(cur);
            cur = cur.next;
        }
        return false;
    }

    // 方法2 快慢指针法
    public boolean Solution02(ListNode head) {
        if(head == null){ // 可能是null
            return false;
        }
        ListNode fast = head.next; // 可能是null
        ListNode slow = head;
        while(fast != slow){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;    }
}
