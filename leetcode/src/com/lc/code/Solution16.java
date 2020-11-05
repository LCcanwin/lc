package com.lc.code;

import java.util.Arrays;

public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        //和三数之和为0一样
        Arrays.sort(nums);
        int len = nums.length;
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len; i++) {
            int start = i + 1;
            int end = len - 1;
            while (start < end) {
                int sum = nums[start] + nums[i] + nums[end];
                int temp = sum - target;
                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }
                if (temp > 0) {
                    end--;
                } else if (temp < 0) {
                    start++;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
