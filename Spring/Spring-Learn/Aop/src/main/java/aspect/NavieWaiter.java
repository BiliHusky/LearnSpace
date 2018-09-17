package aspect;

/**
 * Created by yjw on 18-9-17.
 */
public class NavieWaiter implements Waiter {
    public void greetTo(String name) {
        System.out.println("naivewaiter: greet to " + name);
    }

    public void serveTo(String name) {
        System.out.println("naivewaiter: serving " + name);
    }
}
