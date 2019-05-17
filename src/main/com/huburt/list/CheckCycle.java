package main.com.huburt.list;

public class CheckCycle {

    /**
     * 判断链表中是否有环，快慢指针方法
     * <p>
     * 空间复杂度将是 O(1)
     * <p>
     * 每次移动较快的指针 2 步，每次移动较慢的指针 1 步。
     * 如果没有循环，快指针需要 N/2 次才能到达链表的末尾，其中 N 是链表的长度。
     * 如果存在循环，则快指针需要 M 次才能赶上慢指针，其中 M 是列表中循环的长度。
     * 显然，M <= N 。所以我们将循环运行 N 次。对于每次循环，我们只需要常量级的时间。因此，该算法的时间复杂度总共为 O(N)。
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //示例 1：
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        boolean b1 = hasCycle(n1);
        System.out.println("示例 1：" + b1);

        //示例 2：
        ListNode no1 = new ListNode(1);
        ListNode no2 = new ListNode(2);
        no1.next = no2;
        no2.next = no1;
        boolean b2 = hasCycle(no1);
        System.out.println("示例 2：" + b2);

        //示例 3：
        ListNode node1 = new ListNode(1);
        boolean b3 = hasCycle(node1);
        System.out.println("示例 3：" + b3);
    }
}


