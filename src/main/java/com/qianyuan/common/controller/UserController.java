package com.qianyuan.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by rock on 2018-03-29
 */
@Controller
@RequestMapping("user")
public class UserController {


    @RequestMapping("login")
    public String loginA(){
        return "user/login";

    }



}
