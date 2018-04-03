package com.qianyuan.core.shiro.token;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * - - - - - - - - - - -
 * |    By   R o c k   |
 * - - - - - - - - - - -
 * Created by rock on 2018-04-03
 */
public class ShiroToken   extends UsernamePasswordToken {

    public ShiroToken(String username, String password) {
        super(username,password);
        this.password = password;
    }


    /** 登录密码[字符串类型] 因为父类是char[] ] **/
    private String password ;

    public String getpassword() {
        return password;
    }


    public void setpassword(String password) {
        this.password = password;
    }
}
