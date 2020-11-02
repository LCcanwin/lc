package com.lc.code;

public class Solution08 {
    public static int myAtoi(String s) {
        if (s == null || s.equals("")){
            return 0;
        }
        String s1 = s.trim();
        char[] chars = s1.toCharArray();
        if ((chars[0] < 48 || chars[0] > 57) && chars[0] != 45 && chars[0] != 43){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            if ((chars[i] >= 48 && chars[i] <= 57) || chars[i] == 45 || chars[i] == 43 ){
                sb.append(chars[i]);
            }else {
                break;
            }
        }
        int start = 0;
        int add = 0;
        int edd = 0;
        StringBuilder resb = new StringBuilder();
        while(start < sb.length()){
            if(sb.charAt(start) == 43){
                add ++;
            }else if(sb.charAt(start) == 45){
                edd ++;
            }else if(sb.charAt(start) >= 48 && sb.charAt(start) <= 57){
                resb.append(sb.charAt(start));
            }
            start++;
        }
        if(resb.length()==0){
            return 0;
        }
        long res = Long.parseLong(resb.toString());
        if(add < edd){
            if((edd-add)%2 != 0){
                res= res*-1;
            }
        }else if(add!=0 && edd!=0 && add ==edd){
            res = 0;
        }
        if (res > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if(res < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else {
            return (int)res;
        }
    }

    public static void main(String[] args) {
        String S = "00000-42a1234";
//        String S = "21474836460";
        System.out.println(myAtoi(S));
    }
}
