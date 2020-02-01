import java.util.LinkedList;
import java.util.List;

public class Yield {
    public static void main(String[]args) {
        Thread thread1 = new YieldThread("thread1");thread1.setPriority(6);
        Thread thread2 = new YieldThread("thread2");thread2.setPriority(5);
        Thread thread3 = new YieldThread("thread3");thread3.setPriority(4);
        Thread thread4 = new YieldThread("thread4");thread4.setPriority(3);
        Thread thread5 = new YieldThread("thread5");thread5.setPriority(2);
        Thread thread6 = new YieldThread("thread6");thread6.setPriority(1);
        List<Thread> threads = new LinkedList<Thread>();
        threads.add(thread1);threads.add(thread2);threads.add(thread3);
        threads.add(thread4);threads.add(thread5);threads.add(thread6);
        for (Thread thread : threads) {
            thread.start();
        }

    }
}

class YieldThread extends Thread {
    private String name;

    public YieldThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.yield();
        System.out.println(name + " " + this.getPriority() + " running");
    }
}