package com.yjw.interview.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author David Yang
 * @date 2020-02-15 18:05
 */
public class PCdemo {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        ExecutorService service = Executors.newFixedThreadPool(15);
        for (int i = 0; i < 5; i++) {
            service.submit(new Producer(linkedList, 8));
        }

        for (int i = 0; i < 10; i++) {
            service.submit(new Consumer(linkedList));
        }
    }
}

class Producer implements Runnable{

    private List<Integer> list;
    private int maxLength;
    private static String str;

    public Producer(List<Integer> list, int maxLength) {
        this.list = list;
        this.maxLength = maxLength;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                try {
                    while (list.size() == maxLength) {
                        System.out.println("生产者" + Thread.currentThread().getName()+"达到最大值");
                        list.wait();
                        System.out.println("生产者" + Thread.currentThread().getName()+ "继续使用");
                    }

                    Random  random = new Random();
                    int i = random.nextInt();
                    System.out.println("生产者" + Thread.currentThread().getName() + " 生产数据：" + i);
                    list.add(i);
                    list.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Consumer implements Runnable {

    private List<Integer> list;

    public Consumer(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (list) {
                try{
                    while (list.isEmpty()) {
                        System.out.println("消费者" + Thread.currentThread().getName()+"队列为空waiting");
                        list.wait();
                        System.out.println("消费者" + Thread.currentThread().getName()+"退出");
                    }

                    Integer i = list.remove(0);
                    System.out.println("消费者" + Thread.currentThread().getName() + " 消费数据：" + i);
                    list.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}