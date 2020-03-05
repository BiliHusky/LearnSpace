package com.yjw.interview.alg.leetcode;

/**
 * @author David Yang
 * @date 2020-02-22 13:47
 */
public class offer005 {
    public static String replaceSpace(String s) {
        if (s == null || s.length() == 0 || s.trim().isEmpty())
            return "";
        char[] c = s.toCharArray();
        int blankNum = 0;
        for (char elem : c) {
            if (elem == ' ')
                blankNum++;
        }
        char[] target = new char[c.length + blankNum * 2];

        int tLoc = 0;
        for (char elem : c) {
            if (elem == ' ') {
                target[tLoc++] = '%';
                target[tLoc++] = '2';
                target[tLoc++] = '0';
            } else {
                target[tLoc++] = elem;
            }
        }

        return String.valueOf(target);
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        s = "";
        System.out.println(replaceSpace(s));
    }
}
