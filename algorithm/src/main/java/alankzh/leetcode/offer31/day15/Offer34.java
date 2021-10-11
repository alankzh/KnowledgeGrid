package alankzh.leetcode.offer31.day15;

import alankzh.common.Node;

public class Offer34 {


    public static void main(String[] args) {
        Node node = new Node(4);
        node.left = new Node(2);
        node.right = new Node(5);
        node.left.left = new Node(1);
        node.left.right = new Node(3);
        new Offer34().treeToDoublyList(node);
    }

    public Node treeToDoublyList(Node root) {
        Node node = iter(root);

        return node;
    }

    private Node iter(Node node){
        if (node == null) {
            return null;
        }

        Node l = iter(node.left);

        Node head = node;
        Node tail = node;
        if (l != null) {
            head = l;
            tail = l;
            if (l.left != null) {
                tail = l.left;
            }

            node.left = tail;
            tail.right = node;
            head.left = node;
            tail = node;
        }

        Node r = iter(node.right);

        if (r != null) {
            Node rightHead = r;
            Node rightTail = r;
            if (r.left != null) {
                rightTail = r.left;
            }

            tail.right = rightHead;
            rightHead.left = tail;
            head.left = rightTail;
            rightTail.right = head;
            tail = rightTail;
        }

        head.left = tail;
        tail.right = head;

        return head;
    }

}
