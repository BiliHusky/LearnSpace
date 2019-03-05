package aspectj.fun;

import aspectj.Seller;
import aspectj.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by yjw on 18-9-18.
 */
public class PointcutFunTest {
    String configPath = "aspectj/fun/beans.xml";

    @Test
    public void pointcut() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter naiveWaiter = (Waiter) ctx.getBean("naiveWaiter");
        Waiter naughtWaiter = (Waiter) ctx.getBean("naughtWaiter");
        naiveWaiter.greetTo("John");
        naughtWaiter.greetTo("Tom");
    }

    @Test
    public void enableAspect() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter navieWaiter = (Waiter) ctx.getBean("naiveWaiter");
        navieWaiter.greetTo("John");
        navieWaiter.serveTo("John");
        ((Seller)navieWaiter).sell("Beer", "John");
    }

}
