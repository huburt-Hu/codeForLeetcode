package main.com.huburt.list;

public class ClassicQuestion {

    /**
     * 反转一个单链表。
     * <p>
     * 示例:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        while (head.next != null) {
            ListNode move = head.next;
            head.next = move.next;
            move.next = first;
            first = move;
        }
        return first;
    }

    /**
     * 删除链表中等于给定值 val 的所有节点。
     * <p>
     * 示例:
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = null;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val == val) {
                if (pre == null) {
                    head = head.next;
                } else {
                    pre.next = temp.next;
                }
                temp = temp.next;
            } else {
                pre = temp;
                temp = temp.next;
            }
        }
        return head;
    }

    /**
     * 奇偶链表
     * <p>
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
     * <p>
     * 示例 1:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 1->3->5->2->4->NULL
     * 示例 2:
     * 输入: 2->1->3->5->6->4->7->NULL
     * 输出: 2->3->6->7->1->5->4->NULL
     * <p>
     * 说明:
     * 应当保持奇数节点和偶数节点的相对顺序。
     * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
//        ListNode oddTail = head,
//                evenHead = head.next,
//                evenTail = evenHead,
//                temp = head.next.next;
//        int index = 3;
//        while (temp != null) {
//            if (index % 2 == 1) {
//                oddTail.next = temp;
//                oddTail = temp;
//            } else {
//                evenTail.next = temp;
//                evenTail = temp;
//            }
//            temp = temp.next;
//            index++;
//        }
//        evenTail.next = null;
//        oddTail.next = evenHead;
//        return head;

        //优秀范本
        ListNode evenRet = head.next, odd = head, even = evenRet;
        for (; even != null && even.next != null; odd = odd.next, even = even.next) {
            odd.next = even.next;
            even.next = even.next.next;
        }
        odd.next = evenRet;
        return head;
    }


    /**
     * 请判断一个链表是否为回文链表。
     * <p>
     * 示例 1:
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     * 输入: 1->2->2->1
     * 输出: true
     * <p>
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     */
    public boolean isPalindrome(ListNode head) {
        //找到中间node
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //反转后半段
        ListNode reversed = reverseList(slow);
        while (head != null && reversed != null) {
            if (head.val != reversed.val) {
                return false;
            }
            head = head.next;
            reversed = reversed.next;
        }
        return true;
    }

    /**
     * 合并两个有序链表
     * <p>
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * <p>
     * 示例：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null;
        if (l1.val <= l2.val){
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        head.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(2);
        n3.next = n4;
        n4.next = new ListNode(1);
        System.out.println(head.getList());

        ClassicQuestion classicQuestion = new ClassicQuestion();
//        ListNode node = classicQuestion.oddEvenList(head);
//        System.out.println(node.getList());

        boolean palindrome = classicQuestion.isPalindrome(head);
        System.out.println(palindrome);

    }
}
