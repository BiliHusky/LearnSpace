package advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by yjw on 18-9-17.
 */
public class AdvisorTest {
    String configPath = "advisor/beans.xml";
    String configPath1 = "advisor/beans2.xml";
    String configPath2 = "advisor/beans3.xml";
    String configPath3 = "advisor/beans4.xml";
    String configPath4 = "advisor/beans5.xml";

    @Test
    public void testStatic() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        Seller seller = (Seller) ctx.getBean("seller");
        waiter.greetTo("John");
        waiter.serveTo("John");
        seller.greetTo("John");
    }

    @Test
    public void testStaticRegex() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath1);
        Waiter waiter = (Waiter) ctx.getBean("waiter1");
        waiter.greetTo("John");
        waiter.serveTo("John");
    }

    @Test
    public void testDynamic() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath2);
        Waiter waiter = (Waiter) ctx.getBean("waiter2");
        waiter.serveTo("Peter");
        System.out.println();
        waiter.greetTo("Peter");
        System.out.println();
        waiter.serveTo("John");
        System.out.println();
        waiter.greetTo("John");
    }

    @Test
    public void testControl() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath3);
        Waiter waiter = (Waiter) ctx.getBean("waiter3");
        WaiterDelegate wd = new WaiterDelegate();
        wd.setWaiter(waiter);
        waiter.serveTo("Peter");
        System.out.println();
        waiter.greetTo("Peter");
        System.out.println();
        wd.service("Peter");
    }

    @Test
    public void testCompose() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath4);
        Waiter waiter = (Waiter) ctx.getBean("waiter4");
        WaiterDelegate wd = new WaiterDelegate();
        wd.setWaiter(waiter);
        waiter.serveTo("Peter");
        System.out.println();
        waiter.greetTo("Peter");
        System.out.println();
        wd.service("Peter");
    }

}
