package com.lc.code;

public class Solution35 {
    //遍历
    public int searchInsert(int[] nums, int target) {
        /* 二分 */
        if (nums.length == 0 || nums[0] > target){
            return 0;
        }
        int start = 0;
        int end = nums.length-1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                if(mid - 1 < 0){
                    return 0;
                }
                if ((mid -1 > 0 && nums[mid-1] < target) ){
                    return mid;
                }else {
                    end = mid;
                }
            }else {
                if (mid + 1 >= nums.length || nums[mid + 1] > target){
                    return mid+1;
                }else {
                    start = mid + 1;
                }
            }
        }
        return 0;



//        if(nums.length <= 0){
//            return 0;
//        }
//        if (nums[0] == target){
//            return 0;
//        }
//        if (nums[0] > target){
//            return 0;
//        }
//        for (int i = 0; i < nums.length-1; i++) {
//            if (nums[i] == target ){
//                return i;
//            }else if  (nums[i] < target && target < nums[i+1]){
//                return i+1;
//            }
//        }
//        if (nums[nums.length-1] == target){
//            return nums.length-1;
//        }
//        return nums.length;
    }
}
