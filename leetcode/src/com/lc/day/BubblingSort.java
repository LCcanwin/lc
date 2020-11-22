package com.lc.day;

public class BubblingSort {
    public static void  bubblingSort(int[] arr){
        if (arr.length == 0){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{232,232,33,2,34,5,525};
        bubblingSort(nums);
        for (int x : nums){
            System.out.println(x);
        }
    }
}
