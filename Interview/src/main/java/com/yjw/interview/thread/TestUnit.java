package com.yjw.interview.thread;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author David Yang
 * @date 2020-02-04 11:29
 */
public class TestUnit {

    @Test
    public void testStringIntern() {
        int maxSize = 1000000;
        String a = "abc";
        long startTimeA = System.currentTimeMillis();String tt = "";
        for (int i=0; i<maxSize; i++) {
            String tmp = a.intern();
            tt = tmp;
        }
        long endTimeA = System.currentTimeMillis();


        for (int i=0; i<maxSize; i++) {
            String tmp = "abc";
            tt = tmp;
        }
        tt = tt + "1";
        long endTimeB = System.currentTimeMillis();

        System.out.println("intern time : " + (endTimeA - startTimeA));
        System.out.println("equal time : " + (endTimeB - endTimeA));

    }

    @Test
    int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        // 将数组都初始化为 true
        Arrays.fill(isPrim, true);

        for (int i = 2; i < n; i++)
            if (isPrim[i])
                // i 的倍数不可能是素数了
                for (int j = 2 * i; j < n; j += i)
                    isPrim[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrim[i]) count++;

            return count;
    }
}
