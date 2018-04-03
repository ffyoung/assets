package com.qianyuan.core.shiro.token.manager;

import com.qianyuan.common.dao.UserDao;
import com.qianyuan.common.domain.User;
import com.qianyuan.common.util.SpringContextUtil;
import com.qianyuan.core.shiro.token.ShiroRealm;
import com.qianyuan.core.shiro.token.ShiroToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.context.ApplicationContext;

/**
 * - - - - - - - - - - -
 * |    By   R o c k   |
 * - - - - - - - - - - -
 * Created by rock on 2018-04-03
 */
public class TokenManager {

    //用户登录管理
    public static final ShiroRealm realm = SpringContextUtil.getBean("ShiroRealm", ShiroRealm.class);

    /** 解决工具类不能使用Dao层方法*/
    public static ApplicationContext appCtx = SpringContextUtil.getApplicationContext();
    public static UserDao userDao = (UserDao)appCtx.getBean(UserDao.class);

    /**
     * 获取当前登录的用户User对象
     * @return
     */
    public static User getToken(){
        return userDao.findByAccount((String) SecurityUtils.getSubject().getPrincipal());
    }

    /**
     * 判断是否登录
     * @return
     */
    public static boolean isLogin() {
        return null != SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 退出登录
     */
    public static void logout() {
        SecurityUtils.getSubject().logout();
    }

    /**
     * 登录
     * @param user
     * @return
     */
    public static User login(User user){
        ShiroToken token = new ShiroToken(user.getUsername(), user.getPassword());
        SecurityUtils.getSubject().login(token);
        return getToken();
    }

    /**
     * 获取当前用户的Session
     *
     * @return
     */
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 获取当前用户Nickname
     *
     * @return
     */
    public static String getNickname() {
        return getToken().getNickname();
    }


    /**
     * 根据UserIds 	清空权限信息。
     */
    public static void clearUserAuthByUserId(Long... userIds) {
        if (null == userIds || userIds.length == 0) return;
        realm.clearCachedAuthorizationInfo();
    }
}
