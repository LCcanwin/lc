package com.lc.code;

import java.util.Arrays;

public class Solution147 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = new ListNode(0);
        ListNode pre = node;
        while (head != null) {
            while (pre.next != null && pre.next.val < head.val) {
                pre = pre.next;
            }
            ListNode next = head.next;
            head.next = pre.next;
            pre.next = head;
            pre = node;
            head = next;
        }
        return node.next;
    }
}
