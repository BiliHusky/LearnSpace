package archtecture.thread;

import java.util.concurrent.*;

/**
 * Created by yjw on 18-6-15.
 */
public class CreateThreadDemo {

    public static void main(String[] args) {
        // 1.继承thread
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("extend thread");
                super.run();
            }
        };
        thread.start();

        // 2. runnalbe接口
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnalbe");
            }
        });
        thread2.start();

        // 3. callable接口
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "callable";
            }
        });
        try {
            String result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
