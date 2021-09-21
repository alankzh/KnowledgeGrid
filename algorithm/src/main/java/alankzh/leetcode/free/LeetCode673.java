package alankzh.leetcode.free;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
public class LeetCode673 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,4,7};

        LeetCode673 solution = new LeetCode673();
        int v = solution.findNumberOfLIS(nums);
        System.out.println(v);
    }

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();

        dfs(nums, new ArrayList<Integer>(), 0, map);

        int max = 0;
        for (Integer k : map.keySet()) {
            if (k > max) {
                max = k;
            }
        }

        Integer v = map.get(max);
        if (v != null) {
            return v;
        }
        return 0;
    }

    private void dfs(int[] nums, List<Integer> curList, int index, Map<Integer, Integer> map) {
        if (curList.size() > 0) {
            Integer v = map.get(curList.size());
            if (v != null) {
                map.put(curList.size(), v+1);
            } else {
                map.put(curList.size(), 1);
            }
        }

        int cur = Integer.MIN_VALUE;
        if (curList.size() > 0) {
            cur = curList.get(curList.size() - 1);
        }

        for (int i=index; i<nums.length; i++) {
            if (nums[i] > cur) {
                List<Integer> list2 = new ArrayList<>(curList);
                list2.add(nums[i]);
                dfs(nums, list2, i+1, map);
            }
        }
    }

}
