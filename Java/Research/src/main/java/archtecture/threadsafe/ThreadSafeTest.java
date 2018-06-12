package archtecture.threadsafe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by yjw on 18-6-8.
 */
public class ThreadSafeTest {
    public static void test() {
        List<Object> list = new ArrayList<>();

        int threadCount = 1000;

        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i=0; i<threadCount; i++) {
            Thread thread = new Thread(new MyThread(list, countDownLatch));
            thread.start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }

    public static void main(String[] args) {
        test();
    }
}

class MyThread implements Runnable {
    private List<Object> list;
    private CountDownLatch countDownLatch;

    public MyThread(List<Object> list, CountDownLatch countDownLatch) {
        this.list = list;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i=0; i<100;i++) {
            list.add(new Object());
        }
        countDownLatch.countDown();
    }
}
