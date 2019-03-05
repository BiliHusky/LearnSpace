package schema;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by yjw on 18-9-19.
 */
public class TestConfig {
    String configPath = "schema/beans.xml";

    @Test
    public void testPreGreeting() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter navieWaiter = (Waiter) ctx.getBean("naiveWaiter");
        Waiter naughtyWaiter = (Waiter) ctx.getBean("naughtyWaiter");
        navieWaiter.greetTo("John");
        naughtyWaiter.greetTo("Tom");
    }
}
