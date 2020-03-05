package com.yjw.interview.alg.leetcode;

import java.util.HashMap;

/**
 * @author David Yang
 * @date 2020-02-22 14:14
 */
public class offer007 {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode head = buildTree(preorder, inorder);
        System.out.println("t");
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1, map );
    }

    public static TreeNode build(int[] preorder, int[] inorder, int prei, int prej, int ini, int inj, HashMap<Integer, Integer> map) {
        if (prei > prej)
            return null;

        TreeNode node = new TreeNode(preorder[prei]);
        int index = map.get(preorder[prei]);

        node.left = build(preorder, inorder, prei + 1, prei + index - ini, ini, index -1, map);
        node.right = build(preorder, inorder, prei + index - ini + 1, prej, index + 1, inj, map);
        return node;
    }
}

class TreeNode {int val;
 TreeNode left;
TreeNode right;
 TreeNode(int x) { val = x; }
}
