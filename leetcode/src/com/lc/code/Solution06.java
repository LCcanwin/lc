package com.lc.code;

public class Solution06 {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1){
            return s;
        }
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int n = 0; n < numRows; n++) {
            stringBuilders[n] = new StringBuilder();
        }
        int index = 0;
        int step = 1;
        for (int i = 0; i < s.length(); i++) {
            stringBuilders[index].append(s.charAt(i));
            index+=step;
            /*
              高低范围震荡
             */
            if (index == 0 || index == numRows-1){
                step = -step;
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : stringBuilders){
            res.append(sb);
        }
        return res.toString();
    }
}
