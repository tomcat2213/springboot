package com.learning.springboot.controller;

import com.learning.springboot.bean.UserBean;
import com.learning.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    private String show() {
        return "login";
    }

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    private String login(String name, String password) {
        UserBean userBean = userService.loginIn(name, password);
        if (userBean != null) {
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    private void test() {
        userService.testLink();
    }
}
