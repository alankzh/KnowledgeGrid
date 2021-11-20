package alankzh.hot100;

/**
 * 两个关键思路
 * 1. 左右两边界的指针，移动较矮的那一个指针，因为移动较高的那一侧，并不会导致容器的高度变高，故不可能出现容积变大
 * 2. 移动时，若比移动前要矮，也不可能出现比原来的容器容积高。
 */
public class LeetCode11 {

    public int maxArea(int[] height) {
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

}
