package com.qianyuan.common.dao;

import com.qianyuan.common.domain.Role;
import com.qianyuan.permission.bo.PermissionBo;
import com.qianyuan.permission.bo.RolePermissionAssignBo;

import java.util.List;
import java.util.Set;

/**
 * - - - - - - - - - - -
 * |    By   R o c k   |
 * - - - - - - - - - - -
 * Created by rock on 2018-04-02
 */
public interface RoleDao {


    Set<String> findRoleByUserId(Long id);

    List<Role> findAll();

    Role findbyRoleNOT(String content);

    int addRole(Role role);

    Role findById(Long id);

    int updateByRoleInfo(Role role);

    int deleteById(Long id);

    /**
     * 查询角色权限
     *
     * @return
     */
    List<RolePermissionAssignBo> findRoleAndPermission();

    /**
     * 根据用户id查询角色
     *
     * @param id
     * @return
     */
    List<PermissionBo> selectPermissionByRoleId(Long id);



}
