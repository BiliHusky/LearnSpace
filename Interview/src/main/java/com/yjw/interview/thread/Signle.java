package com.yjw.interview.thread;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author David Yang
 * @date 2020-02-27 10:10
 */
public class Signle {
    private ReentrantLock lock = new ReentrantLock();
    private Condition first = lock.newCondition();
    private Condition second = lock.newCondition();
    private Condition third = lock.newCondition();

    public void rrr() {
        CountDownLatch barrier = new CountDownLatch(3);
        Thread thread1 = new Thread(new PrintA(first, second, third, lock,barrier));
        Thread thread2 = new Thread(new PrintB(first, second, third, lock, barrier));
        Thread thread3 = new Thread(new PrintC(first, second, third, lock, barrier));
        ExecutorService service = Executors.newFixedThreadPool(3);

        thread1.start();
        barrier.countDown();
        thread2.start();
        barrier.countDown();
        thread3.start();
        barrier.countDown();
    }

    public static void main(String[] args ) {
        Signle s = new Signle();
        s.rrr();
    }
}

class PrintA implements Runnable {
    private Condition first;
    private Condition second;
    private Condition third;
    private ReentrantLock lock;
    private CountDownLatch barrier;

    public PrintA(Condition first, Condition second, Condition third, ReentrantLock lock, CountDownLatch barrier) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.lock = lock;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            barrier.await();
            lock.lock();
            System.out.println("t1");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            first.signalAll();
            lock.unlock();
        }

    }
}

class PrintB implements Runnable {
    private Condition first;
    private Condition second;
    private Condition third;
    private ReentrantLock lock;
    private CountDownLatch barrier;

    public PrintB(Condition first, Condition second, Condition third, ReentrantLock lock, CountDownLatch barrier) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.lock = lock;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            barrier.await();
            lock.lock();
            first.await();
            System.out.println("t2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }  finally {
            second.signalAll();
            lock.unlock();
        }
    }
}

class PrintC implements Runnable {
    private Condition first;
    private Condition second;
    private Condition third;
    private ReentrantLock lock;
    private CountDownLatch barrier;

    public PrintC(Condition first, Condition second, Condition third, ReentrantLock lock, CountDownLatch barrier) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.lock = lock;
        this.barrier = barrier;
    }
    @Override
    public void run() {
        try {
            barrier.await();
            lock.lock();
            first.await();
            second.await();
            System.out.println("t3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            first.signalAll();
            second.signalAll();
            lock.unlock();
        }
    }
}