package alankzh.leetcode.offer31.day20;

import alankzh.common.TreeNode;

public class Offer07 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length <= 0) {
            return null;
        }

        return buildTreeFromIndex(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTreeFromIndex(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        TreeNode root = new TreeNode();
        root.val = preorder[pl];

        int iroot = il;
        for (int i = il; i <= ir; i++) {
            if (inorder[i] == root.val) {
                iroot = i;
                break;
            }
        }
        int len = iroot - il;
        if (len > 0) {
            root.left = buildTreeFromIndex(preorder,inorder, pl + 1, pl + len, il, il + len - 1);
        }

        if (pr - pl > len) {
            root.right = buildTreeFromIndex(preorder, inorder, pl + 1 + len, pr, il + len + 1, ir);
        }

        return root;
    }

}
