package com.lc.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯 剪枝
 */
public class Solution17 {
    static String[] map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    static List<String> res = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        if (digits == "" || digits == null || digits.length() == 0) {
            return res;
        }
        help(digits, 0, new StringBuilder());
        return res;
    }

    /**
     * dfs
     * @param digits
     * @param index
     * @param sb
     */
    public static void help(String digits, int index, StringBuilder sb) {
        if (digits.length() == sb.length()) {
            res.add(sb.toString());
            return;
        }
        int l = digits.charAt(index) - '2';
        String s = map[l];
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            help(digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }

}
