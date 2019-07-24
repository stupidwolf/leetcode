package xyz.stupidwolf;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_76 {
    @Test
    public void test() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        s = "BBBBBBBAAC";
        t = "ABC";
//        s = "AA";
//        t = "AA";
        String rs = minWindow(s, t);
        String rs2 = minWindow2(s, t);
        System.out.println(rs);
        System.out.println(rs2);
    }
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        int start = 0;
        int end = 0;
        int minStart = -1;
        int minLen = Integer.MAX_VALUE;
        int counter = t.length();
        while (end < s.length()) {
            if (map.containsKey(s.charAt(end)) && (map.get(s.charAt(end)) > 0)) {
                counter --;
            }
            if (map.containsKey(s.charAt(end))) {
                map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
            }
            end ++;
            while (counter == 0) {
                if (end - start < minLen) {
                    minLen = end - start;
                    minStart = start;
                }
                if (map.containsKey(s.charAt(start))) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                }
                if (map.containsKey(s.charAt(start)) && (map.get(s.charAt(start)) > 0)) {
                    counter ++;
                }
                start ++;
            }
        }

        return minStart == -1 ? "" : s.substring(minStart, minStart + minLen);
    }

    public String minWindow2(String s, String t) {
        int[] map = new int[128];
        for (char ch : t.toCharArray()) {
            map[ch] ++;
        }
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = -1;
        int counter = t.length();
        while (end < s.length()) {
           if (map[s.charAt(end)] > 0) {
               counter --;
           }
           map[s.charAt(end)] --;
           end ++;
           while (counter == 0) {
               if (end - start < minLen) {
                   minLen = end - start;
                   minStart = start;
               }
               map[s.charAt(start)] ++;
               if (map[s.charAt(start)] > 0) {
                   counter ++;
               }
               start ++;
           }
        }
        return minStart == -1 ? "" : s.substring(minStart, minStart + minLen);
    }

}
