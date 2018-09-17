package advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by yjw on 18-9-13.
 */
public class BeforeAdviceTest {
    @Test
    public void before() {
        Waiter target = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);

        pf.addAdvice(advice);

        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
    }

    @Test
    public void beforebean() {
        String config = "advice/beans.xml";
        ApplicationContext  ctx = new ClassPathXmlApplicationContext(config);
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("John");
    }

    @Test
    public void throwAdvice(){
        String configPath = "advice/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        ForumService forumService = (ForumService)ctx.getBean("forumService");

        try{
            forumService.removeForum(10);
        } catch (Exception e) {}

        try{
            forumService.updateForum(new Forum());
        } catch (Exception e) {}
    }

    @Test
    public void introduce() {
        String configPath = "advice/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        ForumService forumService = (ForumService) ctx.getBean("forumService");
        forumService.removeForum(10);

        Monitorable monitorable = (Monitorable) forumService;
        monitorable.setMonitorActive(true);
        forumService.removeForum(10);
    }
}
