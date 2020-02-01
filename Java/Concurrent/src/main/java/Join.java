public class Join {
    public static void main(String[] args) {
//        Thread previousThread = Thread.currentThread();
//        for (int i = 1; i <= 10; i++) {
//            Thread curThread = new JoinThread(previousThread);
//            curThread.start();
//            previousThread = curThread;
//        }

        final Thread b = new Thread() {
            @Override
            public void run() {
                System.out.println("thread b running");
                System.out.println("thread b exit");
            }
        };
        final Thread a = new Thread() {
            @Override
            public void run() {
                System.out.println("thread a running");
                try {
                    b.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread a exit");
            }
        };

        a.start();b.start();
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
                System.out.println(thread.getName() + " terminated.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
