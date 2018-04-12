package com.qianyuan.user.service;

import com.github.pagehelper.PageInfo;
import com.qianyuan.common.domain.User;
import com.qianyuan.role.bo.RoleBo;
import com.qianyuan.role.bo.UserRoleAssignBo;

import java.util.List;
import java.util.Map;

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



    /**
     * 用户分配角色，联合查询列表
     * @param pageNow
     * @param pageSize
     * @return
     */
    PageInfo<UserRoleAssignBo> findUserAndRole(Integer pageNow, Integer pageSize, String content);
    /**
     * 根据Id查询角色
     * @param id
     * @return
     */
    List<RoleBo> selectRoleByUserId(Long id);

    /**
     * 给用户添加权限保存操作
     * @param userId
     * @param ids
     * @return
     */
    Map<String, Object> addRole2User(Long userId, String ids);

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    User findByAccount(String username);



}
