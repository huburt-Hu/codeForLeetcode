package main.com.huburt.list;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode[" +val + ']';
    }

    public String getList() {
        StringBuilder sb = new StringBuilder("[");
        ListNode temp = this;
        while (temp != null) {
            sb.append(temp.val).append(",");
            temp = temp.next;
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("]");
        return sb.toString();
    }
}