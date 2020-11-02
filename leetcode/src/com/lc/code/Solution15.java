package com.lc.code;

import java.util.*;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        //1
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            List<Integer> list = new ArrayList<>();
            int start = 0;
            int end = nums.length-1;
            list.add(nums[i]);
            while (start < end){
                int temp = nums[start]+nums[end];
                if (temp < target){
                    start ++;
                }else if (temp > target){
                    end --;
                }else {
                    //2
                    if (i != start && i != end) {
                        list.add(nums[start]);
                        list.add(nums[end]);
                        //3
                        Collections.sort(list);
                        res.add(list);
                        list = new ArrayList<>();
                        list.add(nums[i]);
                    }
                    //4
                    start++;
                    end--;
                }
            }
        }
        return new ArrayList<>(res);
    }
}
