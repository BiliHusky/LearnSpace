package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yjw on 18-10-25.
 */
public class ConditionTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadDomain td = new ThreadDomain();
        ThreadT mt = new ThreadT(td);
        mt.start();
        Thread.sleep(3000);
        td.signal();
    }
}

class ThreadDomain {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void await() {
        try {
            lock.lock();
            System.out.println("await :" + System.currentTimeMillis());
            condition.await();
            System.out.println("await finish");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signal() {
        try {
            lock.lock();
            System.out.println("signal :" + System.currentTimeMillis());
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}

class ThreadT extends Thread {
    private ThreadDomain td;
    public ThreadT(ThreadDomain td) {
        this.td = td;
    }

    public void run() {
        td.await();
    }
}