package math;

/**
 * Created by yjw on 18-9-27.
 */

/**
 * gcd(n, m) = gcd(m, n%m)
 */
public class Gcd {
    public static void main(String[] args) {
        System.out.println(gcd(9, 24));
    }

    public static int gcd(int n, int m) {
        if (m == 0) {
            return n;
        } else {
            return gcd(m, n % m);
        }
    }
}
