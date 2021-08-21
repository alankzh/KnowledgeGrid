package alankzh.leetcode;

public class LeetCode74 {
    public static void main(String[] args) {

    }


    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length <= 0 || matrix[0].length <= 0) {
            return false;
        }

        int row = binarySearchWantSearchRow(matrix, target);
        if (row == -1) {
            return false;
        }

        return binarySearch(matrix[row], target);
    }

    private static int binarySearchWantSearchRow(int[][] matrix, int target) {
        int begin = 0;
        int end = matrix.length - 1;

        for ( ; begin <= end ; ) {
            int middle = (begin + end) / 2;
            int n = matrix[middle].length;
            boolean lt = matrix[middle][0] <= target;
            boolean gt = matrix[middle][n-1] >= target;
            if (lt && gt) {
                return middle;
            }

            if ( lt && !gt ) {
                begin = middle + 1;
                continue;
            }

            if ( !lt && gt) {
                end = middle -1 ;
                continue;
            }
        }

        return -1;
    }

    private static boolean binarySearch(int[] row, int target) {
        int begin = 0;
        int end = row.length -1 ;
        for ( ; begin<=end; ) {
            int middle = (begin + end) / 2 ;

            if (row[middle] == target) {
                return true;
            }

            if (row[middle] < target) {
                begin = middle + 1;
                continue;
            }

            if (row[middle] > target) {
                end = middle -1;
                continue;
            }
        }

        return false;
    }
}
