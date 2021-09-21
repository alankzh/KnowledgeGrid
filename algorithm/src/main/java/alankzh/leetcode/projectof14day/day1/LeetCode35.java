package alankzh.leetcode.projectof14day.day1;

public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        if (nums.length == 0) {
            return 0;
        }


        int begin = 0;
        int end = nums.length - 1;
        int mid = begin + (end - begin) / 2;

        while (begin <= end) {
            int v = nums[mid];
            if (v == target) {
                return mid;
            }
            if (v > target) {
                end = mid - 1;
                mid = begin + (end - begin) / 2;
            } else {
                begin = mid + 1;
                mid = begin + (end - begin) / 2;
            }
        }

        return mid;
    }
}
