package com.lc.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution32 {
    public int longestValidParentheses(String s) {
        if (s.length() == 0){
            return 0;
        }
        Map<Character,Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put(')','(');
        int count = 0;
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                if (!stack.empty() && stack.peek() == map.get(s.charAt(i))){
                    count++;
                    stack.pop();
                }
            }else {
                stack.add(s.charAt(i));
            }
        }
        return count*2;

    }
}
