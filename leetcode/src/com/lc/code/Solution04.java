package com.lc.code;

public class Solution04 {
    //要求o（log（m+n））
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //o(n) 不符合要求
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] temp = new int[n1+n2];
        int i=0,j = 0;
        int start = 0;
        while (i< n1 && j<n2){
            if (nums1[i] < nums2[j]){
                temp[start] = nums1[i];
                i++;
            }else {
                temp[start] = nums2[j];
                j++;
            }
            start++;
        }
        while (i < n1){
            temp[start] = nums1[i];
            i++;
            start++;
        }
        while (j < n2){
            temp[start] = nums2[j];
            j++;
            start++;
        }
        double res = 0;
        if ((n1+n2)%2==0){
            res = (temp[(n1+n2)/2]+temp[((n1+n2)/2)-1])/2.0;
        }else {
            res = temp[(n1+n2)/2];
        }
        return res;

    }
}
