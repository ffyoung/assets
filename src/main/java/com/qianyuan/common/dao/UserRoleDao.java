package com.qianyuan.common.dao;

import com.qianyuan.common.domain.UserRole;
import com.qianyuan.role.bo.UserRoleAssignBo;

import java.util.List;
import java.util.Map;

/**
 * - - - - - - - - - - -
 * |    By   R o c k   |
 * - - - - - - - - - - -
 * Created by rock on 2018-04-03
 */
public interface UserRoleDao {

    int insert(UserRole record);

    int insertSelective(UserRole record);

    int deleteByUserId(Long id);

    int deleteRoleByUserIds(Map<String, Object> resultMap);

    List<Long> findUserIdByRoleId(Long id);

    List<UserRoleAssignBo> findbyUserRole(String content);



}
