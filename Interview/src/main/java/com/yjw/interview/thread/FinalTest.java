package com.yjw.interview.thread;

/**
 * @author David Yang
 * @date 2020-02-13 21:08
 */
public class FinalTest {
    private final String a;
    private final static String b;

    static {
        b = "e";
    }

    public FinalTest() {
        a="d";
    }

    public void test(final int a) {
        final int c;
        c=1;

    }
}
