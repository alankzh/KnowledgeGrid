package alankzh.leetcode;

import alankzh.common.ListNode;

/**
 * 解决了，但不够优雅，继续优化
 */
@Deprecated
public class LeetCode82 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(3);
//        listNode.next.next.next.next = new ListNode(4);
//        listNode.next.next.next.next.next = new ListNode(4);
//        listNode.next.next.next.next.next.next = new ListNode(5);

        System.out.println(deleteDuplicates(listNode));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dump = new ListNode(-101);
        ListNode curOk = null;

        ListNode cur = head;
        ListNode next = head.next;

        int repeatNum = 101;

        for (;  next!= null; ) {
            // 相等，标记重复值，向后走
            if (next.val == cur.val) {
                repeatNum = cur.val;
                next = next.next;
                continue;
            }

            // 不相等，且都不相同，都往后走
            if (cur.val != repeatNum) {
                // 结果链表记录，记录头
                if (curOk == null) {
                    curOk = cur;
                    dump.next = curOk;
                } else {
                    // 结果链表记录，记录尾
                    curOk.next = cur;
                    curOk = curOk.next;
                }
                cur = cur.next;
                next = next.next;
                continue;
            }

            // 不相等，且相同，删除当前链表,重置重复值，继续往后走
            repeatNum = 101;
            cur = next;
            next = next.next;
        }

        // 清理最后的尾部
        if (repeatNum != 101) {
            if (curOk != null) {
                curOk.next = null;
            }
        } else {
            if (curOk != null) {
                curOk.next = cur;
            } else {
                curOk = cur;
                dump.next = curOk;
            }
        }

        return dump.next;
    }

}
