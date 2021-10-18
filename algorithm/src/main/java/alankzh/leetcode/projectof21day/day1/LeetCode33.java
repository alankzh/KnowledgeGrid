package alankzh.leetcode.projectof21day.day1;

public class LeetCode33 {

    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                if (nums[left] < nums[mid]) {
                    int index = search(nums, left, mid - 1, target);
                    if (index != -1) return index;
                    left = mid + 1;
                } else {
                    left = left + 1;
                }
            } else if (nums[mid] < target) {
                if (nums[left] < nums[mid]) {
                    left = mid + 1;
                } else {
                    int index = search(nums, mid + 1, right, target);
                    if (index != -1) return index;
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    private int search(int[] nums, int begin, int end, int target) {
        int left = begin;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
