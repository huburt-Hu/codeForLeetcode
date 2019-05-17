package main.com.huburt.list;

import java.util.HashSet;

public class IntersectionNode {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        //时间复杂度O(n2)，空间复杂度O(n)
        HashSet<ListNode> set = new HashSet<>();
        ListNode tempA = headA;
        while (tempA != null) {
            set.add(tempA);
            tempA = tempA.next;
        }
        ListNode tempB = headB;
        while (tempB != null) {
            boolean add = set.add(tempB);
            if (!add) {
                return tempB;
            }
            tempB = tempB.next;
        }
        return null;

        //时间复杂度O(n2)，空间复杂度O(1)
//        ListNode a = headA;
//        ListNode b = headB;
//
//        while(a != b){
//            a = (a != null) ? a.next : headB;
//            b = (b != null) ? b.next : headA;
//        }
//        return a;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2, a);
        ListNode c = new ListNode(3, b);
        ListNode d = new ListNode(4, a);
        ListNode node = getIntersectionNode(c, d);
        System.out.println(node);
    }
}
