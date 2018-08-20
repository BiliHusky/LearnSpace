package archtecture.thread;

/**
 * Created by yjw on 18-6-25.
 */
public class VolatileDemo {
    private static volatile boolean isOver = false;

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isOver) {
                    System.out.println("is false");
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isOver = true;
    }
}
