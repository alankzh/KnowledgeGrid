package alankzh.leetcode.projectof21day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排序后，当前数与上一个数相同，且当前选择集未包含上一个数，则当前子集必定与上一个数的子集重复。可跳过
 */
@Deprecated
public class LeetCode90 {

    public static void main(String[] args) {
        LeetCode90 solution = new LeetCode90();

        int[] nums = new int[]{1, 2, 2};

        List<List<Integer>> result = solution.subsetsWithDup(nums);
        System.out.println(result);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums == null || nums.length <= 0) {
            return result;
        }

        Arrays.sort(nums);

        for (int i=1; i<=nums.length; i++) {
            pick(i, nums, 0, new ArrayList<>(), result);
        }

        return result;
    }

    private void pick(int pickNum, int[] nums,int begin, List<Integer> picked, List<List<Integer>> result) {
        if (pickNum <= 0) {
            result.add(picked);
            return;
        }
        for (int i=begin; i<nums.length; i++) {
            int pre = i - 1;
            if (pre >=begin && nums[pre] == nums[i]) {
                continue;
            }
            picked.add(nums[i]);
            pick(pickNum - 1, nums, i+1, new ArrayList<>(picked), result);
            picked.remove(picked.size()-1);
        }
    }

}
