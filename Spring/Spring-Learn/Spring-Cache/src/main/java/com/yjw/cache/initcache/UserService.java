package com.yjw.cache.initcache;

import com.yjw.cache.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yjw on 18-9-29.
 */

@Service(value = "initUserService")
public class UserService {
    private Map<Integer, User> users = new HashMap<Integer, User>();
    {
        users.put(1, new User("1", "w1"));
        users.put(2, new User("2", "w2"));
    }

    private CacheManager cacheManager;

    @Autowired
    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @PostConstruct
    public void setup() {
        Cache userCache = cacheManager.getCache("users");
        for (Integer key : users.keySet()) {
            userCache.put(key, users.get(key));
        }
    }

    @Cacheable(value = "users")
    public User getUser(int id) {
        System.out.println("user with id :" + id + " requested.");
        return users.get(id);
    }
}
