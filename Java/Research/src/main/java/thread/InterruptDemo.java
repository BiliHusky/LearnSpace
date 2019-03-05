package thread;

/**
 * Created by yjw on 18-11-29.
 */
public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread waitThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println("wait .....");
                    //                    try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException e) {
//                        //e.printStackTrace();
//                        break;
//                    }

                }
            }
        });
        sleepThread.start();
        waitThread.start();
        Thread.sleep(5000);
       // sleepThread.interrupt();
        waitThread.interrupt();

        System.out.println(sleepThread.isInterrupted());
        System.out.println(waitThread.isInterrupted());
    }
}
