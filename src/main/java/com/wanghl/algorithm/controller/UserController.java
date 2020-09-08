package com.wanghl.algorithm.controller;

import com.wanghl.algorithm.annotation.Autowired;
import com.wanghl.algorithm.service.UserService;

public class UserController {

    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
}
