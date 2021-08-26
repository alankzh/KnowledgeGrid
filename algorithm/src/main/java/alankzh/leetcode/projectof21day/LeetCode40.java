package alankzh.leetcode.projectof21day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null) {
            return result;
        }

        Arrays.sort(candidates);

        dfs(result, new ArrayList<>(), candidates, target, 0);

        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> path, int[] candidates, int target, int begin) {
        int sum = sumOfList(path);
        if (sum == target) {
            result.add(new ArrayList<>(path));
        }
        if (sum > target || begin >= candidates.length) {
            return;
        }

        for (int i=begin; i<candidates.length; i++) {
            if (i > begin && candidates[i] == candidates[i-1]) {
                continue;
            }
            path.add(candidates[i]);
            dfs(result, path, candidates, target, i+1);
            path.remove(path.size() - 1);
        }
    }

    private int sumOfList(List<Integer> list) {
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
