import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by yjw on 18-12-17.
 */
public class ExchangerDemo {
    private static Exchanger<String> exchanger = new Exchanger();
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String girl = exchanger.exchange("i like u");
                    System.out.println("girl say :" + girl);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("girl out");
                    TimeUnit.SECONDS.sleep(3);
                    String boy = exchanger.exchange("me too");
                    System.out.println("boy say :" + boy);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        service.shutdown();
    }
}
