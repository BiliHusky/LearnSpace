package com.yjw.interview.thread;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author David Yang
 * @date 2020-02-10 10:43
 */
public class ThreadUtilTest {
    // CountDownLatch测试
    public static void test001() throws InterruptedException {
        CountDownLatch doctor = new CountDownLatch(1);
        CountDownLatch patient = new CountDownLatch(5);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i=0; i<5; i++) {
            final int j = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        doctor.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("patient " + j);
                    patient.countDown();

                }
            });
        }

        System.out.println("doctor come");
        doctor.countDown();
        patient.await();
        System.out.println("doctor back");
        executorService.shutdown();
    }

    // CyclicBarrier测试
    public static void test002() throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("发车了");
            }
        });
        for (int i = 0; i < 4; i++) {
            new Thread(new CyclicWorker(cyclicBarrier)).start();
        }
    }
    static class CyclicWorker implements Runnable {
        private CyclicBarrier cyclicBarrier;
        CyclicWorker(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }
        @Override
        public void run() {
            for (int i = 0; i < 2; i++) {
                System.out.println("乘客：" + i);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //Semaphore 测试
    public static void test003() {
        Semaphore semaphore = new Semaphore(2);
        ThreadPoolExecutor semaphoreThread = new ThreadPoolExecutor(10, 50, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        for (int i = 0; i < 5; i++) {
            semaphoreThread.execute(() -> {
                try {
                    // 堵塞获取许可
                    semaphore.acquire();
                    System.out.println("Thread：" + Thread.currentThread().getName() + " 时间：" + LocalDateTime.now());
                    TimeUnit.SECONDS.sleep(2);
                    // 释放许可
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        semaphoreThread.shutdown();
    }

    //Phaser测试
    public static void test004() throws InterruptedException {
        Phaser phaser = new MyPhaser();
        PhaserWorker[] phaserWorkers = new PhaserWorker[5];
        for (int i = 0; i < phaserWorkers.length; i++) {
            phaserWorkers[i] = new PhaserWorker(phaser);
            // 注册 Phaser 等待的线程数，执行一次等待线程数 +1
            phaser.register();
        }
        for (int i = 0; i < phaserWorkers.length; i++) {
            // 执行任务
            new Thread(new PhaserWorker(phaser)).start();
        }
    }
    static class PhaserWorker implements Runnable {
        private final Phaser phaser;
        public PhaserWorker(Phaser phaser) {
            this.phaser = phaser;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " | 到达" );
            phaser.arriveAndAwaitAdvance(); // 集合完毕发车
            try {
                Thread.sleep(new Random().nextInt(5) * 1000);
                System.out.println(Thread.currentThread().getName() + " | 到达" );
                phaser.arriveAndAwaitAdvance(); // 景点 1 集合完毕发车
                Thread.sleep(new Random().nextInt(5) * 1000);
                System.out.println(Thread.currentThread().getName() + " | 到达" );
                phaser.arriveAndAwaitAdvance(); // 景点 2 集合完毕发车
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Phaser 每个阶段完成之后的事件通知
    static class MyPhaser extends  Phaser{
        @Override
        protected boolean onAdvance(int phase, int registeredParties) { // 每个阶段执行完之后的回调
            switch (phase) {
                case 0:
                    System.out.println("==== 集合完毕发车 ====");
                    return false;
                case 1:
                    System.out.println("==== 景点1集合完毕，发车去下一个景点 ====");
                    return false;
                case 2:
                    System.out.println("==== 景点2集合完毕，发车回家 ====");
                    return false;
                default:
                    return true;
            }
        }
    }

    //测试
    public static void test005() {
        Semaphore semaphore = new Semaphore(2);
        ThreadPoolExecutor semaphoreThread = new ThreadPoolExecutor(10, 50, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        long start = System.currentTimeMillis();
        for (int i = 0; i < 3; i++) {
            semaphoreThread.execute(() -> {
                try {
                    //semaphore.release();
                    semaphore.acquire();
                    System.out.println("Hello");
                    TimeUnit.SECONDS.sleep(2);
//                    semaphore.acquire();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        semaphoreThread.shutdown();System.out.println("total:" + (System.currentTimeMillis()-start));
    }


    public static void main(String[] args) throws InterruptedException {
//        test001();
//        test002();
//        test003();
//        test004();
        test005();
    }
}
