package alankzh.leetcode.projectof21day.day8;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 以边界为开始，进行搜索，搜索到的O标记为S，防止重复搜索。
 *
 * 最后遍历，将S变为O，O变为X，因为此时的O未被边界搜索到
 */
public class LeetCode130 {

    public static void main(String[] args) {

        LeetCode130 solution = new LeetCode130();

//        char[][] board = new char[][]{
//                {'X','O','X','O','X','O'},
//                {'O','X','O','X','O','X'},
//                {'X','O','X','O','X','O'},
//                {'O','X','O','X','O','X'}};

        char[][] board = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}};
        

        solution.solve(board);

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }


    public void solve(char[][] board) {
        int rm = board.length;
        int cm = board[0].length;

        int[] rStep = new int[]{-1,  0, 0,  1};
        int[] cStep = new int[]{ 0, -1, 1,  0};

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<rm; i++) {
            if (board[i][0] == 'O') {
                queue.add(i * cm);
            }
            if (board[i][cm-1] == 'O') {
                queue.add(i * cm + (cm - 1));
            }
        }

        for (int i=0; i<cm; i++) {
            if (board[0][i] == 'O') {
                queue.add(i);
            }
            if (board[rm-1][i] == 'O') {
                queue.add((rm-1) * cm + i);
            }
        }

        while(queue.size() > 0) {
            int index = queue.poll();
            int row = index / cm;
            int column = index % cm;

            if (board[row][column] == 'O') {
                board[row][column] = 'S';

                for (int i=0; i<cStep.length; i++) {
                    int newC = column + cStep[i];
                    int newR = row + rStep[i];

                    if (newC >= 0 && newC < cm && newR >=0 && newR < rm) {
                        queue.add(newR * cm + newC);
                    }
                }
            }
        }

        for (int r=0; r<rm; r++) {
            for (int c=0; c<cm; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
                if (board[r][c] == 'S') {
                    board[r][c] = 'O';
                }
            }
        }
    }
}
