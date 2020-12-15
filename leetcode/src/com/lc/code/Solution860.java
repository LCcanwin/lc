package com.lc.code;

import java.util.HashMap;
import java.util.Map;

/**
 输入：[5,5,5,10,20]
 输出：true
 解释：
 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 由于所有客户都得到了正确的找零，所以我们输出 true。

 5的个数
 10 - 一个5
 20 - 一个5 和 一个10 或者3 个5


 */
public class Solution860 {
    //考虑用数组
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> five = new HashMap<>();
        five.put(5, 0);
        Map<Integer, Integer> ten = new HashMap<>();
        ten.put(10, 0);
        for (int bill : bills) {
            if (bill == 5) {
                five.put(5, five.getOrDefault(5, 0) + 1);
            }
            if (bill == 10) {
                if (five.get(5) > 0) {
                    five.put(5, five.getOrDefault(5, 0) - 1);
                } else {
                    return false;
                }
                ten.put(10, ten.getOrDefault(10, 0) + 1);
            }
            if (bill == 20) {
                if (five.get(5) > 0 && ten.get(10) > 0) {
                    five.put(5, five.getOrDefault(5, 0) - 1);
                    ten.put(10, ten.getOrDefault(10, 0) - 1);
                } else {
                    if (five.get(5) > 2) {
                        five.put(5, five.getOrDefault(5, 0) - 3);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
