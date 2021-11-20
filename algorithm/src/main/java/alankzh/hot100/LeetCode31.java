package alankzh.hot100;

import alankzh.leetcode.projectof21day.LeetCode17;

import java.util.Arrays;

public class LeetCode31 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1};
        new LeetCode31().nextPermutation(nums);
    }


    /**
     * 通过寻找非降序点(nums[i] < nums[i + 1]), 可简化查找。
     * 同时此时可以确认[i+1,n)皆为降序。
     * 交换i与从右往左第一个大于i的j后，仍然满足降序。
     * 故最后将i之后的变为升序，不需要排序，仅需要反转
     *
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i --;
        }

        if (i < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int j = nums.length - 1;
        for ( ; j > i; j --) {
            if (nums[j] > nums[i]) {
                break;
            }
        }

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        reverse(nums, i + 1, nums.length - 1);
    }

    public void reverse(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }
        
        int mid = begin + (end - begin) / 2;
        for (int i = begin, m = end; i <= mid; i++, m--) {
            int temp = nums[i];
            nums[i] = nums[m];
            nums[m] = temp;
        }
    }


    /**
     * 时间复杂度不够, 查找最小数时，存在重复查找
     * 变换交换数右边时，存在额外时间复杂度
     */
    public void nextPermutation1(int[] nums) {
        int left = -1;
        int right = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    left = i;
                    right = j;
                    break;
                }
            }
            if (left != -1) break;
        }

        if (left == -1) {
            Arrays.sort(nums);
        } else {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            Arrays.sort(nums, left + 1, nums.length);
        }
    }



}
