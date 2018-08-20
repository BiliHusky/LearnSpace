package archtecture.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by yjw on 18-6-28.
 */
public class LockSupportDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "park");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + " awake");
        });
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(thread);
    }
}
