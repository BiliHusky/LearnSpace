package com.yjw.interview.alg.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author David Yang
 * @date 2020-02-22 20:52
 */
public class offer32 {
    public static int[] levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        TreeNode lastNodeInLevel = root;
        List<Integer> arr= new LinkedList<>();
        return null;

    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(9);
        head.right = new TreeNode(20);
        head.right.left = new TreeNode(15);
        head.right.right = new TreeNode(7);

        int[] arr = levelOrder(head);
    }
}
