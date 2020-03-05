package com.yjw.interview.thread.interrupt;

/**
 * @author David Yang
 * @date 2020-02-13 10:36
 */
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        //sleepThread睡眠1000ms
        final Thread sleepThread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };
        //busyThread一直执行死循环
        Thread busyThread = new Thread() {
            @Override
            public void run() {
//                while (true) ;
                System.out.println("interrupt :" + isInterrupted());
                while(!isInterrupted()) {
                    System.out.println("interrupt");
                }
            }
        };
        sleepThread.start();
        busyThread.start();
        Thread.sleep(2000);
        sleepThread.interrupt();
        busyThread.interrupt();
        //while (sleepThread.isInterrupted()) ;
        System.out.println("sleepThread isInterrupted: " + sleepThread.isInterrupted());
        System.out.println("busyThread isInterrupted: " + busyThread.isInterrupted());
    }
}
