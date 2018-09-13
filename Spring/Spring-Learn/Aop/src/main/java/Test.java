import advice.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yjw on 18-9-13.
 */
public class Test {
    public static void main(String[] args) {
            String config = "advice/beans.xml";
            ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
            Waiter waiter = (Waiter) ctx.getBean("waiter");
            waiter.greetTo("John");

    }
}
