package alankzh.leetcode.offer31.day6;

import alankzh.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Offer32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<TreeNode> list = new ArrayList<>();
        List<Integer> printList = new LinkedList<>();
        list.add(root);
        boolean leftFirst = true;
        while(list.size() > 0) {
            int size = list.size();
            printList = new LinkedList<>();
            for (int i = size - 1; i >= 0; i--) {
                TreeNode node = list.remove(0);
                printList.add(node.val);

                if (node.left != null) list.add(node.left);
                if (node.right != null) list.add(node.right);
            }

            leftFirst = !leftFirst;
            if ( !leftFirst) {
                Collections.reverse(printList);
            }
            result.add(new ArrayList<>(printList));
        }

        return result;
    }
}
