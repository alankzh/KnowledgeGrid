package alankzh.offer;

public class Offer04 {

    public static void main(String[] args) {
//        int[][] arr = new int[][]{
//                {1,4,7,11,15},
//                {2,5,8,12,19},
//                {3,6,9,16,22},
//                {10,13,14,17,24},
//                {18,21,23,26,30}};

//        int[][] arr = new int[][]{
//                {1,4,7,11,15},
//                {2,5,8,12,19},
//                {3,6,9,16,22},
//                {10,13,14,17,24},
//                {18,21,23,26,30}};
        int[][] arr = new int[][]{{-5}};

        int num = -5;

        Offer04 solution = new Offer04();

        boolean result = solution.findNumberIn2DArray(arr, num);
        System.out.println(result);
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return false;
        }

        int searchRow = matrix.length-1;
        int searchColumn = 0;

        while (searchRow >= 0 && searchColumn < matrix[0].length) {
            int c = Integer.compare(matrix[searchRow][searchColumn], target);
            if (c == 0) {
                return true;
            } else if (c < 0) {
                searchColumn++;
            } else {
                searchRow--;
            }
        }

        return false;
    }

}
