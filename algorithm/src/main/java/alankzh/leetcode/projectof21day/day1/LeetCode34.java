package alankzh.leetcode.projectof21day.day1;

public class LeetCode34 {
    public static void main(String[] args) {
        int[] input = new int[] {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] output = new LeetCode34().searchRange(input, target);
        System.out.println(output[0]);
        System.out.println(output[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length <= 0) {
            return result;
        }

        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } if (nums[m] == target) {
                if (nums[l] < target) {
                    l = l + 1;
                }
                if (nums[r] > target) {
                    r = r - 1;
                }
                if (nums[l] == nums[r] && nums[l] == target) {
                    break;
                }
            }
        }

        if (l > r || (l == r && nums[l] != target)) {
            return result;
        }

        result[0] = l;
        result[1] = r;
        return result;
    }
}
