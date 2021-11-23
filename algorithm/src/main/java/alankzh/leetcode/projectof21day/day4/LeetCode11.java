package alankzh.leetcode.projectof21day.day4;


public class LeetCode11 {

    public static void main(String[] args) {

    }

    /**
     * 双指针，done
     */
    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int max = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int area = (right - left) * h;
            if (area > max) {
                max = area;
            }

            if (height[left] >= height[right]) {
                int nr = right - 1;
                while (nr > left && height[nr] < height[right]) {
                    nr --;
                }
                right = nr;
            } else {
                int nl = left + 1;
                while (nl < right && height[nl] < height[left]) {
                    nl ++;
                }
                left = nl;
            }
        }

        return max;
    }

    // 暴力扫描，必超时
    public static int maxArea(int[] height) {
        if (height.length <= 0) {
            return 0;
        }

        int max = 0;

        for (int i=0; i<height.length; i++) {
            for (int j=i+1; j<height.length ; j++) {
                int h = height[j] > height[i] ? height[i] : height[j];
                int area = (j-i) * h;
                if (area > max) {
                    max = area;
                }
            }
        }

        return max;
    }


}
