package alankzh.temp;

public class MeetUtil {

    public static class CytekMeetListNode {
        public int val;
        public CytekMeetListNode next;
        public CytekMeetListNode(int val) {
            this.val = val;
        }
    }

    public static void printListNode(CytekMeetListNode head) {
        CytekMeetListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.print("null");
        System.out.println();
    }

}
