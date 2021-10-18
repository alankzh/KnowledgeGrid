package alankzh.leetcode.projectof21day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Deprecated
public class LeetCode15 {

    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,1,2,-1,-4};
    }

    public List<List<Integer>> threeSum_bad(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i<nums.length; i++) {
            for (int j = i+1; j<nums.length; j++) {
                for (int k = j+1; k<nums.length; k++) {
                    if ((nums[i] + nums[j] + nums[k] == 0)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                    }
                }
            }
        }

        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i=0; i<nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                // 去重
                continue;
            }

            int target = 0 - nums[i];
            for (int j = i + 1; j<nums.length; j++) {
                if (j != i+1 && nums[j] == nums[j - 1]) {
                    // 去重
                    continue;
                }

                int r = nums.length - 1;
                while (j < r && nums[j] + nums[r] > target) {
                    r --;
                }
                if (j == r) {
                    // 整个for循环可以跳出
                    break;
                }
                if (nums[j] + nums[r] == target) {
                    List<Integer> s = new ArrayList<>();
                    s.add(nums[i]);
                    s.add(nums[j]);
                    s.add(nums[r]);
                    result.add(s);
                }
            }
        }

        return result;
    }

}
