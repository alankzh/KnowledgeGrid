package alankzh.leetcode.offer31.day12;

import alankzh.common.ListNode;

public class Offer52 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;
        while (a != null || b != null) {
            if (a == null) {
                a = headA;
            }
            if (b == null) {
                b = headB;
            }
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }

        return null;
    }

}
