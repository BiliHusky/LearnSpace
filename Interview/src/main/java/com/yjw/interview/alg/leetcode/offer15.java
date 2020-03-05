package com.yjw.interview.alg.leetcode;

/**
 * @author David Yang
 * @date 2020-02-22 16:29
 */
public class offer15 {
    public static int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(7));
    }
}
