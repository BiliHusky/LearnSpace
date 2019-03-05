/**
 * Created by yjw on 19-1-11.
 */
public class Test {
    public void doTest(int loop) {
        double l;
        long then = System.currentTimeMillis();
        for (int i=0; i < loop ; i++) {
            l = fibImpl(30);
        }
        long now = System.currentTimeMillis();
        System.out.println("Elapsed time :" + (now - then));
    }

    public double fibImpl(int n) {
        if (n < 0)
            throw new IllegalArgumentException("not support value < 0");
        if (n == 0)
            return 0d;
        if (n == 1)
            return 1d;
        double d = fibImpl(n - 2) + fibImpl(n - 1);
        if (Double.isInfinite(d))
            throw new ArithmeticException("Overflow");
        return d;
    }


    public static void main(String[] args) {
        Test t = new Test();
        t.doTest(1);
        t.doTest(10);
        System.out.println("h");
    }
}
