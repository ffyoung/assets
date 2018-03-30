package com.qianyuan.user.service;

import com.qianyuan.user.dao.UserDao;
import com.qianyuan.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public void regist(User user) {
        userDao.addUser(user);
    }

    @Override
    public User login(String username, String password) {

        User user= userDao.findUser(username,password);
        if (user!=null){
            return user;}
        return null;
    }
}
