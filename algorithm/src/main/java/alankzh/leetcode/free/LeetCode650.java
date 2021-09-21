package alankzh.leetcode.free;

public class LeetCode650 {

    public static void main(String[] args) {
        LeetCode650 solution = new LeetCode650();
        int result = solution.minSteps(9);
        System.out.println(result);
    }

    public int minSteps(int n) {
        if (n <= 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }

        int count = 0;
        int cur = n;
        while (cur != 1) {
            for (int i=cur/2; i > 0; i--) {
                if (cur % i == 0) {
                    count = count + (cur/i);
                    cur = i;
                    break;
                }
            }
        }

        return count;
    }

}
