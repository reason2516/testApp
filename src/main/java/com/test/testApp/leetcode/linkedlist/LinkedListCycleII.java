package com.test.testApp.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a linked list, determine if it has a cycle in it.
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 * 判断linkedList 是否有环
 * 思路1 缓存已遍历的数据放到hashSet，当前遍历项 与 hashSet已有项比对 已存在则有环
 * 思路2 快慢指针法 a指针步长1 b指针步长2  a，b指针相遇表示有环，然后新开一个指针指向起点，慢指针可和新指针步长为1的移动，直到相遇则相遇点位环连接点
 *
 * 思路2 证明
 * 1. ab指针相遇时 a走了x步，b走了2x步
 * 2. 假设环周长 k，环节点前长 j,相遇点距离环交点为m
 * 则 x = m+j, 2x = k+j+m 则 x = k = m+j
 * 3.所以当ab相遇时  j = k - m 此时慢指针距离 k终点（即相交点） 差j步 所以新指针开始走j步 必定与慢指针相遇再相交点
 */
class LinkedListCycleII {
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 方法1 遍历 存储到HashSet
    public ListNode Solution01(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode cur = head;
        Set<ListNode> nodeSet = new HashSet<>();
        while (cur.next != null) {
            if (nodeSet.contains(cur)) {
                return cur;
            }
            nodeSet.add(cur);
            cur = cur.next;
        }
        return null;
    }

    public ListNode Solution02(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    ListNode ret = head;
                    while (ret != slow) {
                        ret = ret.next;
                        slow = slow.next;
                    }
                    return ret;
                }
        }
        return null;
    }

}
