package alankzh.leetcode.projectof21day;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对于存在环的最短路径问题，以及可以回溯的特点，无法使用DP解答~
 * DFS虽然也能解答，但是由于DFS是遍历所有方案的原因，时间复杂度较高，不常用来求最短路径，而常用于寻求是否存在路径
 * 此时BFS就能派上用场啦！
 * 但是需要注意的是，BFS只能用于解决无权图的最短路径问题。
 *
 * 作者：answerer
 * 链接：https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/solution/cshuang-100-bfs-by-answerer-qyx3/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 *
 * bfs能解决最短路径，防重复仍然可以使用标记法。
 * 因为节点之前已经被走过了，那么肯定存在更优路径到达此节点。故可以使用标记法去重，防止环。
 *
 * 未beats 100%
 */
@Deprecated
public class LeetCode1091 {

    public static void main(String[] args) {
        LeetCode1091 solution = new LeetCode1091();

        int[][] grid = new int[][]{{0,0,0},{1,1,0},{1,1,0}};

        int result = solution.shortestPathBinaryMatrix(grid);
        System.out.println(result);
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid[0][0] == 1) {
            return -1;
        }

        int columnMax = grid[0].length;
        int rowMax = grid.length;

        int[] cStep = new int[]{-1, -1, -1,  0,  0,  1, 1,  1};
        int[] rStep = new int[]{-1,  0,  1,  -1, 1, -1, 0,  1};

        int result = -1;

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> currentStepQueue = new LinkedList<>();
        queue.add(0);
        currentStepQueue.add(1);
        while (queue.size() > 0) {
            int step = currentStepQueue.poll();
            int index = queue.poll();
            int column = index / columnMax;
            int row = index % columnMax;

            if (column == columnMax-1 && row == rowMax-1 && grid[column][row] == 0) {
                // 找到路径
                if (result == -1) {
                    result = step;
                } else {
                    result = result > step ? step : result;
                }
                continue;
            }

            if (grid[column][row] == 0) {
                // 标记
                grid[column][row] = 1;
                for (int i=0; i<cStep.length; i++) {
                    int newC = column + cStep[i];
                    int newR = row + rStep[i];
                    if (newC >=0 && newC < columnMax && newR >= 0 && newR < rowMax) {
                        queue.add(newC * (rowMax) + newR);
                        currentStepQueue.add(step+1);
                    }
                }
            }
        }

        return result;
    }



}
