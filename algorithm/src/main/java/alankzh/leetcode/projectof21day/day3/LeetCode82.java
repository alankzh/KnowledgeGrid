package alankzh.leetcode.projectof21day.day3;

import alankzh.common.ListNode;


public class LeetCode82 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(3);
//        listNode.next.next.next.next = new ListNode(4);
//        listNode.next.next.next.next.next = new ListNode(4);
//        listNode.next.next.next.next.next.next = new ListNode(5);

        System.out.println(new LeetCode82().deleteDuplicates(listNode));
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode cur = head;
        ListNode pre = dump;

        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                pre = cur;
                cur = cur.next;
                continue;
            }

            ListNode dif = cur.next.next;
            while (dif != null) {
                if (dif.val == cur.val) {
                    dif = dif.next;
                } else {
                    break;
                }
            }

            pre.next = dif;
            cur = dif;
        }

        return dump.next;
    }

}
