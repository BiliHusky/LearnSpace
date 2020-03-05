package com.yjw.interview.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author David Yang
 * @date 2020-02-27 08:01
 */
public class PCdemo2 {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition fullCondition = lock.newCondition();
        Condition emptyCondition = lock.newCondition();
        List<Integer> list = new LinkedList<>();
//        Thread producer = new Thread(new Producer2(list, lock, emptyCondition, fullCondition), "producer");
//        Thread consumer = new Thread(new Consumer2(lock, emptyCondition, fullCondition, list), "consumer");
//        producer.start();
//        consumer.start();

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(new Producer2(list, lock, emptyCondition, fullCondition));
        executor.submit(new Consumer2(lock, emptyCondition, fullCondition, list));


    }
}

class Producer2 implements Runnable{
    private List<Integer> list;
    private ReentrantLock lock;
    private Condition emptCondition;
    private Condition fullCondition;

    public Producer2(List<Integer> list, ReentrantLock lock, Condition emptCondition, Condition fullCondition) {
        this.list = list;
        this.lock = lock;
        this.emptCondition = emptCondition;
        this.fullCondition = fullCondition;
    }

    @Override
    public void run() {

        while (true) {
            try {
                lock.lock();
                while (list.size() == 8) {
                    System.out.println(Thread.currentThread().getName() + " 进入等待");
                    fullCondition.await();
                    System.out.println(Thread.currentThread().getName() + " 退出等待");
                }
                Random random = new Random();
                int num = random.nextInt();
                System.out.println(Thread.currentThread().getName() + " 生成数据:" + num);
                list.add(num);
                emptCondition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

class Consumer2 implements Runnable {
    private ReentrantLock lock;
    private Condition emptyCondition;
    private Condition fullCondition;
    private List<Integer> list;

    public Consumer2(ReentrantLock lock, Condition emptyCondition, Condition fullCondition, List<Integer> list) {
        this.lock = lock;
        this.emptyCondition = emptyCondition;
        this.fullCondition = fullCondition;
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                while (list.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + " 进入等待");
                    emptyCondition.await();
                    System.out.println(Thread.currentThread().getName() + " 退出等待");
                }
                Integer num = list.remove(0);
                System.out.println(Thread.currentThread().getName() + " 消费 num:" + num);
                fullCondition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}