package com.qianyuan.user.controller;

import com.qianyuan.common.controller.CommonController;
import com.qianyuan.common.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rock on 2018-03-29
 */
@Controller
@RequestMapping("user")
public class UserController extends CommonController{


    /**
     * 登录跳转页面
     * @return
     */
    @RequestMapping("login")
    public String login(){
        return "user/login";
    }

    /**
     * 登录提交执行
     * @return
     */
    @RequestMapping(value = "loginDo",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> loginDo(User user){

        //1.创建Subject的实例
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated() == false){
            //将用户密码封装到UsernamePasswordToken
            UsernamePasswordToken upToken = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            try {
                resultMap.put("status", 200);
                resultMap.put("msg", "登录成功！");
                subject.login(upToken);
            } catch (DisabledAccountException e) {
                resultMap.put("status", 500);
                resultMap.put("msg", "账户被禁用！");
            } catch (AuthenticationException e) {
                resultMap.put("status", 500);
                resultMap.put("msg", "账号密码错误！");
            }
        }else {
            resultMap.put("status", 400);
            resultMap.put("msg", "账号密码错误！");
        }
        return resultMap;
    }


//    /**
//     * 跳转到主页面
//     * @return
//     */
//    @RequestMapping(value = "main",method = RequestMethod.GET)
//    public String main(){
//        return "user/main";
//    }

    /**
     * 跳转到主页面
     * @return
     */
    @RequestMapping(value = "main",method = RequestMethod.GET)
    public String main(){
        return "config/main";
    }

}
