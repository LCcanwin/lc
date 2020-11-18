package com.lc.code;

public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
//        for (int i = 0; i < gas.length; i++) {
//            int sum = 0;
//            boolean res = true;
//            for (int j = i; j < gas.length; j++) {
//                sum += gas[j] - cost[j];
//                if (sum < 0) {
//                    res = false;
//                    break;
//                }
//            }
//            for (int j = 0; j < i; j++) {
//                sum += gas[j] - cost[j];
//                if (sum < 0) {
//                    res = false;
//                    break;
//                }
//            }
//            if (res) {
//                return i;
//            }
//        }
//        return -1;

        int len = gas.length;
        int i = 0;
        while (i < len) {
            int totalGas = 0;
            int totalCost = 0;
            int cnt = 0; //代表加油站个数
            while (cnt < len) {
                int j = (i + cnt) % len;  //求位置【环形】
                totalGas += gas[j];
                totalCost += cost[j];
                if (totalGas < totalCost) {
                    break;
                }
                cnt++;
            }
            if (cnt == len) {
                return i;
            } else {
                i = i + cnt + 1;  //不进行i++，因为1..j..n 如果1.。j..n不行的话，那么 2.。J..N肯定也不行
            }
        }
        return -1;
    }
}
