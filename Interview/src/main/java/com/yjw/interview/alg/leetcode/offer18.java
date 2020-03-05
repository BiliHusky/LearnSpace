package com.yjw.interview.alg.leetcode;

/**
 * @author David Yang
 * @date 2020-02-22 17:03
 */
public class offer18 {

    public static void main(String[] args) {
//        4519
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        ListNode returnNode = deleteNode(head, 1);
        System.out.println("t");
    }

    public static ListNode deleteNode(ListNode head, int val) {
        ListNode ps = head;
        if (head.val == val) {
            head = ps.next;
            ps = null;
            return head;
        }
        ListNode pre = ps;
        ps = ps.next;
        while (ps != null) {
            if (ps.val == val) {
                pre.next = ps.next;
                return head;
            }
            pre = ps;
            ps = ps.next;
        }
        return head;
    }
}

