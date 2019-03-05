package aspectj;

import anno.NeedTest;

/**
 * Created by yjw on 18-9-18.
 */
public class NaughtyWaiter implements Waiter {
    @NeedTest
    public void greetTo(String clientName) {
        System.out.println("NaughtyWaiter: greet to " + clientName);
    }

    public void serveTo(String clientName) {
        System.out.println("NaughtyWaiter: serve to " + clientName);
    }
}
