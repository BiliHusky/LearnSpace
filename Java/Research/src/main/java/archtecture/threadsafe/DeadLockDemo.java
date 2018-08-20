package archtecture.threadsafe;

/**
 * Created by yjw on 18-6-15.
 */
public class DeadLockDemo {
    private static String resource_a = "A";
    private static String resource_b = "B";

    public static void deadLock() {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource_a) {
                    System.out.println("a get resource a ");
                    try {
                        Thread.sleep(3000);
                        synchronized (resource_b) {
                            System.out.println("a get resource b");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource_b) {
                    System.out.println("b get resource b");
                    synchronized (resource_a) {
                        System.out.println("b  get resource a");
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
    }

    public static void main(String[] args) {
        deadLock();
    }

    /***
     * 避免死锁的方式：
     * 1. 避免一个线程同时获得多个锁
     * 2. 避免一个线程在锁的内部占有多个资源
     * 3. 可以使用定时锁， lock.tryLock(timeout) ，保证超时后当前的线程不会阻塞
     * 4. 对于数据库的锁，加锁和解锁必须放在一个数据库连接里
     */
}
