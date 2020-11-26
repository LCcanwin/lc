package com.lc.code;

public class Solution29 {
    //使用加法 超时
    public static int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE&&divisor==-1){
            return Integer.MAX_VALUE;
        }

        boolean k=(dividend>0&&divisor>0)||(dividend<0&&divisor<0);
        int result=0;
        //使用负数防止越界
        dividend=-Math.abs(dividend);
        divisor=-Math.abs(divisor);
        while(dividend<=divisor) {
            dividend-=divisor;
            result+=1;
        }
        return k?result:-result;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648
                ,-1));
    }
}
