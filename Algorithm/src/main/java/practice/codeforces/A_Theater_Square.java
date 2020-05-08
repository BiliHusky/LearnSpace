package practice.codeforces;

import java.util.Scanner;

/**
 * @link https://codeforces.com/problemset/problem/1/A
 * status ac
 * 需要注意：n,m,a <= 10^9 , 相乘会超int
 *
 */
public class A_Theater_Square {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        System.out.println((long)((m/a) + (m%a==0 ? 0:1))*(long)((n/a) + (n%a==0 ? 0:1)));
    }
}
