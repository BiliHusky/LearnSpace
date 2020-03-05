package com.yjw.interview.thread;

/**
 * @author David Yang
 * @date 2020-02-10 10:03
 */
public class ThreadSafeTest {
    static int number = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> addNumber());
        Thread thread2 = new Thread(() -> addNumber());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("number：" + number);
    }
    public static void addNumber() {
        for (int i = 0; i < 10000; i++) {
            ++number;
        }
    }

}
