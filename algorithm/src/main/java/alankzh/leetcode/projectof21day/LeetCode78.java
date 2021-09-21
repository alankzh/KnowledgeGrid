package alankzh.leetcode.projectof21day;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯是基于dfs之上的剪枝，掌握不牢靠
 *
 * 模板:

 res = []
 path = []

 def backtrack(未探索区域, res, path):
    if path 满足条件:
        res.add(path) # 深度拷贝
        # return  # 如果不用继续搜索需要 return
    for 选择 in 未探索区域当前可能的选择:
        if 当前选择符合要求:
            path.add(当前选择)
            backtrack(新的未探索区域, res, path)
            path.pop()

 解决一个回溯问题，实际上就是一个决策树的遍历过程
 递归，向树的下一层遍历，for循环，在树的同一层遍历
 */
@Deprecated
public class LeetCode78 {

    public static void main(String[] args) {
        LeetCode78 solution = new LeetCode78();

        int[] nums = new int[]{1,2,3};
        List<List<Integer>> result = solution.subsets(nums);
        System.out.println(result);
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums == null || nums.length <= 0) {
            return result;
        }

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
//            if ( !picked.contains(nums[i])) {
                picked.add(nums[i]);
                pick(pickNum - 1, nums, i+1, new ArrayList<>(picked), result);
                picked.remove(picked.size()-1);
//            }
        }
    }
}
