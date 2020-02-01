package com.yjw.interview.basic;


import org.junit.Test;

public class ForTest {
    @Test
    public void testString() {
        String str = "a";
        String strcp = str;
        System.out.println(strcp == str);
        str = str + "a";
        System.out.println(strcp == str);
        System.out.println(strcp);
        System.out.println(str);

    }
}
