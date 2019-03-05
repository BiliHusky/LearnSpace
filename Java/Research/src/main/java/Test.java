import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yjw on 18-12-20.
 */
public class Test {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition printchar = lock.newCondition();
    private static Condition printNumber = lock.newCondition();

    public static void main(String[] args) {
        new Thread(new A()).start();
        new Thread(new B()).start();
    }


    static class A implements Runnable {

        @Override
        public void run() {
                for (int i = 1; (i + 1) <= 52; i+=2) {
                    lock.lock();
                    try {
                        System.out.print(i + "" + (i + 1));
                        printNumber.await();
                        printchar.signalAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                }

        }
    }

    static class B implements Runnable {

        @Override
        public void run() {
            char c = 'A';
                for (int i = 0; i < 26; i++) {
                    lock.lock();
                    try {
                        System.out.print((char) (c + i) + " ");
                        printNumber.signalAll();
                        printchar.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                }

        }
    }
}


