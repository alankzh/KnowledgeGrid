package alankzh.leetcode.projectof21day.day5;

public class LeetCode713 {

    public static void main(String[] args) {
        LeetCode713 solution = new LeetCode713();

        int[] nums = new int[]{10,5,2,6};
        int k = 100;
        int count = solution.numSubarrayProductLessThanK2(nums, k);
        System.out.println(count);
    }

    /**
     * 每次只需要找到一个能满足的最大区间即可。
     * 对于区间内的统计，要去重，则固定一个新的子数组开头，这里是right，
     * 该区间内:
     *  right-left+1的切入点是思维要放在区间的右边往左边延伸，
     *  例如区间[1, 2, 3, 4]满足要求，固定住right(4)的点，
     *  可选区间右[4]、[4, 3]、[4, 3, 2]、[4, 3, 2, 1]即为数组的长度，
     *  也就是right-left+1。而right是递增的，此时[1, 2, 3]的区间已经处理完（[3]、[3, 2]、[3、2、1]）。
     *  如果从left为切入点，就会有[1, 2, 3, 4]和[1, 2, 3]都有[1]，不就是重复了的错乱思维。
     */
    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int result = 0;
        int left = 0;
        int right = 0;
        int multiple = 1;
        for ( ; right < nums.length; right ++) {
            multiple *= nums[right];
            while (multiple >= k && left <= right) {
                multiple /= nums[left];
                left ++;
            }

            result += right - left + 1;
        }
        return result;
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
