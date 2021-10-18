package alankzh.leetcode.projectof21day.day2;

public class LeetCode162 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1};
        System.out.println(new LeetCode162().findPeakElement(arr));
    }

    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isPeak(nums, mid)) {
                return mid;
            }


            if (mid == nums.length || nums[mid] > nums[mid + 1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private boolean isPeak(int[] nums, int index) {
        boolean left = false;
        boolean right = false;
        if (index - 1 < 0) {
            left = true;
        } else {
            left = nums[index] > nums[index - 1];
        }

        if (index + 1 >= nums.length) {
            right = true;
        } else {
            right = nums[index] > nums[index + 1];
        }

        return left && right;
    }
}
