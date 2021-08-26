package alankzh.leetcode.projectof21day;

import java.util.ArrayList;
import java.util.List;


/**
 * 排序可以减少回溯。
 * 同时除了回溯外，还可以使用动态规划。
 * 参考 leetcode 518. 零钱兑换 II
 */
@Deprecated
public class LeetCode39 {

    public static void main(String[] args) {
        LeetCode39 solution = new LeetCode39();

        int[] candidates = new int[]{2,3,6,7};
        int target = 7;

        List<List<Integer>> result = solution.combinationSum(candidates, target);
        System.out.println(result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null) {
            return result;
        }

        dfs(result, candidates, 0, new ArrayList<>(), target);

        return result;
    }

    private void dfs(List<List<Integer>> result, int[] candidates, int begin, List<Integer> path, int target) {
        int sum = sumOfList(path);
        if (sum == target) {
            result.add(new ArrayList<>(path));
        }
        if (sum > target) {
            return;
        }

        for (int i=begin; i<candidates.length; i++) {
            path.add(candidates[i]);

            dfs(result, candidates, i, path, target);

            path.remove(path.size()-1);
        }
    }

    private int sumOfList(List<Integer> list){
        if (list == null) {
            return 0;
        }
        int sum = 0;
        for (int i=0; i<list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

}
