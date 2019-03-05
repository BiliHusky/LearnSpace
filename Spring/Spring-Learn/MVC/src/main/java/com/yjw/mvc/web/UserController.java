package com.yjw.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yjw on 18-11-20.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/register")
    public String register() {
        return "user/register";
    }
}
