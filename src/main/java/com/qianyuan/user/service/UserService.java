package com.qianyuan.user.service;

import com.qianyuan.user.domain.User;

public interface UserService {
    void regist(User user);
    User login(String username,String password);
}
