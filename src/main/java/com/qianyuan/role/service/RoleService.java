package com.qianyuan.role.service;

import com.github.pagehelper.PageInfo;
import com.qianyuan.common.domain.Role;
import com.qianyuan.permission.bo.PermissionBo;
import com.qianyuan.permission.bo.RolePermissionAssignBo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * - - - - - - - - - - -
 * |    By   R o c k   |
 * - - - - - - - - - - -
 * Created by rock on 2018-04-02
 */
public interface RoleService {

    /**
     * 查询所有
     * @return
     */
    List<Role> findAll();

    /**
     * 分页查询
     * @return
     */
    PageInfo<Role> findWithPage(Integer pageNo, Integer pageSize);

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    Set<String> findRoleByUserId(Long id);

    /**
     * 根据角色名称或者类型查询
     * @param content
     * @return
     */
    Role findbyRoleNOT(String content);

    /**
     * 添加一个角色
     * @param role
     * @return
     */
    int addRole(Role role);

    /**
     * 根据ID查询角色信息
     * @param id
     * @return
     */
    Role findById(Long id);

    /**
     * 角色信息修改
     * @param role
     * @return
     */
    int updateByRoleInfo(Role role);

    /**
     * 根据ID 删除角色信息
     * @param id
     * @return
     */
    int deleteById(Long id);
    /**
     * 用户分配角色，联合查询列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<RolePermissionAssignBo> findRoleAndPermission(Integer pageNo, Integer pageSize);

    /**
     * 根据角色Id查询权限
     *
     * @param id
     * @return
     */
    List<PermissionBo> selectPermissionByRoleId(Long id);

    /**
     * 给角色添加权限保存操作
     *
     * @param userId
     * @param ids
     * @return
     */
    Map<String, Object> addPermissiontoRole(Long userId, String ids);


}
