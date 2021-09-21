package alankzh.leetcode.projectof21day;

import java.util.ArrayList;
import java.util.List;

public class LeetCode17 {

    public static void main(String[] args) {
        LeetCode17 solution = new LeetCode17();

        String digits = "23";

        List<String> result = solution.letterCombinations(digits);
        System.out.println(result);
    }

    public List<String> letterCombinations(String digits) {
        char[][] charArr = new char[][]
                {{'a', 'b', 'c'},
                        {'d', 'e', 'f'},
                        {'g', 'h', 'i'},
                        {'j', 'k', 'l'},
                        {'m', 'n', 'o'},
                        {'p', 'q', 'r', 's'},
                        {'t', 'u', 'v'},
                        {'w', 'x', 'y', 'z'}};


        if (digits == null || digits.length()<=0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        dfs(charArr, result, new ArrayList<>(), digits);

        return result;
    }

    private void dfs(char[][] charArr, List<String> result, List<Character> path, String digits) {
        if (digits == null || digits.length() <= 0) {
            StringBuilder strb = new StringBuilder();
            for (int i=0; i<path.size(); i++) {
                strb.append(path.get(i));
            }
            result.add(strb.toString());
            return;
        }

        String curNumber = digits.substring(0, 1);
        int number = Integer.parseInt(curNumber);
        char[] chars = charArr[number-2];
        for (int i=0; i<chars.length; i++) {
            path.add(chars[i]);
            String nextDigits = digits;
            if (digits.length() <= 1) {
                nextDigits = null;
            } else {
                nextDigits = digits.substring(1);
            }
            dfs(charArr, result, path, nextDigits);
            path.remove(path.size() - 1);
        }
    }


}
