package com.yjw.interview.thread;

/**
 * @author David Yang
 * @date 2020-02-13 20:38
 */
public class VolatileTest {
    private static int a = 0;
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag = true;
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!flag) {
                    System.out.println("thread b running");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
