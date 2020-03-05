package com.yjw.interview.alg.leetcode;

/**
 * @author David Yang
 * @date 2020-02-22 21:34
 */
public class offer36 {

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right = new Node(5);

//        Node pp = treeToDoublyList(head);
        Node pp = te(head);
        System.out.println(pp);
    }

    public static Node treeToDoublyList(Node root) {

        return null;

    }

    public static Node helper(Node root){
        if(root == null) return null;
        if(root.left != null){
            //找到最小的值
            Node left = helper(root.left);
            while(left.right != null) left = left.right;
            //进行小值双向赋值
            root.left = left;
            left.right = root;
        }
        if(root.right != null){
            Node right = helper(root.right);
            //进行大值双向赋值
            root.right = right;
            right.left = root;
        }
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static Node te(Node root) {
        if (root == null)
            return null;

        if (root.left != null) {
            Node left = te(root.left);
            while (left.right != null)
                left = left.right;
            root.left = left;
            left.right = root;
        }

        if (root.right != null) {
            Node right = te(root.right);

            root.right = right;
            right.left = root;
        }

        while (root.left != null)
            root = root.left;

        return root;
    }

}
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};