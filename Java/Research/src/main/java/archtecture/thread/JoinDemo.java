package archtecture.thread;

/**
 * Created by yjw on 18-6-15.
 */
public class JoinDemo {
    public static void main(String[] args) {
        Thread previousThread = Thread.currentThread();
        for (int i=1; i<=10; i++) {
            Thread currentThread = new JoinThread(previousThread);
            currentThread.start();
            previousThread = currentThread;
        }
    }


    static class JoinThread extends Thread {

        private Thread thread;

        public JoinThread(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
                System.out.println(thread.getName() + " terminated");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
