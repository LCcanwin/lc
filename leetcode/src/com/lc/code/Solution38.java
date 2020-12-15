package com.lc.code;


/**
 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 */
public class Solution38 {
    public static String countAndSay(int n) {
        String[] res = new String[n];
        res[0] = "1";
        for (int i = 1; i < n; i++) {
            String s = res[i - 1];
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j - 1) == s.charAt(j)) {
                    count++;
                } else {
                    sb.append(count).append(s.charAt(j - 1));
                    count = 1;
                }
            }
            res[i] = sb.append(count).append(s.charAt(s.length() - 1)).toString();
        }
        return res[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
