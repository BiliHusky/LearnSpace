package com.yjw.cache.mycache;

import com.yjw.cache.domain.User;

/**
 * Created by yjw on 18-9-29.
 */
public class UserService {
    private CacheManager<User> cacheManager;

    public UserService() {
        cacheManager = new CacheManager<User>();
    }

    public User getUserById(String userId) {
        User result = cacheManager.getValue(userId);
        if (result!=null) {
            System.out.println("get from cache ..." + userId);
            return result;
        }

        result = getFromDB(userId);

        if (result !=null) {
            cacheManager.addOrUpdateCache(userId, result);
        }

        return result;
    }

    private  User getFromDB(String userId) {
        System.out.println("real query db ..." + userId);
        return new User(userId);
    }

    public void reload() {
        cacheManager.evictCache();
    }
}
