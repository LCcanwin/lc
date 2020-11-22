package com.lc.day;

public class InsertSort {
    public static int[] insertSort(int[] arr){
        if (arr.length ==0 ){
            return arr;
        }
        int[] nums = new int[arr.length];
        nums[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int temp = arr[i];
            while (j > 0 && temp < nums[j - 1]) {
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] num = new int[]{323,344,22,11,41,45,122};
        int[] res = insertSort(num);
        for (int x : res){
            System.out.println(x);
        }
    }
}
