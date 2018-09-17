package advisor;

/**
 * Created by yjw on 18-9-17.
 */
public class WaiterDelegate {
    private Waiter waiter;
    public void service(String clientName) {
        waiter.greetTo(clientName);
        waiter.serveTo(clientName);
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }
}
