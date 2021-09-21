package alankzh.leetcode.projectof14day.day2;

@Deprecated
/**
 * 第二种方法，可以用count记录跳跃个数，未实现
 */
public class LeetCode189 {

    public void rotate(int[] nums, int k) {
        int rk = k % nums.length;

        reverse(nums, 0, nums.length - rk - 1);
        reverse(nums, nums.length - rk, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int begin, int end) {
        int mod = end - begin;

        for (int i=begin; i<=((begin+end)/2); i++) {
            int temp = nums[i];
            int needIndex = i + mod;
            mod -= 2;
            nums[i] = nums[needIndex];
            nums[needIndex] = temp;
        }
    }

}
