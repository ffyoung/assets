package com.qianyuan.user.service;

import com.qianyuan.common.domain.User;

public interface UserService {

    /**
     * 新增用户
     * @param user
     */
    int addUser(User user);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    User login(String username,String password);
}
