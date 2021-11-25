package alankzh.leetcode.projectof21day.day6;

import java.util.HashSet;
import java.util.Set;

/**
 * 与leetcode200类似，可使用搜索标记法
 */
public class LeetCode547 {

    public static void main(String[] args) {
        LeetCode547 solution = new LeetCode547();

        int[][] grid = new int[][]{{1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
                {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},
                {0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},
                {0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},
                {1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},
                {0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},
                {0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}};

        int result = solution.findCircleNum2(grid);
        System.out.println(result);
    }

    public int findCircleNum2(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        int[] disjoinSet = new int[grid.length];
        for (int i=0; i<disjoinSet.length; i++) {
            disjoinSet[i] = i;
        }

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    union(disjoinSet, i, j);
                }
            }
        }

        int result = 0;
        for (int i=0; i<disjoinSet.length; i++) {
            if (i == disjoinSet[i]) {
                result ++;
            }
        }

        return result;
    }

    private void union(int[] disjoinSet, int i, int j) {
        int rooti = disjoinSet[i];
        while (rooti != disjoinSet[rooti]) {
            rooti = disjoinSet[rooti];
        }
        int rootj = disjoinSet[j];
        while (rootj != disjoinSet[rootj]) {
            rootj = disjoinSet[rootj];
        }

        disjoinSet[rootj] = rooti;
    }


    public int findCircleNum(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        int result = 0;
        Set<Integer> searchedCity = new HashSet<>();

        for (int city = 0; city < grid.length ; city ++) {
            if (grid[city][city] == 1) {
                result ++;
                searchCity(grid, city, searchedCity);
            }
        }

        return result;
    }

    private void searchCity(int[][] grid, int city, Set<Integer> searchedCity) {
        if (searchedCity.contains(city)) {
            return;
        } else {
            searchedCity.add(city);
        }
        for (int i=0; i<grid[city].length; i++) {
            if (grid[city][i] == 1) {
                grid[city][i] = 0;
                searchCity(grid, i, searchedCity);
            }
        }
    }

}

