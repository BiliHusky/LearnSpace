package com.yjw.cache.cachegroup;

import com.yjw.cache.domain.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yjw on 18-9-29.
 */
@Service(value = "cacheGroupUserService")
public class UserService {
    private Map<Integer, User> pp1 = new HashMap<Integer, User>();
    {
        pp1.put(1, new Member("1", "w1"));
        pp1.put(2, new Visitor("2", "w2"));
    }

    @Caching(cacheable = {
            @Cacheable(value = "members", condition = "#obj instanceof T(com.yjw.cache.cachegroup.Member)"),
            @Cacheable(value = "visitors", condition = "#obj instanceof T(com.yjw.cache.cachegroup.Visitor)")
    })
    public User getUser(User obj) {
        return pp1.get(Integer.valueOf(obj.getUserId()));
    }
}
