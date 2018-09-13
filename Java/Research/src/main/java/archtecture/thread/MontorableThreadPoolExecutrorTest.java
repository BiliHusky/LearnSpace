package archtecture.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by yjw on 18-9-6.
 */
public class MontorableThreadPoolExecutrorTest extends ThreadPoolExecutor {
    public MontorableThreadPoolExecutrorTest(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public MontorableThreadPoolExecutrorTest(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public MontorableThreadPoolExecutrorTest(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public MontorableThreadPoolExecutrorTest(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
//        for (MonitorHandler handler : handlerMap.values()) {
//            if (handler.)
//        }
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
    }

    private Map<String, MonitorHandler> handlerMap = new HashMap<>();
    private final Object lock = new Object();

}


interface MonitorHandler {

    boolean usable();
    boolean before(Thread thread, Runnable runnable);
    void after(Runnable runnable, Throwable throwable);
    void terminated(int largestPoolSize, long completedTaskCount);
}