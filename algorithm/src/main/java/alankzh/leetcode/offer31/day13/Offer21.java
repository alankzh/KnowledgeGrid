package alankzh.leetcode.offer31.day13;

public class Offer21 {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return nums;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 == 0 && nums[right] % 2 != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            if (nums[left] % 2 != 0) {
                left = left + 1;
            }
            if (nums[right] % 2 == 0) {
                right = right - 1;
            }
        }

        return nums;
    }
}
