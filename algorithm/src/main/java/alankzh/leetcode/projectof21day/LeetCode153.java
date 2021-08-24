package alankzh.leetcode.projectof21day;

public class LeetCode153 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,2};
        System.out.println(binarySearch(arr, 0, arr.length-1));
    }

    private static int binarySearch(int[] nums, int begin, int end) {
        int result = nums[begin];

        for ( ; begin<=end; ){
            int middle = (begin + end) / 2;

            int right = nums[end];

            if (begin == end) {
                return right;
            }

            if (nums[middle] > right) {
                begin = middle + 1;
            } else {
                end = middle;
            }
        }

        return result;
    }

}
