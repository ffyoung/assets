package com.qianyuan.core.shiro.token;

import com.qianyuan.user.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by rock on 2018-03-29
 */
public class ShiroRealm extends AuthorizingRealm {

    public ShiroRealm() {
        super();
    }

    @Autowired
    private UserService userService;

    /**
     * 授权信息（角色）
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info =new SimpleAuthorizationInfo();
        return info;
    }

    /**
     * 1.doGetAuthenticationInfo,获取认证消息，如果数据库中没有数据，返回null,如果得到正确的用户名和密码，返回指定类型的对象
     *
     * 2.AuthenticationInfo 可以使用SimpleAuthenticationInfo实现类，封装你正确的用户名和密码
     *
     * 3.AuthenticationException 就是我们需要认证的token;
     *
     * 认证信息主要用于用户登录
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {

        /** 用这个实现类封装用户名密码*/
        SimpleAuthenticationInfo info = null;

        /** 将Token 转换成UsernamePasswordToken*/
        UsernamePasswordToken upToken = (UsernamePasswordToken)token;

        /** 获取账户*/
        String username = upToken.getUsername();
        /** 获取密码*/
        String password = String.valueOf(upToken.getPassword());

        if(null == userService.login(username,password)){
            throw new AccountException("账户或密码不正确");
        }else {
            info = new SimpleAuthenticationInfo(username,password,getName());
            return info;
        }
    }
}
