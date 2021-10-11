package alankzh.leetcode.projectof14day.day9;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode542 {

    public static void main(String[] args) {

    }

    // 不会超时的自底向上动态规划法
    public int[][] updateMatrix2(int[][] mat) {
        if (mat == null || mat.length <= 0) {
            return null;
        }
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                result[i][j] = -1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int v = mat[i][j];
                if (v == 0) {
                    result[i][j] = 0;
                    queue.add(i * n + j);
                }
            }
        }

        while(queue.size() > 0) {
            Integer index = queue.poll();
            int row = index / n;
            int column = index % n;
            int cd = result[row][column];

            for (int i=0; i<step.length; i++) {
                int[] s = step[i];
                int nr = row + s[0];
                int nc = column + s[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && result[nr][nc] == -1) {
                    result[nr][nc] = cd + 1;
                    queue.add(nr * n + nc);
                }
            }
        }

        return result;
    }

    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length <= 0) {
            return null;
        }
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                result[i][j] = -1;
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int v = mat[i][j];
                if ( v == 0) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = bfs(mat, result, i, j, i, j);
                }
            }
        }

        return result;
    }

    private static int[][] step = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int bfs(int[][] mat, int[][] result, int row0, int column0, int row, int column) {
        int d = Math.abs(row - row0) + Math.abs(column - column0);

        int v = mat[row][column];
        if (v == 0) {
            return d;
        }

        int rv = result[row][column];
        if (rv >= 0) {
            return rv + d;
        }

        int mind = Integer.MAX_VALUE;
        for (int i=0; i<step.length; i++) {
            int[] s = step[i];
            int nr = row + s[0];
            int nc = column + s[1];
            int nd =  Math.abs(nr - row0) + Math.abs(nc - column0);

            if (nd > d && nr >=0 && nr < mat.length && nc >= 0 && nc < mat[0].length) {
                int fsd = bfs(mat, result, row0, column0, nr, nc);
                mind  = fsd < mind ? fsd : mind;
            }
        }

        return mind;
    }

}
