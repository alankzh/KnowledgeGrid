package alankzh.leetcode.projectof21day;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class LeetCode22 {

    public static void main(String[] args) {
        LeetCode22 solution = new LeetCode22();

        int n = 3;

        List<String> result = solution.generateParenthesis(n);
        System.out.println(result);
    }


    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }

        // todo

        return result;
    }

}
