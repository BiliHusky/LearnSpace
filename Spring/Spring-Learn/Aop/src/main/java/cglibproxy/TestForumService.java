package cglibproxy;


import org.testng.annotations.Test;

/**
 * Created by yjw on 18-9-13.
 */
public class TestForumService {
    @Test
    public void proxy(){
        CglibProxy proxy = new CglibProxy();
        ForumServiceImpl forumService = (ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);
        forumService.removeForum(10);
        forumService.removeTopic(1023);
    }
}
