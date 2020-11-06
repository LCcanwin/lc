package com.lc.code;

import java.util.*;

public class Solution1356 {
    public static int[] sortByBits(int[] arr) {
        int[] temp = new int[arr.length];
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            //利用原址加新值进行权重排序
            temp[i] = getNumberCount(arr[i]) * 10000 + arr[i];
        }
        Arrays.sort(temp);
        for (int i = 0; i < arr.length; i++) {
            res[i] = temp[i] % 10000;

        }
        return res;
    }

    public static int getNumberCount(int num) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((num >>> i) & 1) == 1) {
                count++;
            }
        }
        return count;
    }
}
