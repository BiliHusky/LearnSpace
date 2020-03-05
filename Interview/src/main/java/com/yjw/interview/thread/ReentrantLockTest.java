package com.yjw.interview.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author David Yang
 * @date 2020-02-10 10:29
 */
public class ReentrantLockTest {
    public static void test001() throws InterruptedException {
        Lock interruptLock = new ReentrantLock();
        interruptLock.lock();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    interruptLock.lock();
                    interruptLock.lockInterruptibly();  // java.lang.InterruptedException
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Over");
        System.exit(0);
    }

    public static void main(String[] args) throws InterruptedException {
        test001();
    }
}
