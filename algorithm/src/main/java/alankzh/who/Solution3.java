package alankzh.who;


public class Solution3 {

    public static void main(String[] args) {
//        int[] arr = new int[]{3,2,3};
//        int[] arr = new int[]{3,-7,3,-7,3};
        int[] arr = new int[]{7, 4, -2, 4, -2, -9};
//        int[] arr = new int[]{3,2,3};
        int result = new Solution3().solution1(arr);
        System.out.println(result);
    }

    public int solution1(int[] A) {
        // write your code in Java SE 8
        int max = 0;
        if (A == null || A.length <= 0) {
            return max;
        }

        for (int i=0; i<A.length; i++) {
            int end = notMatch(A, i);
            int l = end - i;
            max = max > l ? max : l;
        }

        return max;
    }

    private int notMatch(int[] A, int beginIndex) {
        int next = beginIndex + 1;
        if (next >= A.length) {
            return next;
        }

        int odd = A[beginIndex];
        int even = A[next];
        boolean switched = false;
        for (int i=beginIndex; i<A.length; i++) {
            boolean match = false;
            if (switched) {
                match = (A[i] == even);
                switched = false;
            } else {
                match = (A[i] == odd);
                switched = true;
            }
            if ( !match) {
                return i;
            }
        }

        return A.length;
    }

}
