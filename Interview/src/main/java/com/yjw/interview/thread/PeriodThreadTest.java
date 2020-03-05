package com.yjw.interview.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author David Yang
 * @date 2020-02-11 20:51
 */
public class PeriodThreadTest {
    public static void main(String[] args) {
        Thread getTocketThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        // 执行业务方法
                        TimeUnit.SECONDS.sleep(5); // 每两小时执行一次
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        if (!getTocketThread.isAlive()) {
            System.out.println("启动线程");
            getTocketThread.start();
        }
    }
}
