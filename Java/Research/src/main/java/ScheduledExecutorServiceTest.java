import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by yjw on 19-3-5.
 */
public class ScheduledExecutorServiceTest {
    public static void executeFixedRate() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(new PrintThread(), 0, 1000, TimeUnit.MILLISECONDS);
    }

    public static void executeFixedDelay() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleWithFixedDelay(new PrintThread(), 0, 1000, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        executeFixedDelay();
    }
}

class PrintThread implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("This is print thread . current time is : " + System.currentTimeMillis());
    }
}
