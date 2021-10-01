package alankzh.who;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] nums = new int[]{1,2,5,9,9};
        int target = 9;
        int result = s.solution(nums,target);
        System.out.println(result);
    }

    int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] > X) {
                r = m - 1;
            } else if (A[m] < X){
                l = m;
            } else {
                return m;
            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }

}
