package alankzh.leetcode.projectof21day.day2;

public class LeetCode153 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,2};
        System.out.println(new LeetCode153().findMin(arr));
    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length <= 0) {
            throw new RuntimeException();
        }

        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else if (nums[mid] < nums[r]){
                r = mid;
            } else {
                r = r - 1;
            }
        }

        return nums[l];
    }

}
