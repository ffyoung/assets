package com.qianyuan.permission.service;

import com.github.pagehelper.PageInfo;
import com.qianyuan.common.domain.Permission;


import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PermissionService {

//    /**
//     * 查询所有
//     *
//     * @return
//     */
//    List<Permission> findAll();

    /**
     * 分页查询所有
     *
     * @return
     */
    PageInfo<Permission> findWithPage(Integer pageNow, Integer pageSize, String content);

    /**
     * 根据Id查询
     *
     * @param id
     * @return
     */
    Set<String> findPermissionByRolerId(Long id);

    /**
     * 根据内容信息分页查找
     * @param content
     * @return
     */
    PageInfo<Permission> findByContent(String content, Integer pageNow);

    /**
     * 添加一个权限
     *
     * @param permission
     * @return
     */
    int addPermission(Permission permission);

    /**
     * 根据ID查询权限信息
     *
     * @param id
     * @return
     */
    Permission findById(Long id);

    /**
     * 权限信息修改
     *
     * @param permission
     * @return
     */
    int updateByPermissionInfo(Permission permission);

    /**
     * 根据ID 删除权限信息
     *
     * @param id
     * @return
     */
    int deleteById(Long id);

}
