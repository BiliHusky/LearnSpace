package archtecture.thread;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by yjw on 18-9-6.
 */
public class ThreadpoolTest {
    public static void main(String[] args) {
        int port = 9999;
        ServerSocket s = null;
        int threadPoolSize = 20;
        int threadMaxnumPoolSize = 100;
        int threadKeepAliveTime = 0;
        TimeUnit timeUnit = TimeUnit.HOURS;
        try {
            s = new ServerSocket(port);
            ThreadPoolExecutor executor = new ThreadPoolExecutor(threadPoolSize, threadMaxnumPoolSize, threadKeepAliveTime,
                    timeUnit, new ArrayBlockingQueue<Runnable>(threadMaxnumPoolSize));
            executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

            while (true) {
                Task t = createTask(s.accept());
                if (t != null) {
                    executor.execute(t);
                }

                System.out.println(
                        String.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
                                executor.getPoolSize(),
                                executor.getCorePoolSize(),
                                executor.getActiveCount(),
                                executor.getCompletedTaskCount(),
                                executor.getTaskCount(),
                                executor.isShutdown(),
                                executor.isTerminated()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static PythonTask createTask(Socket socket) {

        try {

            DataInputStream in = new DataInputStream(socket.getInputStream());

            // read config
            String confJson = in.readUTF();

            return new PythonTask(socket, confJson);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}


abstract class Task implements Runnable {

}
class PythonTask extends Task {
    private Socket socket;
    private String conf;

    public PythonTask(Socket socket, String conf) {
        this.socket = socket;
        this.conf = conf;
    }

    private void log(String msg) {
        System.out.println(new Date().toString() + " - " + msg);
    }

    @Override
    public void run() {
        log(String.format("begin with [%s]", Thread.currentThread().getName()));

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}