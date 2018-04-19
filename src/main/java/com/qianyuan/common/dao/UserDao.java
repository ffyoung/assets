package com.qianyuan.common.dao;

import com.qianyuan.common.domain.User;
import com.qianyuan.depart.bo.DepartBo;
import com.qianyuan.depart.bo.UserDepartAssign;
import com.qianyuan.role.bo.RoleBo;
import com.qianyuan.role.bo.UserRoleAssignBo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 查询用户角色
     * @return
     */
    List<UserRoleAssignBo> findUserAndRole(@Param("content") String content);

    /**
     * 查询用户部门
     *
     * @return
     */
    List<UserDepartAssign> findUserAndDepart(@Param("content") String content);
    /**
     * 根据用户id查询角色
     * @param id
     * @return
     */
    List<RoleBo> selectRoleByUserId(Long id);

    /**
     * 根据用户id查询角色
     *
     * @param id
     * @return
     */
    List<DepartBo> selectDepartByUserId(Long id);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User findByAccount(String username);

}

