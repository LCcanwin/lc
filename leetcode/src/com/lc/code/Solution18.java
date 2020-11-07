package com.lc.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution18 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        help(nums, target, 0, new LinkedList<>());
        return res;
    }

    public void help(int[] nums, int target, int index, LinkedList<Integer> list) {
        if (target == 0 && list.size() == 4) {
            res.add(new ArrayList<>(list));
        }
        if (list.size() > 4) {
            return;
        }
        if (list.size() == 4 && target != 0) {
            return;
        }
        if (nums[index] > 0 && target < nums[index]) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (target - nums[i] < 0 && nums[i] > 0) {
                break;
            }
            if (nums.length - i < (4 - list.size())) {
                //剩余元素不足
                return;
            }
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            help(nums, target - nums[i], i + 1, list);
            list.removeLast();
        }
    }


}
