package com.lc.code;

public class Solution34 {
    //方法1：暴力 方法2：二分，找到index，然后以index为发散点
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums.length <= 0) {
            return res;
        }
        int i = 0;
        int j = nums.length;
        int index = -1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                index = mid;
                break;
            }
        }
        if (index == -1) {
            return res;
        }
        int m = index;
        while (m >= 0 && nums[m] == target) {
            m--;
        }
        res[0] = m + 1;
        int k = index;
        while (k <= nums.length - 1 && nums[k] == target) {
            k++;
        }
        res[1] = k - 1;
        return res;




//        int[] res = new int[]{-1, -1};
//        if (nums.length <= 0 || (nums.length == 1 && nums[0] != target)) {
//            return res;
//        }
//        int i = 0;
//        int j = nums.length - 1;
//        if (nums[i] > target || target > nums[j]) {
//            return res;
//        }
//        while (nums[i] != target && nums[i] < target && i < j) {
//            i++;
//        }
//        if (i > j) {
//            return res;
//        }
//        while (nums[j] != target && nums[j] > target && j > 0) {
//            j--;
//        }
//        if (i > j) {
//            return res;
//        }
//        res[0] = i;
//        res[1] = j;
//        return res;
    }
}
