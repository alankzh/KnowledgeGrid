package alankzh.leetcode.projectof14day.day11;

import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {

    public static void main(String[] args) {
        List<List<Integer>> list = new LeetCode77().combine(4, 2);
        System.out.println(list);
    }

    public List<List<Integer>> combine(int n, int k) {
        if (k > n) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();

        pick(n, k, 1, result, new ArrayList<Integer>());

        return result;
    }

    private void pick(int n, int k, int begin, List<List<Integer>> result, List<Integer> curPick) {
        if (curPick.size() == k) {
            result.add(curPick);
            return;
        }

        for (int i=begin; i<=n; i++) {
            curPick.add(i);
            pick(n, k, i+1, result, new ArrayList<Integer>(curPick));
            curPick.remove(curPick.size() - 1);
        }
    }

}
