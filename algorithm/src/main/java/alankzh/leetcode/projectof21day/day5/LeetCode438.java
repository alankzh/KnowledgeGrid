package alankzh.leetcode.projectof21day.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LeetCode438 {
    public static void main(String[] args) {
        LeetCode438 solution = new LeetCode438();

        String s = "afdkljflsdkjfsdlkjfdslkjfdslkjfkljlkjlkfdjslkfjsdlkjsdflksdjflkdsjfldskjksldfjlksdjflkdsjfsjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjfsdfaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String p = "z";

        List<Integer> result = solution.findAnagrams2(s, p);

        System.out.println(result);
    }

    /**
     * 注意统计方式
     * 1. 右指针的当前字符如果次数大于需要匹配的次数，则需要左指针前进
     * 2. 当然左指针前进最终会导致当前窗口统计的字符数为0，故不需要注意边界条件
     * 3. 如果右指针的当前字符，次数小于当前需要匹配的次数，其实可以窗口继续向右走，因为窗口内的每个字符都保证了不大于需要匹配的次数
     * 4. 当左右指针窗口的长度等于需要匹配的字符长度时，由于字符的统计次数都不大于，故可以确认匹配。
     */
    public List<Integer> findAnagrams2(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) {
            return new ArrayList<>();
        }

        int[] s_s = new int['z' - 'a' + 1];
        int[] p_s = new int['z' - 'a' + 1];
        for (char c : p.toCharArray()) {
            p_s[c - 'a'] ++;
        }

        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        for ( ; right < s.length(); right ++) {
            int ri = s.charAt(right) - 'a';
            s_s[ri] ++;
            while (s_s[ri] > p_s[ri]) {
                int li = s.charAt(left) - 'a';
                s_s[li] --;
                left ++;
            }
            if ((right - left + 1) == p.length()) {
                result.add(left);
            }
        }

        return result;
    }

    // 暴力扫描
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }

        char[] pc = p.toCharArray();
        Arrays.sort(pc);
        String pnew = new String(pc);

        int fi = 0;
        int si = p.length();

        for ( ; si<=s.length() ; fi++, si++ ) {
            String subStr = s.substring(fi, si);
            if (outOfOrderEqual(subStr, pnew)) {
                result.add(fi);
            }
        }

        return result;
    }

    private boolean outOfOrderEqual(String left, String pnew) {
        char[] leftArr = left.toCharArray();

        Arrays.sort(leftArr);

        return new String(leftArr).equals(pnew);
    }
}
