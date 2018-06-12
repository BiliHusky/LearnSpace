package archtecture;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yjw on 18-6-7.
 */
public class BlockingQueueTest {
public static class Basket {
    BlockingQueue<String> basket = new ArrayBlockingQueue<String>(3);

    public void produce() throws InterruptedException {
        basket.put("An apple");
    }

    public String consume() throws InterruptedException {
        String apple = basket.take();
        return apple;
    }

    public int getAppleNumber() {
        return basket.size();
    }

}
    public static void testBasket() {
        final Basket basket = new Basket();
        class Producer implements Runnable {

            public void run() {
                try {
                while (true) {
                    System.out.println("prepare produce apple :" + System.currentTimeMillis());
                    basket.produce();
                    System.out.println("finish produce apple :" + System.currentTimeMillis());
                    System.out.println("there are " + basket.getAppleNumber() + " apples");
                    Thread.sleep(300);
                }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        class Consumer implements Runnable {

            public void run() {
                try {
                    while (true) {
                        System.out.println("consumer prepare consume apple :" + System.currentTimeMillis());
                        basket.consume();
                        basket.consume();
                        System.out.println("finish consume apple :" + System.currentTimeMillis());
                        System.out.println("there are " + basket.getAppleNumber() + " after consume apple");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        ExecutorService service = Executors.newCachedThreadPool();
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        service.submit(producer);
        service.submit(consumer);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }

    public static void main(String[] args) {
    }
}
