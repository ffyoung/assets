package com.qianyuan.common.dao;

import com.qianyuan.common.domain.RolePermission;
import com.qianyuan.permission.bo.RolePermissionAssignBo;

import java.util.List;
import java.util.Map;

public interface RolePermissiomDao {
    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    int deleteByRoleId(Long id);

    int deleteRoleByUserIds(Map<String, Object> resultMap);

    List<Long> findRoleIdByPermissionId(Long id);


}
