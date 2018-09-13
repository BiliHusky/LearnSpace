package cglibproxy;

import proxywithaop.ForumService;

/**
 * Created by yjw on 18-9-13.
 */
public class ForumServiceImpl implements ForumService {
    public void removeTopic(int topicId) {
        //PerformanceMonitor.begin("proxy.ForumServiceImpl removeTopic");
        System.out.println("delete topic recored : " + topicId);
        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        //PerformanceMonitor.end();
    }

    public void removeForum(int forumId) {
        //PerformanceMonitor.begin("proxy.ForumServiceImpl removeForum");
        System.out.println("delete forum record : " + forumId);
        try {
            Thread.currentThread().sleep(40);
        } catch (InterruptedException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        //PerformanceMonitor.end();
    }
}
