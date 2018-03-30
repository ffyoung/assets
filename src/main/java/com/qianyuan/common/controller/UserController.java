package com.qianyuan.common.controller;

import com.qianyuan.user.domain.User;
import com.qianyuan.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by rock on 2018-03-29
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String loginA(){
        return "test/login";

    }




}
