package alankzh.leetcode.projectof14day.day6;

import java.util.HashMap;
import java.util.Map;

public class LeetCode3 {
    public static void main(String[] args) {

    }

    public boolean checkInclusion(String s1, String s2) {
        if (s2 == null || s2.length() <= 0) {
            return false;
        }
        if (s1 == null || s1.length() <= 0) {
            return true;
        }


        int s1Code = calHashCode(s1.toCharArray(), 0, s1.length() - 1);

        int left = 0;
        int right = left + s1.length() - 1;
        char[] arr2 = s2.toCharArray();
        for ( ; right < arr2.length; left ++, right ++) {
            int subStrCode = calHashCode(arr2, left, right);
            if (subStrCode != s1Code) {
                continue;
            }
            boolean match = isMatch(generaHashmap(s1), arr2, left, right);
            if (match) {
                return true;
            }
        }

        return false;
    }

    private Map<Character, Integer> generaHashmap(String s1) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

    private int calHashCode(char[] arr, int begin, int end) {
        int code = 0;
        for (int i=begin; i<=end && i<arr.length; i++) {
            code += arr[i];
        }
        return code;
    }

    private boolean isMatch(Map<Character, Integer> s1Map, char[] arr2, int left, int right) {
        for (; left<=right; left ++) {
            char c = arr2[left];
            if ( !s1Map.containsKey(c)) {
                return false;
            }
            int v = s1Map.get(c);
            if (v == 0) {
                return false;
            }
            s1Map.put(c, v-1);
        }
        return true;
    }
}
