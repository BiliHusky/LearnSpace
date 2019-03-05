package com.yjw.cache.simplecache;

import com.yjw.cache.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yjw on 18-9-29.
 */
public class UserMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userServiceBean");
        System.out.println("first query ...");
        userService.getUserById("somebody");
        System.out.println("second query ...");
        userService.getUserById("somebody");

        System.out.println();
        System.out.println("first");
        User user1 = new User("hello", 35);
        userService.getUser(user1);
        System.out.println("second");
        userService.getUser(user1);

        System.out.println();
        User user2 = new User("mygod", 17);
        System.out.println("first");
        userService.getUser(user2);
        System.out.println("second");
        userService.getUser(user2);

    }

}
