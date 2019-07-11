package com.test.testApp.leetcode.linkedlist;

public class ReverseKGroup {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 思路1 分组反转加缓存
    public ListNode reverseKGroup01(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode[] nodeTemp = new ListNode[k];
        ListNode cur = head;
        ListNode pre = null;
        ListNode preGroupEnd = null;
        int count = 0;
        boolean firstReverse = true;
        while (cur != null) {
            nodeTemp[count] = cur;
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            count++;

            // 交换次数足额
            if (count == k) {
                // 首轮反转 记录 新的连表头
                if (firstReverse) {
                    head = pre;
                    firstReverse = false;
                }
                if (preGroupEnd != null) {
                    preGroupEnd.next = nodeTemp[count - 1];
                }
                preGroupEnd = nodeTemp[0];
                count = 0;
                pre = null;
            }
            // 抵达连表尾 (count != k - 1)
            else if (cur == null) {
                if (preGroupEnd != null) {
                    preGroupEnd.next = nodeTemp[0];
                }
                for (int j = 0; j < count; j++) {
                    nodeTemp[j].next = nodeTemp[j + 1];
                }
                nodeTemp[count - 1].next = null;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[12];
        for (int i = 0; i < 12; i++)
            listNodes[i] = new ListNode(i + 1);

        for (int j = 0; j < listNodes.length - 1; j++)
            listNodes[j].next = listNodes[j + 1];

        ReverseKGroup reverseKGroup = new ReverseKGroup();
        reverseKGroup.reverseKGroup01(listNodes[0], 4);
    }
}
