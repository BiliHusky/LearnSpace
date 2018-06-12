/**
 * Created by yjw on 18-6-6.
 */
public class SynchronizedTestCode {
    public static void main2(String[] args) {
        SyncThread syncThread = new SyncThread();
        Thread thread1 = new Thread(syncThread, "t1");
        Thread thread2 = new Thread(syncThread, "t2");
        thread1.start();
        thread2.start();
    }

    public static void main3(String[] args) {
        Thread thread1 = new Thread(new SyncThread(), "SyncThread1");
        Thread thread2 = new Thread(new SyncThread(), "SyncThread2");
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread1 = new Thread(counter, "A");
        Thread thread2 = new Thread(counter, "B");
        thread1.start();
        thread2.start();
    }
}

class SyncThread implements Runnable {

    private static int count;

    public SyncThread() {
        count = 0;
    }
    public void run() {
        synchronized (this) {
            for (int i = 0 ; i<5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getCount() {
        return count;
    }
}

class Counter implements Runnable {
    private int count;

    public Counter() {
        count = 0;
    }

    public void countAdd() {
        synchronized (this) {
            for (int i=0; i<5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void printCount() {
        for (int i=0; i<5; i++) {
            System.out.println(Thread.currentThread().getName() + " count:" + count);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        if (threadName.equals("A")) {
            countAdd();
        } else if (threadName.equals("B")) {
            printCount();
        }
    }
}
