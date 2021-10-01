package alankzh.leetcode.projectof14day.day7;

import java.util.ArrayList;
import java.util.List;

public class LeetCode733 {
    public static void main(String[] args) {

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length <=0 || image[0].length<=0) {
            return image;
        }

        int cc = image[0].length;
        int rc = image.length;
        int[][] step = new int[][]{{1, 0}, {0,-1}, {0, 1} , {-1, 0}};
        int beginColor = image[sr][sc];

        List<Integer> list = new ArrayList<>();
        list.add(sr * cc + sc);
        while(list.size() > 0) {
            int v = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            int row = v / 3;
            int column = v % 3;

            System.out.println(row + "," + column);
            int color = image[row][column];
            if (color != beginColor) {
                continue;
            }

            image[row][column] = -1;
            for (int i=0; i<step.length; i++) {
                int[] s = step[i];
                int nr = row + s[0];
                int nc = column + s[1];
                if (nr >= 0 && nr < rc && nc >=0 && nc < cc && image[nr][nc] != -1) {
                    list.add(nr * cc + nc);
                }
            }
        }

        for (int i=0; i<rc; i++) {
            for (int j=0; j<cc; j++) {
                if (image[i][j] == -1) {
                    image[i][j] = newColor;
                }
            }
        }

        return image;
    }
}
