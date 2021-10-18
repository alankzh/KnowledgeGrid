package alankzh.leetcode.offer31.day16;

public class Offer45 {
    public String minNumber(int[] nums) {
        for (int i=1; i<nums.length; i++) {
            for (int j=i; j>0 && compare(nums[j], nums[j - 1]) < 0; j--) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
            }
        }

        StringBuilder stb = new StringBuilder();
        for (int n : nums) {
            stb.append(n);
        }

        return stb.toString();
    }

    private int compare(int l, int r) {
        long lf = Long.valueOf(l + "" + r);
        long rf = Long.valueOf(r + "" + l);
        return Long.compare(lf, rf);
    }
}
