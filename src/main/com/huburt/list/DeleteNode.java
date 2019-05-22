package main.com.huburt.list;

import java.util.ArrayList;

public class DeleteNode {
    /**
     * 删除链表的倒数第N个节点
     * <p>
     * 给定的 n 保证是有效的。
     * <p>
     * 进阶：
     * 你能尝试使用一趟扫描实现吗？
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int index = list.size() - n;
        if (index == 0) {
            ListNode newHead = head.next;
            head.next = null;
            return newHead;
        } else {
            ListNode pre = list.get(index - 1);
            pre.next = pre.next.next;
            return head;
        }
    }

    public static void main(String[] args) {

    }
}
