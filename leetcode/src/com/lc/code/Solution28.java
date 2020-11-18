package com.lc.code;

public class Solution28 {
    public static int strStr(String haystack, String needle) {
        /*
          暴力，挨个匹配
         */
         int hs = 0;
         int ns = 0;
         while ((hs < haystack.length())&&(ns < needle.length())){
             if (haystack.charAt(hs) == needle.charAt(ns)){
                 hs++;
                 ns++;
             }else {
                 hs = hs -ns +1;
                 ns = 0;
             }
         }
         if (ns == needle.length()){
             return hs - ns;
         }else {
             return -1;
         }
    }


    public static void main(String[] args) {
        System.out.println(strStr("hello","ll"));
    }
}
