package alankzh.leetcode;

@Deprecated
public class LeetCode11 {

    public static void main(String[] args) {

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

    public static int maxArea2(int[] height) {
        return 0;
    }

}
