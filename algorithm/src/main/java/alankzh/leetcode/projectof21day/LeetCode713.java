package alankzh.leetcode.projectof21day;

/**
 * 暴力查找超时
 * 1.
 */
@Deprecated
public class LeetCode713 {

    public static void main(String[] args) {
        LeetCode713 solution = new LeetCode713();

        int[] nums = new int[]{10,5,2,6};
        int k = 100;
        int count = solution.numSubarrayProductLessThanK(nums, k);
        System.out.println(count);
    }

    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        return -1;
    }

    /**
     * 暴力，超时
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int fi = 0;
        int ei = 0;
        int result = 0;
        for ( ;  fi <nums.length; ) {
            int m = multiple(nums, fi, ei);
            if (m < k) {
                result ++;
                if (ei+1 >= nums.length) {
                    fi ++;
                    ei = fi;
                } else {
                    ei ++;
                }
            } else {
                fi ++;
                ei = fi;
            }
        }

        return result;
    }

    private int multiple(int[] nums, int fi, int ei) {
        if (fi == ei) {
            return nums[fi];
        }
        int m = 1;
        for (int i=0; fi+i <= ei; i++) {
            m = m*nums[fi+i];
        }
        return m;
    }

}
