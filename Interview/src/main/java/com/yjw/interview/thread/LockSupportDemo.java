package com.yjw.interview.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @author David Yang
 * @date 2020-02-14 19:43
 */
public class LockSupportDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "被唤醒");
        });
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("pre finish");
        LockSupport.unpark(thread);
        System.out.println("finish");
    }
}