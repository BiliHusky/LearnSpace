package com.yjw.interview.alg.leetcode;

/**
 * @author David Yang
 * @date 2020-02-22 20:23
 */
public class offer27 {



    public static TreeNode mirrorTree(TreeNode root) {

        if (root == null)
            return null;

        TreeNode head = root;
        TreeNode tmp = null;
        head.left = mirrorTree(head.left);
        head.right = mirrorTree(head.right);
        tmp = head.left;
        head.left = head.right;
        head.right = tmp;
        return head;

    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(2);
        head.right = new TreeNode(7);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(3);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(9);

        TreeNode head1 = mirrorTree(head);

        System.out.println("t");
    }
}
