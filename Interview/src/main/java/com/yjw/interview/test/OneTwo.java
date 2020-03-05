package com.yjw.interview.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author David Yang
 * @date 2020-02-25 21:07
 */
public class OneTwo {

    private int flag = 1;
    private ReentrantLock lock = new ReentrantLock();
    private Condition one = lock.newCondition();
    private Condition two = lock.newCondition();
    private ThreadLocal<String> local = new ThreadLocal<>();
    public void test() throws InterruptedException {

//        int flag = 1;
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    local.set("String");
                    //local= null;
                    lock.lock();
                    try {
                        while (flag != 1)
                            one.await();
                        System.out.println("1");
                        Thread.sleep(1000);
                        flag = 2;
                        two.signal();
                    } catch (InterruptedException e) {

                    }  finally {
                        lock.unlock();
                    }
                }
            }

        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    local.set("String");
                    lock.lock();
                    try {
                        while (flag != 2)
                            two.await();
                        System.out.println("2");
                        Thread.sleep(2000);
                        flag = 1;
                        one.signal();
                    } catch (InterruptedException e) {

                    } finally {
                        lock.unlock();
                    }
                }
            }
        });

        t2.start();Thread.sleep(1000);t1.start();
    }


    public static void main(String[] args) throws InterruptedException {
//        ThreadLocal<String> local = new ThreadLocal<>();
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    local.set("String");
//                    while (true) {
//                        Thread.sleep(1000);
//                        System.out.println("running");
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread1.start();
//        //thread1.join();
//        Thread.sleep(3000);
//        //thread1.interrupt();
//        System.out.println("finish");
        OneTwo t = new OneTwo();
        t.test();
    }
}
