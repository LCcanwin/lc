package com.lc.code;

public class Solution1370 {
    //数组存hash【字符串】
    public String sortString(String s) {
        if (s.length() <= 1){
            return s;
        }
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            arr[index] += 1;
        }
        int len = s.length();
        StringBuilder res = new StringBuilder();
        while (len > 0){
            for (int i = 0; i < 26; i++) {
                if (arr[i] == 0){
                    continue;
                }
                res.append((char)(i+'a'));
                arr[i]--;
                len--;
            }
            for (int i = 25; i >= 0; i--) {
                if (arr[i] == 0){
                    continue;
                }
                res.append((char)(i+'a'));
                arr[i]--;
                len--;
            }
        }
        return res.toString();
    }
}
