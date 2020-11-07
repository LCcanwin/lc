package com.lc.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution20 {
    //栈相关的
    public boolean isValid(String s) {
        if ((s.length() % 2) != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (stack.empty() || stack.peek() != map.get(s.charAt(i))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.empty();
    }
}
