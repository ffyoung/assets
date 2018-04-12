package com.qianyuan.common.dao;

import com.qianyuan.common.domain.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface PermissionDao {

    Set<String> findPermissionByRoleId(Long id);

    List<Permission> findAll(@Param("content") String content);

    List<Permission> findByContent(@Param("content") String content);

    int addPermission(Permission permission);

    Permission findById(Long id);

    int updateByPermissionInfo(Permission permission);

    int deleteById(Long id);
}
