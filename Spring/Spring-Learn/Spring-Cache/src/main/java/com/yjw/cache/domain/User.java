package com.yjw.cache.domain;

import java.io.Serializable;

/**
 * Created by yjw on 18-9-29.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 5321906167301258582L;
    private String userId;
    private String userName;
    private int age;

    public User(String userId) {
        this.userId = userId;
    }

    public User(String userId, int age) {
        this.userId = userId;
        this.age = age;
    }

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
