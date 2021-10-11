package alankzh.leetcode.projectof14day.day9;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode994 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1},{2},{1},{2}};
        int result = new LeetCode994().orangesRotting(grid);
        System.out.println(result);
    }

    public int orangesRotting(int[][] grid) {
        int time = 0 ;
        int posion = -10086;
        int[][] step = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(i * grid[0].length + j);
                }
            }
        }

        if (queue.size() > 0) {
            queue.add(posion);
        }

        while(queue.size() > 0) {
            int index = queue.poll();
            if (index == posion) {
                if (queue.size() > 0) {
                    time ++;
                    queue.add(posion);
                }
                continue;
            }

            int row = index / grid[0].length;
            int column = index % grid[0].length;

            for (int i=0; i<step.length; i++) {
                int[] s = step[i];
                int nrow = row + s[0];
                int ncolumn = column + s[1];
                if (nrow >=0 && nrow < grid.length && ncolumn >=0 && ncolumn < grid[0].length && grid[nrow][ncolumn] == 1) {
                    grid[nrow][ncolumn] = 2;
                    queue.add(nrow * grid[0].length + ncolumn);
                }
            }
        }

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return time;
    }

}
