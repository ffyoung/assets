package com.qianyuan.user.dao;

import com.qianyuan.user.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    /**
     * 新增用户
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 用户登录验证
     * @param username
     * @param password
     * @return
     */
    public User findUser(@Param("username") String username,
                         @Param("password") String password);
}

