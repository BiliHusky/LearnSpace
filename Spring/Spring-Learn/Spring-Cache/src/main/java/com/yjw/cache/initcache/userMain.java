package com.yjw.cache.initcache;

import com.yjw.cache.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yjw on 18-9-29.
 */
public class userMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserService userService = (UserService) context.getBean("initUserService");
        User userFetch1 = userService.getUser(1);
        System.out.println(userFetch1);
        User userFetch2 = userService.getUser(2);
        System.out.println(userFetch2);
    }
}
