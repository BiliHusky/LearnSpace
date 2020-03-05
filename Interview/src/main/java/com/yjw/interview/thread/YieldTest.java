package com.yjw.interview.thread;

/**
 * @author David Yang
 * @date 2020-02-13 11:05
 */
public class YieldTest {
    public static String o="std";

    public static void main(String[] args) {
        TmpThread tmpThread1 = new TmpThread("thread1");
        TmpThread tmpThread2 = new TmpThread("thread2");
        TmpThread tmpThread3 = new TmpThread("thread3");

        tmpThread1.setPriority(3);
        tmpThread2.setPriority(2);
        tmpThread3.setPriority(1);

        tmpThread1.start();
        tmpThread2.start();
        tmpThread3.start();

    }
}

class TmpThread extends Thread {
    private String name;
    public TmpThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        yield();
        synchronized (TmpThread.class) {
            System.out.println("currentThread :" + name);
        }
    }
}
