package archtecture.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yjw on 18-9-10.
 */
public class UncaughtExceptionHandlerTest {
    // 正常抛出未捕获异常
    public static void main1(String[] args ){
        try {

            Thread thread = new Thread(new Task1());
            thread.start();
        } catch (Exception e) {
            System.out.println("exception :" + e.getMessage());
        }
    }
    // 添加Handler可以捕获
    public static void main11(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
        Thread thread = new Thread(new Task1());
        thread.start();
    }

    //线程池捕获方式

    public static void main(String[] args ) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Thread thread = new Thread(new Task1());
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
       // thread.setUncaughtExceptionHandler(new ExceptionHandler());
        exec.execute(thread);
        exec.shutdown();
    }
}

class Task1 implements Runnable {

    @Override
    public void run() {
        System.out.println(3/2);
        System.out.println(3/0);
        System.out.println(3/1);
    }
}
class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("-- exception :" + e.getMessage());
    }
}