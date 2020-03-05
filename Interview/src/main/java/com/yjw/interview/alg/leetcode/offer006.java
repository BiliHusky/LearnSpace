package com.yjw.interview.alg.leetcode;

import java.util.List;

/**
 * @author David Yang
 * @date 2020-02-22 13:57
 */
public class offer006 {
    public int[] reversePrint(ListNode head) {
        if (head == null)
            return new int[] {};

        if (head.next == null)
            return new int[] {head.val};

        ListNode newHead = reverse(head);
        int len = 0;
        ListNode ps = newHead;
        while (ps != null) {
            len ++;
            ps = ps.next;
        }
        int[] res = new int[len];
        len = 0;
        ps = newHead;
        while (ps != null) {
            res[len++] = ps.val;
            ps = ps.next;
        }

        head = reverse(newHead);
        return res;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;

        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        offer006 o = new offer006();
        int[] res = o.reversePrint(head);
        System.out.println("t");
    }
}

class ListNode {
    int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }