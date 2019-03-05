package aspectj.advanced;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by yjw on 18-9-18.
 */

@Aspect
public class TestAspect {

    public void greeToFun() {
        System.out.println("-----greeToFun() executed");
    }

    public void notServeInNaiveWaiter() {
        System.out.println("-----noServeInNaiveWaiter() executed");
    }

    public void waiterOrSeller() {
        System.out.println("-----waiterOrSeller() executed");
    }
}
