package thread;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by yjw on 18-12-11.
 */
public class LockSupportTest {
    public static void main(String[] args ){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " fall a sleep");
                LockSupport.park();
                System.out.println(Thread.currentThread().getName() + " wake up");
            }
        });
        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(t);
    }
}
