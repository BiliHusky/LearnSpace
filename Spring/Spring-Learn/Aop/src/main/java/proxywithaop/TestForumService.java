package proxywithaop;

import java.lang.reflect.Proxy;

/**
 * Created by yjw on 18-9-13.
 */
public class TestForumService {
    public static void main(String[] args) {
        ForumService target = new ForumServiceImpl();

        PerformanceHandler handler = new PerformanceHandler(target);
        ForumService proxy = (ForumService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler
        );
        proxy.removeForum(10);
        proxy.removeTopic(1012);
    }
}
