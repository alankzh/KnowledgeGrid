package alankzh.leetcode.projectof14day.day2;

import java.util.Arrays;

@Deprecated
/**
 * 可以一个指针从0开始，另一个指针从n-1开始，比较两者中较大的值
 */
public class LeetCode977 {


    public int[] sortedSquares(int[] nums) {

        if (nums == null) {
            return null;
        }
        int[] result = new int[nums.length];

        int k = 0;
        for ( ; k<nums.length; k++) {
            if (nums[k] >= 0) {
                break;
            }
        }

        int left = k-1;
        for (int i=0; i<nums.length; i++) {
            int l = Integer.MAX_VALUE;
            int r = Integer.MAX_VALUE;
            if (left >= 0) {
                l = nums[left] * nums[left];
            }
            if (k < nums.length) {
                r = nums[k] * nums[k];
            }

            if (l < r) {
                result[i] = l;
                left --;
            } else {
                result[i] = r;
                k ++;
            }
        }

        return result;
    }
}
