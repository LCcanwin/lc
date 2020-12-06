package com.lc.code;


public class Solution25 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 递归
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        return help(head, k);
    }

    // a - b - c - d - e
    public static ListNode help(ListNode node, int k) {
        if (node == null || k <= 1) {
            return node;
        }
        int temp = k;
        ListNode m = node;
        ListNode n = new ListNode(-1);
        ListNode mid = null;
        while (temp > 0 && m != null && m.next != null ) {
            ListNode y = m.next;
            m.next = n.next;
            n.next = m;
            m = y;
            temp--;
        }
        if (temp > 0) {
            return node;
        }
        mid = n.next;
        if (mid == null) {
            return node;
        }
        ListNode right = m;
        n.next = help(right, k);
        return mid;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        reverseKGroup(root,2);
    }
}
