package com.yjw.interview.alg.leetcode;

/**
 * @author David Yang
 * @date 2020-02-22 18:12
 */
public class offer25 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;

        ListNode big = l1.val > l2.val ? l1 : l2;
        ListNode small = l1.val > l2.val ? l2 : l1;

        ListNode res = small;

        ListNode pre = small;
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(5);
        ListNode head2 = new ListNode(3);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);

        ListNode node = mergeTwoLists(head, head2);
        System.out.println("t");
    }
}
