package archtecture.thread;

/**
 * Created by yjw on 18-6-19.
 */
public class SynchronizedDemo implements Runnable{
    private static int count = 0;
    @Override
//    public void run() {
//        for (int i=0; i<100000;i++) {
//            count ++;
//        }
//    }
    public void run() {
        synchronized (SynchronizedDemo.class) {
            for (int i = 0; i< 100000; i++) {
                count ++;
            }
        }
    }

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            Thread thread = new Thread(new SynchronizedDemo());
            thread.start();
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("result :" + count);
    }
}
