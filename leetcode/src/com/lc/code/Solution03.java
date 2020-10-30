package com.lc.code;

import java.util.HashSet;
import java.util.Set;

public class Solution03 {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int start = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int temp = start;
            Set<Character> set = new HashSet<>();
            while (temp < len) {
                if (set.add(s.charAt(temp))) {
                    max = Math.max(temp - start + 1, max);
                } else {
                    break;
                }
                temp++;
            }
            start++;
        }
        return max;
    }

}
