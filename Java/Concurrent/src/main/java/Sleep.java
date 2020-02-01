import java.util.LinkedList;
import java.util.List;

public class Sleep {
    public static void main(String[] args) {
        int n = 2000;
        List<Thread> threads = new LinkedList<Thread>();
        for(int i=0; i<n; i++) {
            threads.add(new Thread(new SleepThread()));
        }
        long sleepThread = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.start();
        }
        System.out.println("sleep thread total :" + (System.currentTimeMillis() - sleepThread));
        List<Thread> thread1 = new LinkedList<Thread>();
        for (int i=0; i<n; i++) {
            thread1.add(new Thread(new WaitThread()));
        }
        long waitThread = System.currentTimeMillis();
        for (Thread thread : thread1) {
            thread.start();
        }
        System.out.println("wait thread total :" + (System.currentTimeMillis() - waitThread));
    }
}

class SleepThread implements Runnable {

    @Override
    public void run() {
        try {
            //System.out.println(Thread.currentThread() + " running");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class WaitThread implements Runnable {

    @Override
    public void run() {
        synchronized (this) {
            try {
               // System.out.println(Thread.currentThread() + " wait running");
                this.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                this.notifyAll();
            }
        }
    }
}
