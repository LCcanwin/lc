package com.lc.code;


/**
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class Solution204 {
    public int countPrimes(int n) {
        if (n <= 1){
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if ((i % 2 == 0 && i != 2) && (i % 3 == 0 && i != 3) && (i % 5 == 0 || i != 5)) {

            }else {
                sum++;
            }
        }
        return sum;
    }
}
