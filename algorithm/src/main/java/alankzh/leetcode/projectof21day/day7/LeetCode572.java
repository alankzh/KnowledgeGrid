package alankzh.leetcode.projectof21day.day7;

import alankzh.common.BuildUtil;
import alankzh.common.PrintUtil;
import alankzh.common.TreeNode;


/**
 * 还可以使用树hash，和打印之后的kmp比较
 */
@Deprecated
public class LeetCode572 {

    public static void main(String[] args) {
        LeetCode572 solution = new LeetCode572();

        Integer[] rootArr = new Integer[]{1,1};
        Integer[] subRootArr = new Integer[]{1};

        TreeNode root = BuildUtil.buildTreeFromArray(rootArr);
        TreeNode subRoot = BuildUtil.buildTreeFromArray(subRootArr);

        PrintUtil.printTreeNode(root);
        System.out.println();
        PrintUtil.printTreeNode(subRoot);

        boolean result = solution.isSubtree(root, subRoot);
        System.out.println(result);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return false;
        }

        if (root.val == subRoot.val && isMatch(root, subRoot)) {
             return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isMatch(TreeNode root, TreeNode subRoot) {
        if (subRoot == null && root == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }

        if (root.val == subRoot.val) {
            return isMatch(root.left, subRoot.left) && isMatch(root.right, subRoot.right);
        } else {
            return false;
        }
    }

}
