package alankzh.leetcode.projectof14day.day11;

import java.util.ArrayList;
import java.util.List;

public class LeetCode784 {

    public static void main(String[] args) {

    }

    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();

        char[] arr = s.toCharArray();
        StringBuilder stb = new StringBuilder();

        backTrace(result, arr, 0, stb);

        return result;
    }

    private void backTrace(List<String> result, char[] arr, int index, StringBuilder stb) {
        if (index >= arr.length) {
            result.add(stb.toString());
        }

        char c = arr[index];
        if (c - 'A' < 0) {
            stb.append(c);

            backTrace(result, arr, index + 1, stb);

            stb.deleteCharAt(stb.length() - 1);
        } else {
            for (int i=0; i<2; i++) {
                char w = c;
                if (i != 0) {
                    w = convert(c);
                }

                stb.append(w);

                backTrace(result, arr, index + 1, stb);

                stb.deleteCharAt(stb.length() - 1);
            }
        }
    }

    private char convert(char c) {
        char w ;
        if (c - 'a' < 0) {
            w = (char) (c + ('a' - 'A'));
        } else {
            w = (char) (c - ('a' - 'A'));
        }
        return w;
    }
}
