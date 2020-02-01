package c1.c2;

/**
 *  demo about dead lock
 */
public class DeadLockEx {
    public static String resourceA = "resource A";
    public static String resourceB = "resource B";

    public static void main(String[] args) {
        runDeadLock();
    }

    public static void runDeadLock() {
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                synchronized (resourceA) {
                    System.out.println(Thread.currentThread().getName() + " get resource A");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (resourceB) {
                        System.out.println(Thread.currentThread().getName() + " get resource B");
                    }
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            public void run() {
                synchronized (resourceB) {
                    System.out.println(Thread.currentThread().getName() + " get resource B");
                    synchronized (resourceA) {
                        System.out.println(Thread.currentThread().getName() + " get resource A");
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
    }

}
