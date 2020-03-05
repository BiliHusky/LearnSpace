package com.yjw.interview.alg.sort;

import java.util.Stack;

/**
 * @author David Yang
 * @date 2020-02-27 16:07
 */
public class TreeCollections {

    public static void pre(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        pre(root.left);
        pre(root.right);
    }

    public static void pre1(TreeNode root) {
       Stack<TreeNode> stack = new Stack<>();
       TreeNode ps = root;
       stack.push(ps);
        while (!stack.isEmpty()) {
            ps = stack.pop();
            System.out.print(ps.val + " ");
            if (ps.right != null) {
                stack.push(ps.right);
            }
            if (ps.left != null) {
                stack.push(ps.left);
            }
        }
    }

    public static void in(TreeNode root) {
        if (root == null)
            return;

        in(root.left);
        System.out.print(root.val + " ");
        in(root.right);
    }

    public static void in1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode ps = root;
        while (!stack.isEmpty() || ps != null) {
            if (ps != null) {
                stack.push(ps);
                ps = ps.left;
            } {
                ps = stack.pop();
                System.out.print(ps.val + " ");
                ps = ps.right;
            }
        }
    }

    public static void post(TreeNode root) {
        if (root == null)
            return;

        post(root.left);
        post(root.right);
        System.out.print(root.val + " ");
    }

    public static void post1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode ps = root;
        TreeNode c = null;
        stack.push(ps);
        while (!stack.isEmpty()) {
            c = stack.peek();
            if (c.left != null && ps != c.left && ps != c.right) {
                stack.push(c.left);
            } else if (c.right != null && ps != c.right) {
                stack.push(c.right);
            } else {
                System.out.print(stack.pop().val + " ");
                ps = c;

            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println("pre");
        pre(root);
        System.out.println();
        pre1(root);
        System.out.println();
        System.out.println("in");
        in(root);
        System.out.println();
        in1(root);
        System.out.println();
        System.out.println("post");
        post(root);
        System.out.println();
        post1(root);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
