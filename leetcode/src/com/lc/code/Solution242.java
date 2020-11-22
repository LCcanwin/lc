package com.lc.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution242 {
    //将s放入map，然后遍历t，有的话就删除，没有返回false
    //自己定义hash映射
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
            hash[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (hash[i] < 0) {
                return false;
            }
        }
        return true;



//        if ((s.length() == 0 && t.length() != 0) || (s.length() != 0 && t.length() == 0) || s.length() != t.length()) {
//            return false;
//        }
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
//        }
//        for (int i = 0; i < t.length(); i++) {
//            if (!map.containsKey(t.charAt(i)) || map.get(t.charAt(i)) <= 0) {
//                return false;
//            } else {
//                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
//            }
//        }
//        return true;
    }
}
