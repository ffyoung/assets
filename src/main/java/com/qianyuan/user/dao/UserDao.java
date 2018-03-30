package com.qianyuan.user.dao;

import com.qianyuan.user.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    public void addUser(User user);
    public User findUser( @Param("username") String username,@Param("password") String password);
}

