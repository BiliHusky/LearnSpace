public class Interrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
//                int count = 1;
//                while( count ++ < 100000000) {
//                    System.out.println("sleep thread running");
//                }
            }
        };

        Thread busyThread = new Thread() {
            @Override
            public void run() {
                while(!this.isInterrupted()) {
                    System.out.println("busy thread running");
                }
            }
        };

        sleepThread.start();
        busyThread.start();
        Thread.sleep(5000);
        sleepThread.interrupt();
        busyThread.interrupt();
        while(sleepThread.isInterrupted());
        System.out.println("sleep thread is interrupted : " + sleepThread.isInterrupted());
        System.out.println("busy thread is interrupted : " + busyThread.isInterrupted());
    }
}
