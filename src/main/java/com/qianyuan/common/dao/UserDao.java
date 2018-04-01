package com.qianyuan.common.dao;

import com.qianyuan.common.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 *
 * Created by rock on 2018-03-29
 */
public interface UserDao {
    /**
     * 新增用户
     * @param user
     * @return
     */
     int addUser(User user);

    /**
     * 用户登录验证
     * @param username
     * @param password
     * @return
     */
     User findUser(@Param("username") String username,
                   @Param("password") String password);

    /**
     * 用户删除
     * @param user
     * @return
     */
     int deleteUser(User user);

    /**
     * 更具用户内容修改信息
     * @param id
     * @return
     */
     User updateUser(Long id);

}

