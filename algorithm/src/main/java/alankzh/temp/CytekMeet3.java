package alankzh.temp;

import java.util.HashMap;
import java.util.Map;

public class CytekMeet3 {

    public static void main(String[] args) {
        MeetUtil.CytekMeetListNode head = new MeetUtil.CytekMeetListNode(10);
        head.next = new MeetUtil.CytekMeetListNode(6);
        head.next.next = new MeetUtil.CytekMeetListNode(9);
        head.next.next.next = new MeetUtil.CytekMeetListNode(6);

        MeetUtil.CytekMeetListNode result = new CytekMeet3().deleteDump2(head);
        MeetUtil.printListNode(result);
    }

    // O(n^2)
    private MeetUtil.CytekMeetListNode deleteDump2(MeetUtil.CytekMeetListNode head) {
        if (head == null) {
            return null;
        }

        MeetUtil.CytekMeetListNode dump = new MeetUtil.CytekMeetListNode(-10086);
        MeetUtil.CytekMeetListNode pre = dump;
        dump.next = head;
        MeetUtil.CytekMeetListNode cur = head;

        int index = 0;
        while (cur != null) {
            if ( !isDump(head, index, cur.val)) {
                pre = cur;
                cur = cur.next;
                index ++;
                continue;
            }

            while ( cur != null && isDump(head, index, cur.val)) {
                cur = cur.next;
            }
            pre.next = cur;
            index ++;
        }

        return dump.next;
    }

    private boolean isDump(MeetUtil.CytekMeetListNode head, int index, int target) {
        MeetUtil.CytekMeetListNode cur = head;
        int curIndex = 0;
        while (cur != null) {
            if (curIndex >= index) {
                break;
            }
            if (cur.val == target) {
                return true;
            }
            cur = cur.next;
            curIndex ++;
        }

        return false;
    }

    private MeetUtil.CytekMeetListNode deleteDump(MeetUtil.CytekMeetListNode head) {
        if (head == null) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        MeetUtil.CytekMeetListNode dump = new MeetUtil.CytekMeetListNode(-10086);
        MeetUtil.CytekMeetListNode pre = dump;
        dump.next = head;
        MeetUtil.CytekMeetListNode cur = head;

        while (cur != null) {
            if ( !map.containsKey(cur.val)) {
                map.put(cur.val, 1);
                pre = cur;
                cur = cur.next;
                continue;
            }

            while ( cur != null && map.containsKey(cur.val)) {
                cur = cur.next;
            }
            pre.next = cur;
        }
        return dump.next;
    }



}
