package com.lc.code;

import java.util.ArrayList;
import java.util.List;

public class Solution24 {
    public static class ListNode {
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

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> lists = new ArrayList<>();
        while (head != null && head.next != null) {
            ListNode temp = head.next.next;
            head.next.next = head;
            lists.add(head);
            head = temp;
        }
        ListNode isEx = null;
        if (head != null && head.next == null) {
            isEx = head;
        }
        if (lists.size() == 1 && isEx == null) {
            ListNode temp = lists.get(0).next;
            lists.get(0).next = null;
            return temp;
        }
        if (lists.size() == 1 && isEx != null) {
            ListNode temp = lists.get(0).next;
            lists.get(0).next = isEx;
            return temp;
        }
        ListNode node = new ListNode(-1);
        ListNode res = lists.get(0).next;
        node.next = res;
        for (int i = 1; i < lists.size(); i++) {
            if (i == lists.size() - 1 && isEx ==null) {
                res.next.next = lists.get(i).next;
                res.next.next.next.next = null;
            }else if (i == lists.size() - 1 && isEx != null){
                res.next.next = lists.get(i).next;
                res.next.next.next.next = isEx;
            } else {
                res.next.next = lists.get(i).next;
            }
            //从头开始
            res = lists.get(i).next;
        }
        return node.next;
    }


    public ListNode swapPairs2(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;

//        if(head!=null && head.next!=null){
//            ListNode nextNode = head.next;
//            head.next = swapPairs(nextNode.next);
//            nextNode.next = head;
//            return nextNode;
//        }
//        return head;
    }

}
