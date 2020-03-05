package com.yjw.interview.alg.leetcode;

/**
 * @author David Yang
 * @date 2020-02-22 18:00
 */
public class offer22 {
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode first = head;
        ListNode second = head;
        while (k-- > 0) {
            second = second.next;
        }

        while (second != null) {
            first = first.next;
            second = second.next;
        }
        return first;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
        ListNode node = getKthFromEnd(head, 2);
        System.out.println("t");
    }
}
