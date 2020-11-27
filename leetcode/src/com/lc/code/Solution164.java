package com.lc.code;

import java.util.Arrays;

public class Solution164 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max((nums[i] - nums[i - 1]), max);
        }
        return max;
    }
}
