package alankzh.leetcode.projectof14day.day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        Map<Integer, Integer> pickMap = new HashMap<>();
        List<Integer> pathTemp = new ArrayList<>();

        pick(result, nums, pathTemp, pickMap);

        return result;
    }

    private void pick(List<List<Integer>> result, int[] nums, List<Integer> pathTemp, Map<Integer, Integer> pickMap) {
        if (pathTemp.size() == nums.length) {
            result.add(new ArrayList<>(pathTemp));
        }

        for (int i=0; i<nums.length; i++) {
            int v = nums[i];
            if (pickMap.containsKey(v)) {
                continue;
            }

            pathTemp.add(v);
            pickMap.put(v, i);

            pick(result, nums, pathTemp, pickMap);

            pathTemp.remove(pathTemp.size() - 1);
            pickMap.remove(v);
        }
    }
}
