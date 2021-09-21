package alankzh.leetcode.projectof14day.day1;

public class LeetCode278 {

    public static void main(String[] args) {

    }

    public int firstBadVersion(int n) {
        int min = n;

        int begin = 1;
        int end = n;
        int mid = begin + (end - begin) / 2;

        while (begin <= end) {
            if (isBadVersion(mid)) {
                min = mid < min ? mid : min;
                end = mid - 1;
                mid = begin + (end - begin) / 2;
            } else {
                begin = mid + 1;
                mid = begin + (end - begin) / 2;
            }
        }

        return min;
    }

    private boolean isBadVersion(int v){
        return false;
    }

}
