package com.lc.code;

public class Solution941 {
    public boolean validMountainArray(int[] A) {
        // O(logn)*n 二分查找--二分条件
        int start = 0;
        //1
        int end = A.length - 1;
        boolean flag = false;
        //2
        while (start <= end) {
            //3
            int mid = start + (end - start) / 2;
            if (mid + 1 > end || mid - 1 < 0) {
                return flag;
            }
            if (A[mid] == A[mid - 1] || A[mid] == A[mid + 1]) {
                break;
            }
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                if (help1(A, 0, mid) && help2(A, mid, A.length - 1)) {
                    flag = true;
                    break;
                } else {
                    break;
                }
            } else if (A[mid] > A[mid - 1] && A[mid] < A[mid + 1]) {
                //2
                start = mid + 1;
            } else if (A[mid] < A[mid - 1] && A[mid] > A[mid + 1]) {
                end = mid;
            } else {
                break;
            }
        }
        return flag;
    }

    public boolean help1(int[] nums, int s, int e) {
        boolean flag = true;
        for (int i = s; i < e; i++) {
            if (nums[i] >= nums[i + 1]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public boolean help2(int[] nums, int s, int e) {
        boolean flag = true;
        for (int i = s; i < e; i++) {
            if (nums[i] <= nums[i + 1]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    //线性查找[O(N)]
    public boolean validMountainArray2(int[] A) {
        int i = 0;
        int len = A.length - 1;
        while (i < len && A[i] < A[i + 1]) {
            i++;
        }
        if (i == 0 || i == len) {
            return false;
        }
        boolean flag = true;
        for (int j = i; j < len; j++) {
            if (A[j] <= A[j + 1]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

}
