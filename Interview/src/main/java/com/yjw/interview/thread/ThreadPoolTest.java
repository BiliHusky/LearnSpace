package com.yjw.interview.thread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author David Yang
 * @date 2020-02-07 17:02
 */
public class ThreadPoolTest {
    public static void test001() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 3; i++) {
            fixedThreadPool.execute(() -> {
                System.out.println("CurrentTime - " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void test002() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            cachedThreadPool.execute(() -> {
                System.out.println("CurrentTime - " +
                        LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void test003() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 3; i++) {
            singleThreadExecutor.execute(() -> {
                System.out.println("CurrentTime - " +
                        LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void test004() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
        scheduledThreadPool.schedule(() -> {
            System.out.println("ThreadPool：" + LocalDateTime.now());
        }, 3L, TimeUnit.SECONDS);
        System.out.println("CurrentTime：" + LocalDateTime.now());
        scheduledThreadPool.schedule(() -> {
            System.out.println("ThreadPool：" + LocalDateTime.now());
        }, 3L, TimeUnit.SECONDS);
        System.out.println("finish");
    }

    public static void test005() {
        ScheduledExecutorService singleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        singleThreadScheduledExecutor.schedule(() -> {
            System.out.println("ThreadPool：" + LocalDateTime.now());
        }, 1L, TimeUnit.SECONDS);
        System.out.println("CurrentTime：" + LocalDateTime.now());
    }

    public static void test006() throws InterruptedException {
        ExecutorService workStealingPool = Executors.newWorkStealingPool();
        for (int i = 0; i < 5; i++) {
            int finalNumber = i;
            workStealingPool.execute(() -> {
                System.out.println("I：" + finalNumber);
            });
        }
        Thread.sleep(5000);
    }

    public static void test007() {
        Object obj1 = new Object();
        Object obj2 = new Object();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                synchronized (obj1) {
                    try {
                        Thread.sleep(1000);
                        synchronized (obj2) {
                            System.out.println("block~~~");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                synchronized (obj2) {
                    try {
                        Thread.sleep(1000);
                        synchronized (obj1) {
                            System.out.println("block)))");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread1.start();
        thread2.start();
        System.out.println("omg");
    }

    public static void main(String[] args) throws InterruptedException {
//        /*fixthreadpool线程池测试*/test001();
//        /*cachethreadpool*/test002();
//        /*singlethreadexecutor*/test003();
//        /*scheduledthreadpool*/test004();
//        /*scheduledexecutorservice*/test005();
//        /*workstealingpool*/test006();
        /*block test*/test007();
    }
}
