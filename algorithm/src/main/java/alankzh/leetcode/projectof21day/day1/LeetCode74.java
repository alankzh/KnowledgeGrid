package alankzh.leetcode.projectof21day.day1;

public class LeetCode74 {
    public static void main(String[] args) {

    }


    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return false;
        }

        int topr = 0;
        int bottomr = matrix.length - 1;
        while (topr <= bottomr) {
            int midr = topr + (bottomr - topr) / 2;
            System.out.println(topr + "," + midr + "," + bottomr);
            if (matrix[midr][0] == target) {
                return true;
            } else if (matrix[midr][0] > target) {
                bottomr = midr - 1;
            } else {
                if (matrix[midr][matrix[0].length - 1] >= target) {
                    return search(matrix[midr], target);
                } else {
                    topr = midr + 1;
                }
            }
        }

        return false;
    }

    private boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }
}
