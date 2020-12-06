package com.lc.code;

public class Solution33 {
    //方法1：搜索前进行判断 方法2：二分
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[i]) {
                if (target >= nums[i] && target < nums[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                if (target <= nums[j] && target > nums[mid]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }
        return -1;






//        int j = nums.length - 1;
//        if (nums.length <= 0) {
//            return -1;
//        }
//        if (nums[0] > target && nums[j] < target) {
//            return -1;
//        }
//        if (nums[0] > target) {
//            for (int k = j; k >= 0; k--) {
//                if (nums[k] == target) {
//                    return k;
//                }
//            }
//        } else {
//            for (int k = 0; k <= j; k++) {
//                if (nums[k] == target) {
//                    return k;
//                }
//            }
//        }
//        return -1;
    }
}
