package alankzh.leetcode.offer31.day18;

import alankzh.common.TreeNode;

@Deprecated
public class Offer55_2 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if ( (Math.abs(dep(root.left) - dep(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }

        return false;
    }

    private int dep(TreeNode n) {
        if (n == null) {
            return 0;
        }
        return Math.max(dep(n.left), dep(n.right)) + 1;
    }

}
