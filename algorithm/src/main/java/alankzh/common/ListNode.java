package alankzh.common;


public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        strb.append(val);
        while (next != null) {
            strb.append("->").append(next.val);
            next = next.next;
        }
        return strb.toString();
    }
}
