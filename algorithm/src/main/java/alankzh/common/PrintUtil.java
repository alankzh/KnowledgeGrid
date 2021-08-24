package alankzh.common;

import java.util.LinkedList;
import java.util.Queue;

public class PrintUtil {

    public static void printArray(int[] array) {
        for (int i=0; i<array.length; i++) {
            if (i!=0){
                System.out.print(",");
            }
            System.out.print(array[i]);
        }
    }

    public static void printTwoDimensionalArray(int[][] array) {
        for (int i=0; i<array.length; i++) {
            printArray(array[i]);
            System.out.println();
        }
    }

    public static void printTreeNode(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode emptyNode = new TreeNode(-1);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean hasNotEmptyNode = true;
        while (queue.size() > 0) {
            int curSize = queue.size();
            if (!hasNotEmptyNode) {
                break;
            }
            hasNotEmptyNode = false;
            for (int i=0; i<curSize; i++) {
                TreeNode treeNode = queue.poll();
                if (i > 0) {
                    System.out.print(",");
                }

                if (treeNode == emptyNode) {
                    System.out.print("null");
                    continue;
                }

                System.out.print(treeNode.val);

                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                    hasNotEmptyNode = true;
                } else {
                    queue.add(emptyNode);
                }
                if (treeNode.right != null) {
                    hasNotEmptyNode = true;
                    queue.add(treeNode.right);
                } else {
                    queue.add(emptyNode);
                }
            }
            System.out.println();
        }
    }
}
