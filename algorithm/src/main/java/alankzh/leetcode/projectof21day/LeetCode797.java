package alankzh.leetcode.projectof21day;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 路径和深度优先搜索的逻辑不太明晰
 */
@Deprecated
public class LeetCode797 {

    public static void main(String[] args) {
        LeetCode797 solution = new LeetCode797();

        int[][] graph = new int[][]{{1,2},{3},{3},{}};

        List<List<Integer>> result = solution.allPathsSourceTarget(graph);
        System.out.println(result);
    }


    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        if (graph == null) {
            return result;
        }

        dfs(graph, result, new ArrayList<>(), 0);

        return result;
    }

    private void dfs(int[][] graph, List<List<Integer>> result, List<Integer> path, int curNode) {
        path.add(curNode);
        if (curNode == graph.length - 1) {
            result.add(new ArrayList<>(path));
        }
        for (int i=0; i<graph[curNode].length; i++) {
            dfs(graph, result, new ArrayList<>(path), graph[curNode][i]);
        }
    }


}
