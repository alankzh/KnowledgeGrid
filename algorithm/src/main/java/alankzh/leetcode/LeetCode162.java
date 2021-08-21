package alankzh.leetcode;

@Deprecated
public class LeetCode162 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1};
        System.out.println(findPeakElement(arr));
    }

    public static int findPeakElement(int[] nums) {
        if (nums.length <= 0) {
            return -1;
        }
        for (int i=0; i<nums.length; i++) {
            int leftc = compare(nums, i, i-1);
            int rightc = compare(nums, i, i+1);
            if (leftc == 1 && rightc == 1) {
                return i;
            }
        }
        return -1;
    }

    private static int compare(int[] nums, int leftIndex, int rightIndex) {
        boolean leftMin = leftIndex < 0 || leftIndex == nums.length;
        boolean rightMin = rightIndex <0 || rightIndex == nums.length;
        if (leftMin) {
            if (rightMin) {
                return 0;
            } else {
                return -1;
            }
        }
        if (rightMin) {
            return 1;
        }

        if (nums[leftIndex] < nums[rightIndex]) {
            return -1;
        } else if (nums[leftIndex] == nums[rightIndex]) {
            return 0;
        } else {
            return 1;
        }
    }
}
