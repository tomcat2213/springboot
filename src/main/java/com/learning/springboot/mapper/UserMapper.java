package com.learning.springboot.mapper;

import com.learning.springboot.bean.UserBean;

public interface UserMapper {
    UserBean getInfo(String name, String password);
}
