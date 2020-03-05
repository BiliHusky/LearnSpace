package com.yjw.interview.basic;


import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

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

    @Test
    public void test1111() {
        int a = 10>>1;//01010 > 101 = 5
        int b = a++; // b=5 a=6;
        int c = ++a; // c=7 a=7;
        int d = b*a++; // d=35 a=8
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

    @Test
    public void test2222() {
        int MAXIMUM_CAPACITY = 1 << 30;
        System.out.println(MAXIMUM_CAPACITY);
        System.out.println(MAXIMUM_CAPACITY>>>1);
    }

    @Test
    public void testMap() {
        Map<TestMap, Boolean> map = new HashMap<>();
        TestMap t1 = new TestMap("1", "1");
        TestMap t2 = new TestMap("2", "2");
        map.put(t1, true);
        map.put(t2, true);

        System.out.println(map.get(new TestMap("1", "1")));
        System.out.println(map.get(t1));
        final TestMap t = new TestMap("1", "2");
    }

    @Test
    public void testTry() {
        String tmp =  "1";
        System.out.println(a());
        b(tmp);
        System.out.println(tmp);
    }

    public void b(String a) {
        a="cc";
    }

    private String a() {
        try {
            if (false) {
                throw new IOException("omg");
            }
            return "2";
        } catch (IOException e) {

        } finally {
            return "1";
        }
    }
}

abstract class T {
    abstract void test1();
}



class TestMap {
    private String a;
    private String b;
    public static Test test;



    public TestMap(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public int hashCode() {
//        return super.hashCode();
        return a.hashCode() + b.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        TestMap map = (TestMap) obj;
        return map.getA().equals(a) && map.getB().equals(b);
    }
}