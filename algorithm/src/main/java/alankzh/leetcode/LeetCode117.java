package alankzh.leetcode;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 按层打印即可。按层打印，要么选择额外的数据结构，保存当前节点所在层。
 * 要么按照我这个想法，用一个标记节点，标记该层结束。
 * 要么使用嵌套循环，记录一个n，保证每次for循环遍历的都是同一层的:
 while(!q.empty()) {
    int n = q.size();
    for (int i = 1; i <= n; ++i) {
        auto f = q.front();
        q.pop();
        // 拓展新节点
        if (f->left) {
            q.push(f->left);
        }
        if (f->right) {
            q.push(f->right);
        }
        // ... 遍历当前取出的 f
    }
 }
 */
@Deprecated
public class LeetCode117 {

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public static void main(String[] args) {
        LeetCode117 solution = new LeetCode117();


    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node levelTag = new Node(-10086);

        Queue<Node> queue = new LinkedList<Node>();

        queue.add(root);
        queue.add(levelTag);

        Node pre = null;
        for (; queue.size() > 0;) {
            Node n = queue.poll();

            if (n != levelTag) {
                if (pre != null) {
                    pre.next = n;
                }
                pre = n;
                if (n.left != null) {
                    queue.add(n.left);
                }
                if (n.right != null) {
                    queue.add(n.right);
                }
            }

            if (n == levelTag) {
                if (pre != null) {
                    pre.next = null;
                    pre = null;
                }
                if (queue.size() > 0) {
                    queue.add(levelTag);
                }
            }
        }

        return root;
    }



}
