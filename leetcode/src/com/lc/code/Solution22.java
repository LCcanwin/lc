package com.lc.code;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    static List<String> res = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        //先生成原始字符串
        help(0, 0, new StringBuilder(), n);
        return res;
    }

    public static void help(int left, int right, StringBuilder sb, int n) {
        if (left == right && left == n) {
            res.add(sb.toString());
        }
        //保证字符串有效
        if (right > left) {
            return;
        }
        if (left < n) {
            sb.append("(");
            help(left + 1, right, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < n) {
            sb.append(")");
            help(left, right + 1, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
