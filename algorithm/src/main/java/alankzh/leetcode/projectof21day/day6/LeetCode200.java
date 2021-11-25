package alankzh.leetcode.projectof21day.day6;

/**
 * 1. 可暴力求解，其实就是 并查集
 * 2. 深度优先搜索，广度优先搜索，都使用标记法，即将搜索到为同一个岛的，标记，以防被其他搜索搜索到。
 *
 */
public class LeetCode200 {
    public static void main(String[] args) {
        LeetCode200 solution = new LeetCode200();

        char[][] grid = new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}};

        int result = solution.numIslands(grid);

        System.out.println(result);
    }

    /**
     * 并查集，done
     */
    public int numIslands2(char[][] grid) {
        if (grid == null) return 0;

        int[] disjoinSet = new int[grid.length * grid[0].length];
        for (int i=0; i<disjoinSet.length; i++) {
            int row = i / grid[0].length;
            int column = i % grid[0].length;
            if (grid[row][column] == '1') {
                disjoinSet[i] = i;
            } else {
                disjoinSet[i] = -1;
            }
        }

        int[][] step = new int[][]{
                {-1, 0}, {1, 0}, {0, 1}, {0, -1}
        };

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                char c = grid[i][j];
                if (c != '1') {
                    continue;
                }
                for (int[] s : step) {
                    int nr = i + s[0];
                    int nc = j + s[1];
                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1') {
                        union(disjoinSet, i * grid[0].length + j, nr * grid[0].length + nc);
                    }
                }
            }
        }

        int result = 0;
        for (int i=0; i<disjoinSet.length; i++) {
            if (disjoinSet[i] == i) {
                result ++;
            }
        }

        return result;
    }

    private void union(int[] disjoinSet, int index1, int index2) {
        int root1 = disjoinSet[index1];
        while (root1 != disjoinSet[root1]) {
            root1 = disjoinSet[root1];
        }
        int root2 = disjoinSet[index2];
        while (root2 != disjoinSet[root2]) {
            root2 = disjoinSet[root2];
        }
        disjoinSet[root2] = root1;
    }

    public int numIslands(char[][] grid) {
        if (grid == null) return 0;

        int result = 0;

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                char c = grid[i][j];
                if (c == '1') {
                    result ++;
                    searchAndTag(grid, i, j);
                }
            }
        }

        return result;
    }

    private void searchAndTag(char[][] grid, int c, int r) {
        if (c < 0 || r >= grid[0].length || c >= grid.length || r < 0) {
            return;
        }

        char cc = grid[c][r];
        if (cc == '1') {
            grid[c][r] = '0';
            searchAndTag(grid, c+1, r);
            searchAndTag(grid, c-1, r);
            searchAndTag(grid, c, r + 1);
            searchAndTag(grid, c, r - 1);
        }
    }

}
