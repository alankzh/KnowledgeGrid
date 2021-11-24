package alankzh.leetcode.projectof21day.day5;



public class LeetCode209 {

    public static void main(String[] args) {
        double a = Math.pow(10, 5);
        double b = a*a;
        int c = (int) (a*a);
        System.out.println(b);
        System.out.println(c);


        LeetCode209 solution = new LeetCode209();
        int target = 7;
        int[] nums = new int[]{2,3,1,2,4,3};


        int result = solution.minSubArrayLen2(target, nums);
        System.out.println(result);
    }

    /**
     * 更新窗口的当前和
     */
    public int minSubArrayLen2(int target, int[] nums) {
        long sum = 0;
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        for ( ; right < nums.length; right ++) {
            sum += nums[right];
            while (sum >= target) {
                int l = right - left + 1;
                minLength = minLength > l ? l : minLength;
                sum -= nums[left];
                left ++;
            }
        }
        if (minLength == Integer.MAX_VALUE) return 0;
        return minLength;
    }

    /**
     * 略暴力求解，未打败100%
     * 未错, 尝试移动时更新当前和
     */
    public int minSubArrayLen(int target, int[] nums) {
        int result = 0;
        if (nums == null || nums.length <= 0) {
            return result;
        }

        for (int fi=0, di=0;  fi<nums.length; ) {
            int sum = getSum(nums, fi, di);
            if (sum < target) {
                if (di + 1 < nums.length) {
                    di ++;
                } else {
                    break;
                }
            } else {
                int now = di - fi + 1;
                if (result == 0 || result > now) {
                    result = now;
                }
                fi ++;
            }
        }

        return result;
    }

    private int getSum(int[] nums, int fi, int di) {
        if (fi == di) {
            return nums[fi];
        }

        int sum = 0;
        for (int i=0; fi+i <= di; i++) {
            sum += nums[fi + i];
        }
        return sum;
    }

}
