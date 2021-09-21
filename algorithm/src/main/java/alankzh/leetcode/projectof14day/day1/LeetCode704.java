package alankzh.leetcode.projectof14day.day1;

public class LeetCode704 {

    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }

        int begin = 0;
        int end = nums.length - 1;
        int mid = (begin+end)/2;

        while (begin <= end) {
            int v = nums[mid];
            if (v == target) {
                return mid;
            }
            if (v > target) {
                end = mid - 1;
                mid = (begin+end)/2;
            } else {
                begin = mid + 1;
                mid = (begin+end)/2;
            }
        }

        return -1;
    }

}
