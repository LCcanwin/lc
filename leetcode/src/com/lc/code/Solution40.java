package com.lc.code;

import java.util.*;

public class Solution40 {
    List<List<Integer>> res = new ArrayList<>();
    //candidates有重复元素
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        help(candidates, 0, new LinkedList<>(), target);
        return res;
    }

    public void help(int[] candidates, int index, LinkedList<Integer> list, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if ((target - candidates[i]) < 0) {
                break;
            }
            //①因为排序好的，因此这里可以去掉重复的 ②可以使用Set集合来去重
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            help(candidates, i + 1, list, target - candidates[i]);
            list.removeLast();
        }
    }
}
