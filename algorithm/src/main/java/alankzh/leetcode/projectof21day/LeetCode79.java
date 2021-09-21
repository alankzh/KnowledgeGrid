package alankzh.leetcode.projectof21day;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class LeetCode79 {

    public static void main(String[] args) {
        LeetCode79 solution = new LeetCode79();

//        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "ABCCED";

//        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "SEE";
        char[][] board = new char[][]{{'a','a'}};
        String word = "aaa";

        boolean result = solution.exist(board, word);
        System.out.println(result);
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            return false;
        }

        char[] wordArray = word.toCharArray();

        int m = board.length;
        int n = board[0].length;
        int cellNum = m*n;

        int[] rm = new int[]{1, -1,  0, 0};
        int[] cm = new int[]{0,  0, -1, 1};

        for (int i=0; i<cellNum; i++) {
            int row = i / n;
            int column = i % n;

            boolean match = dfs(board, new boolean[m][n], new ArrayList<>(), wordArray, rm, cm, row, column);
            if (match) {
                return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited,
                        List<Character> path, char[] wordArray,
                        int[] rm, int[] cm, int curr, int curc) {
        char currentChar = wordArray[path.size()];
        if (currentChar != board[curr][curc]) {
            return false;
        } else {
            path.add(currentChar);
            visited[curr][curc] = true;
        }

        if (path.size() == wordArray.length) {
            return true;
        }

        for (int i=0; i<rm.length; i++) {
            int nr = curr + rm[i];
            int nc = curc + cm[i];

            if (nc >= 0 && nc < board[0].length && nr >=0 && nr < board.length
                    && !visited[nr][nc]) {

                boolean match = dfs(board, visited, path, wordArray, rm, cm, nr, nc);
                if (match) {
                    return true;
                }
            }
        }

        path.remove(path.size() - 1);
        visited[curr][curc] = false;

        return false;
    }

}
