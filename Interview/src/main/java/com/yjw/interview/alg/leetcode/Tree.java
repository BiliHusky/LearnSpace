package com.yjw.interview.alg.leetcode;

import java.util.Stack;

/**
 * @author David Yang
 * @date 2020-02-22 18:35
 */
public class Tree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void prePrint(Node node) {
        if (node == null)
            return;

        System.out.print(node.value + " ");
        prePrint(node.left);
        prePrint(node.right);
    }

    public static void inPrint(Node node) {
        if (node == null)
            return;
        inPrint(node.left);
        System.out.print(node.value + " ");
        inPrint(node.right);
    }

    public static void postPrint(Node node) {
        if (node == null)
            return ;

        postPrint(node.left);
        postPrint(node.right);
        System.out.print(node.value + " ");
    }

    public static void prePrint1(Node head) {
        Node ps = head;
        Stack<Node> stack = new Stack<>();

        stack.add(head);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.value + " ");

            if (node.right != null)
                stack.add(node.right);

            if (node.left != null)
                stack.add(node.left);


        }
    }

    public static void inPrint2(Node head) {
        Stack<Node> stack = new Stack<>();

        while (!stack.isEmpty() || head != null) {

            if (head != null) {
                stack.add(head);
                head = head.left;
            } else {
                System.out.print(stack.peek().value + " ");
                head = stack.pop();
                head = head.right;
            }
        }
    }

    public static void postPrint2(Node head) {
        Stack<Node> stack = new Stack<>();
        Node c = null;
        stack.add(head);

        while (!stack.isEmpty()) {
            c = stack.peek();
            if (c.left != null && head != c.left && head != c.right) {
                stack.push(c.left);
            } else if (c.right != null && head != c.right) {
                stack.push(c.right);
            } else {
                System.out.print(stack.pop().value + " ");
                head = c;
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        prePrint(head);
        System.out.println();
        inPrint(head);
        System.out.println();
        postPrint(head);

        System.out.println();
        System.out.println("==================");
        prePrint1(head);
        System.out.println();
        inPrint2(head);
        System.out.println();
        postPrint2(head);
    }
}


