package alankzh.leetcode;

import alankzh.common.ListNode;

@Deprecated
public class LeetCode82 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next.next = new ListNode(5);

        System.out.println(deleteDuplicates(listNode));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = null;
        ListNode end = null;

        ListNode cur = head;
        ListNode next = head.next;

        int repeatNum = Integer.MAX_VALUE;

        for (;  next != null; ) {
            if (next.val != cur.val) {
                if (cur.val != repeatNum) {
                    if (result == null && end == null) {
                        result = cur;
                        end = cur;
                    } else {
                        end.next = cur;
                    }
                }
                repeatNum = Integer.MAX_VALUE;
            } else {
                repeatNum = cur.val;
            }

            cur = cur.next;
            next = next.next;
        }

        return result;
    }

    private static void add(ListNode result, ListNode end, ListNode wantAdd) {
        if (result == null && end == null) {
            result = wantAdd;
            end = wantAdd;
            return;
        }
        end.next = wantAdd;
    }
}
