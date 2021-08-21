package alankzh.leetcode;

public class LeetCode34 {
    public static void main(String[] args) {
        int[] input = new int[] {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] output = searchRange(input, target);
        System.out.println(output[0]);
        System.out.println(output[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

        if (nums.length<=0){
            return result;
        }

        binarySearch(result, nums, target, 0, nums.length-1);

        return result;
    }

    private static void binarySearch(int[] result, int[] nums, int target, int begin, int end) {
        if (begin > end) {
            return;
        }
        int middle = (begin + end )/2;
        if (nums[middle] == target) {
            refreshIndex(result, middle);
        }
        if (nums[middle] < target) {
            binarySearch(result, nums, target, middle+1, end);
        }

        if (nums[middle] == target) {
            binarySearch(result, nums, target, middle+1, end);
            binarySearch(result, nums, target, begin, middle - 1);
        }

        if (nums[middle] > target) {
            binarySearch(result, nums, target, begin, middle - 1);
        }
    }

    private static void refreshIndex (int[] result, int index) {
        if (result[0] == -1 || result[0] > index) {
            result[0] = index;
        }
        if (result[1] == -1 || result[1] < index) {
            result[1] = index;
        }
    }
}
