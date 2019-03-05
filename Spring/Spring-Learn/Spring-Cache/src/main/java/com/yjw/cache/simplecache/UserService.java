package com.yjw.cache.simplecache;


import com.yjw.cache.domain.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by yjw on 18-9-29.
 */

@Service(value = "userServiceBean")
public class UserService {

    @Cacheable(cacheNames = "users")
    public User getUserById(String userId) {
        System.out.println("real query user." + userId);
        return getFromDB(userId);
    }

    private User getFromDB(String userId) {
        System.out.println("real query db..." + userId);
        return new User(userId);
    }

    @Cacheable(cacheNames = "users", condition = "#user.age < 18")
    public User getUser(User user) {
        System.out.println("query user");
        return user;
    }

}
