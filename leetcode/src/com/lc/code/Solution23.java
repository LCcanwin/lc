package com.lc.code;

import java.util.*;

public class Solution23 {
    public class ListNode {
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

    public ListNode mergeKLists(ListNode[] lists) {
        //利用堆，堆排序
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (ListNode node : lists) {
            while (node != null) {
                priorityQueue.add(node.val);
                node = node.next;
            }
        }
        ListNode res = new ListNode(-1);
        ListNode node = res;
        while (!priorityQueue.isEmpty()){
            node.next = new ListNode(priorityQueue.poll());
            node = node.next;
        }
        return res.next;




        //1、遍历，然后放数组
//        List<Integer> list = new ArrayList<>();
//        for (ListNode node : lists) {
//            while (node != null) {
//                list.add(node.val);
//                node = node.next;
//            }
//        }
//        Collections.sort(list);
//        ListNode res = new ListNode(-1);
//        ListNode node = res;
//        for (Integer integer : list) {
//            node.next = new ListNode(integer);
//            node = node.next;
//        }
//        return res.next;

    }
}
