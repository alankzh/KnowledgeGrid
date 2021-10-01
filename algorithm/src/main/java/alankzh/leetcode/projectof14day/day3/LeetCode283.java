package alankzh.leetcode.projectof14day.day3;

public class LeetCode283 {

    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }

        int zeroCount = 0;
        for (int i=0; i<nums.length; i++) {
            int v = nums[i];
            if (v == 0) {
                zeroCount ++;
            } else {
                nums[i - zeroCount] = v;
            }
        }

        for ( ; zeroCount > 0; zeroCount --) {
            nums[nums.length - zeroCount] = 0;
        }
    }

}
