package alankzh.base;


import alankzh.common.BuildUtil;
import alankzh.common.TreeNode;

/**
 * 树的遍历
 */
public class TreeTraversal {

    public static void main(String[] args) {
        TreeTraversal t = new TreeTraversal();

        Integer[] tree = new Integer[]{3,9,20,null,null,15,7};

        TreeNode root = BuildUtil.buildTreeFromArray(tree);

        t.preOrder(root);
    }

    /**
     * 前序遍历
     * 先打印根节点，再打印左子节点，再打印右子节点
     * preorder-traversal
     */
    public void preOrder(TreeNode root){
        if (root == null) {
            return;
        }
        System.out.println(root);
        preOrder(root.left);
        preOrder(root.right);
    }





}
