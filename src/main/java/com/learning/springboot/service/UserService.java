package com.learning.springboot.service;

import com.learning.springboot.bean.UserBean;

public interface UserService {
    UserBean loginIn(String name, String password);
    void testLink();
}
