package alankzh.leetcode.offer31.day4;

public class Offer53_1 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2 ;
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        int count = 0;
        for (int i=l; i<nums.length; i++) {
            if (nums[i] == target) {
                count ++;
            } else {
                break;
            }
        }

        return count;
    }

}
