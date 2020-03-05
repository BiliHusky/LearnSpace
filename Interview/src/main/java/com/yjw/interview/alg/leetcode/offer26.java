package com.yjw.interview.alg.leetcode;

/**
 * @author David Yang
 * @date 2020-02-22 19:13
 */
public class offer26 {

    public int[] getnext(char[] ms) {
        if (ms.length == 1)
            return new int[] {-1};

        int cn = 0;
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;

        while (pos < next.length) {
            if (ms[pos-1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }

    public int getIndex(String str, String message) {
        if (str == null || message == null || message.length() < 1 || str.length() < message.length())
            return -1;

        char ss[] = str.toCharArray();
        char ms[] = message.toCharArray();

        int si = 0;
        int mi = 0;

        int[] next= getnext(ms);
        while (si < ss.length && mi < ms.length) {
            if (ss[si] == ms[mi]) {
                si++;
                mi++;
            } else if (next[mi] == -1) {
                si++;
            } else {
                mi = next[mi];
            }
        }

        return mi == ms.length ? si-mi : -1;

    }



    public String serialTree(TreeNode A) {

        if (A == null)
            return "#!";

        String res = A.val + "!";
        res += serialTree(A.left);
        res += serialTree(A.right);
        return res;
    }
    public boolean check(TreeNode head, TreeNode t) {
        if (t == null)
            return true;

        if (head == null || head.val != t.val)
            return false;

        return check(head.left, t.left) && check(head.right, t.right);
    }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null)
            return false;
        return check(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public static void main(String[] args) {
        offer26 oo = new offer26();
        String str = "abceabc abcdeab";
        String message = "abcdf";
        System.out.println(oo.getIndex(str, message));
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(4);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(2);
        head.right = new TreeNode(5);
        TreeNode head2 = new TreeNode(4);
        head2.left = new TreeNode(1);
//        System.out.println(oo.isSubStructure(head, head2));

        TreeNode node1 = new TreeNode(4);
        node1.left = new TreeNode(1);
//        node1.left = new TreeNode(3);
//        node1.left.left = new TreeNode(2);
//        node1.left.left.left = new TreeNode(1);

        TreeNode node2 = new TreeNode(3);
        System.out.println(oo.isSubStructure(node1, node2));

    }
}
