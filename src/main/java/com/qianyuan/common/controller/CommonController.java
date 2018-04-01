package com.qianyuan.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * CommonController
 * Created by rock on 2018-03-30
 */
@Controller
@RequestMapping("coon")
public class CommonController {
    protected Map<String, Object> resultMap = new LinkedHashMap<String, Object>();

    @RequestMapping("error")
    public String error(){
        return "config/error";
    }


    @RequestMapping("main")
    public String main(){
        return "config/main";
    }

}
