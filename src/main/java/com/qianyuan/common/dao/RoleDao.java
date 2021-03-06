package com.qianyuan.common.dao;

import com.qianyuan.common.domain.Role;
import com.qianyuan.permission.bo.PermissionBo;
import com.qianyuan.permission.bo.RolePermissionAssignBo;
import org.apache.ibatis.annotations.Param;

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

    List<Role> findAll(@Param("content") String content);

    List<Role> findbyRoleNOT(@Param("content") String content);

    int addRole(Role role);

    Role findById(Long id);

    int updateByRoleInfo(Role role);

    int deleteById(Long id);

    /**
     * 查询角色权限
     *
     * @return
     */
    List<RolePermissionAssignBo> findRoleAndPermission(@Param("content") String content);

    /**
     * 根据用户id查询角色
     *
     * @param id
     * @return
     */
    List<PermissionBo> selectPermissionByRoleId(Long id);



}
