package alankzh.leetcode.free;

public class LeetCode407 {

    public static void main(String[] args) {
        int[][] heightMap = new int[][]{
                {12,13,1,12},
                {13,4,13,12},
                {13,8,10,12},
                {12,13,12,12},
                {13,13,13,13}
        };

        int[][] heightMap2 = new int[][]{
                {12,13,1,12},
                {13,10,13,12},
                {13,10,10,12},
                {12,13,12,12},
                {13,13,13,13}
        };

        int result = new LeetCode407().trapRainWater(heightMap);
        System.out.println(result);
    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        int[][] leftMax = new int[m][n];
        int[][] rightMax = new int[m][n];
        int[][] preMax = new int[m][n];
        int[][] nextMax = new int[m][n];

        for (int i=0; i<m; i++) {
            for (int j=1; j<n; j++) {
                leftMax[i][j] = Math.max(heightMap[i][j - 1], leftMax[i][j - 1]);
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=n - 2; j >= 0; j--) {
                rightMax[i][j] = Math.max(heightMap[i][j + 1], rightMax[i][j + 1]);
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=1; j<m; j++) {
                preMax[j][i] = Math.max(heightMap[j - 1][i], preMax[j - 1][i]);
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=m-2; j>=0; j--) {
                nextMax[j][i] = Math.max(heightMap[j + 1][i], nextMax[j + 1][i]);
            }
        }

        int result = 0;
        for (int i=1; i<m - 1; i++) {
            for (int j=1; j<n-1;j++) {
                int preNextMin = Math.min(preMax[i][j], nextMax[i][j]);
                int leftRightMin = Math.min(leftMax[i][j], rightMax[i][j]);
                int h = Math.min(preNextMin, leftRightMin);
                if (h > heightMap[i][j]) {
                    result += h - heightMap[i][j];
                }
            }
        }

        return result;
    }

}
