package advice;

/**
 * Created by yjw on 18-9-13.
 */
public class NaiveWaiter implements Waiter{

    public void greetTo(String name) {
        System.out.println("greet to " + name);
    }

    public void serveTo(String name) {
        System.out.println("serving " + name + "...");
    }
}
