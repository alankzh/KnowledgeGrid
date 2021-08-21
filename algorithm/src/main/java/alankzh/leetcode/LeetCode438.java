package alankzh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 暴力求解太丑，想办法
 */
@Deprecated
public class LeetCode438 {
    public static void main(String[] args) {
        LeetCode438 solution = new LeetCode438();

        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> result = solution.findAnagrams(s, p);

        System.out.println(result);
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
