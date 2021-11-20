package alankzh.leetcode.offer31.day20;

public class Offer33 {

    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }

    private boolean verify(int[] arr, int begin, int end) {
        if (begin >= end) {
            return true;
        }

        int root = arr[end];
        int rightBegin = begin;
        for ( ; rightBegin < end; rightBegin ++ ) {
            if (arr[rightBegin] > root) {
                break;
            }
        }

        if (rightBegin < end) {
            for (int i = rightBegin; i < end; i++) {
                if (arr[i] < root) {
                    return false;
                }
            }
        }

        return verify(arr, begin, rightBegin - 1) && verify(arr, rightBegin, end - 1);
    }

}
