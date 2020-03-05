package com.yjw.interview.thread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author David Yang
 * @date 2020-02-25 10:59
 */
public class ReadWriteLock11 {

    public static void main(String[] args) throws InterruptedException {
        final MyReadWriteLock rwLock = new MyReadWriteLock();
        // 创建读锁 r1 和 r2
        Thread r1 = new Thread(new Runnable() {
            @Override
            public void run() {
                rwLock.read();
            }
        }, "r1");
        Thread r2 = new Thread(new Runnable() {
            @Override
            public void run() {
                rwLock.read();
            }
        }, "r2");
//        r1.start();
//        r2.start();
//        // 等待同时读取线程执行完成
//        r1.join();
//        r2.join();
        r1.start();
        // 开启写锁的操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                rwLock.write();
            }
        }, "w1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                rwLock.write();
            }
        }, "w2").start();
        r2.start();
    }

    static class MyReadWriteLock {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        private String show="......";
        public void read() {
            try {
                lock.readLock().lock();
                System.out.println("读操作，进入 | 线程：" + Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName() + "read show :" + show);
                Thread.sleep(3000);
                System.out.println("读操作，退出 | 线程：" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.readLock().unlock();
            }
        }
        public void write() {
            try {
                lock.writeLock().lock();
                System.out.println("写操作，进入 | 线程：" + Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName() + " write show to -----");
                show = "-----";
                Thread.sleep(3000);
                System.out.println("写操作，退出 | 线程：" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.writeLock().unlock();
            }
        }
    }
}
