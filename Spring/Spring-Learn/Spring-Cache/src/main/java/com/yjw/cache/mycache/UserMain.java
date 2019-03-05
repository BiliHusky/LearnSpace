package com.yjw.cache.mycache;

/**
 * Created by yjw on 18-9-29.
 */
public class UserMain {
    public static void main(String[] args) {
        UserService userService = new UserService();

        userService.getUserById("000001");
        userService.getUserById("000001");
        userService.reload();
        System.out.println("after reload ...");
        userService.getUserById("000001");
        userService.getUserById("000001");
    }
}
