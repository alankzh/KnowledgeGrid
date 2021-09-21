package alankzh.leetcode.free;

public class LeetCode36 {

    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return  false;
        }
        int[][] rowBitmap = new int[9][9];
        int[][] columnBitmap = new int[9][9];
        int[][] cellBitmap = new int[9][9];

        for (int row=0; row<board.length; row++) {
            for (int column=0; column<board[row].length; column++) {
                char c = board[row][column];
                int v = Integer.parseInt(String.valueOf(c));

                int rowV = rowBitmap[row][v-1];
                if (rowV > 0) {
                    return false;
                } else {
                    rowBitmap[row][v-1] = 1;
                }

                int columnV = columnBitmap[column][v-1];
                if (columnV > 0) {
                    return false;
                } else {
                    columnBitmap[column][v-1] = 1;
                }

                int cell = (row / 3) * 3 + (column / 3);
                int cellV = cellBitmap[cell][v-1];
                if (cellV > 0) {
                    return false;
                } else {
                    cellBitmap[cell][v-1] = 1;
                }
            }
        }

        return true;
    }

}
