package alankzh.leetcode.offer31.day19;

import alankzh.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Offer68_2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list = searchPath(root, p, null);
        List<TreeNode> list2 = searchPath(root, q, null);

        TreeNode res = root;
        for (int i=0; i<list.size() && i<list2.size(); i++) {
            if (list.get(i) == list2.get(i) ) {
                res = list.get(i);
            } else {
                break;
            }
        }

        return res;
    }

    private List<TreeNode> searchPath(TreeNode cur, TreeNode n, List<TreeNode> path) {
        if (path == null) {
            path = new ArrayList<>();
            path.add(cur);
        }

        if (cur == n) {
            return path;
        }

        if (cur.left != null) {
            path.add(cur.left);
            List<TreeNode> list = searchPath(cur.left, n, path);
            if (list != null) return list;
            path.remove(path.size() - 1);
        }

        if (cur.right != null) {
            path.add(cur.right);
            List<TreeNode> list = searchPath(cur.right, n, path);
            if (list != null) return list;
            path.remove(path.size() - 1);
        }

        return null;
    }

}
