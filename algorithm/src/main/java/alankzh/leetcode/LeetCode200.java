package alankzh.leetcode;

/**
 * 1. 可暴力求解，其实就是 并查集
 * 2. 深度优先搜索，广度优先搜索，都使用标记法，即将搜索到为同一个岛的，标记，以防被其他搜索搜索到。
 *
 */
@Deprecated
public class LeetCode200 {
    public static void main(String[] args) {
        LeetCode200 solution = new LeetCode200();

        char[][] grid = new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}};

        int result = solution.numIslands(grid);

        System.out.println(result);
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
