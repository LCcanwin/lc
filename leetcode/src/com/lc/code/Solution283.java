package com.lc.code;

public class Solution283 {
    public static void moveZeroes(int[] nums) {
//        if(nums.length == 0){
//            return;
//        }
//        int count = 0;
//        for (int num : nums){
//            if (num == 0){
//                count++;
//            }
//        }
//        int len = nums.length;
//        for (int i = 0; i < count ; i++) {
//            int start = 0;
//            while (start < len){
//                while (nums[start] != 0){
//                    start++;
//                }
//                if ((start + 1) < len) {
//                    int temp = nums[start];
//                    nums[start] = nums[start+1];
//                    nums[start+1] = temp;
//                }
//                start++;
//            }
//        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }
        while (j<nums.length){
            nums[j++] = 0;
        }
    }
}
