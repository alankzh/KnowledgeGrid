package alankzh.leetcode.projectof21day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode47 {

    public static void main(String[] args) {
        LeetCode47 solution = new LeetCode47();

        int[] nums = new int[] {1,1,2};
        List<List<Integer>> result = solution.permuteUnique(nums);

        System.out.println(result);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        Arrays.sort(nums);

        boolean[] visited = new boolean[nums.length];

        dfs(result, nums, new ArrayList<>(), visited);

        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, List<Integer> path, boolean[] visited){
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
        }

        for (int i=0; i<nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i >0 && !visited[i-1] && nums[i] == nums[i-1]) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(result, nums, path, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
