package alankzh.leetcode.projectof21day;

@Deprecated
public class LeetCode33 {

    public static void main(String[] args) {

    }

    public static int search(int[] nums, int target) {
        if (nums.length <= 0) {
            return -1;
        }
        return binarySearch(nums, target, 0, nums.length-1);
    }

    private static int binarySearch(int[] nums, int target, int begin, int end) {
        if (begin > end) {
            return -1;
        }

        int middle = (begin + end ) / 2;
        if (nums[middle] == target) {
            return middle;
        } else {
            int left = binarySearch(nums, target, begin, middle-1);
            int right = binarySearch(nums, target, middle+1, end);
            if (left != -1){
                return left;
            }
            if (right != -1) {
                return right;
            }
            return -1;
        }
    }

}
