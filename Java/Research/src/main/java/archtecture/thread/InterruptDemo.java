package archtecture.thread;

/**
 * Created by yjw on 18-6-15.
 */
public class InterruptDemo {
    public static void main(String[] args) {
        final Thread sleepThread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };

        Thread busyThread = new Thread() {
            @Override
            public void run() {
                while (true);
            }
        };
        sleepThread.start();
        busyThread.start();
        sleepThread.interrupt();
        busyThread.interrupt();
        while (sleepThread.isInterrupted());
        System.out.println("sleep thread is interrupted :" + sleepThread.isInterrupted());
        System.out.println("busy thread is interrpted :" + busyThread.isInterrupted());
    }
}
