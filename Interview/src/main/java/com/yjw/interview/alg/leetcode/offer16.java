package com.yjw.interview.alg.leetcode;

/**
 * @author David Yang
 * @date 2020-02-22 16:51
 */
public class offer16 {
    public static double myPow(double x, int n) {
        boolean negative = false;
        int absN = 0;
        double res = 1;
        if (n < 0) {
            negative = true;
            absN = -n;
        } else {
            absN = n;
        }

        while (absN > 0) {
            if ((absN & 1 )> 0) {
                res = res * x;
            }

            x = x * x;
            absN = absN >>> 1;
        }

        return negative ? 1/res : res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 4));
        System.out.println(myPow(2, -2));
    }
}
