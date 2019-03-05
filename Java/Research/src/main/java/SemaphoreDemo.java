import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by yjw on 18-12-17.
 */
public class SemaphoreDemo {
    private static Semaphore semaphore = new Semaphore(5);

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i=0; i<10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + " ready to get pen");
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + " get pen");
                        System.out.println(Thread.currentThread().getName() + " write");
                        TimeUnit.SECONDS.sleep(10);
                        semaphore.release();
                        System.out.println(Thread.currentThread().getName() + " return pen");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        service.shutdown();
    }
}
