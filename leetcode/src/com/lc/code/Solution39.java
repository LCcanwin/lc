package com.lc.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution39 {
    List<List<Integer>> lists = new ArrayList<>();
    //candidates无重复元素
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        help(lists, 0, candidates, target, new LinkedList<>());
        return lists;
    }

    public void help(List<List<Integer>> res, int j, int[] candidates, int target, LinkedList<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = j; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            list.add(candidates[i]);
            int temp = target - candidates[i];
            //因为包含重复，所以从自己的节点开始
            help(res, i, candidates, temp, list);
            list.removeLast();
        }
    }

}
