package com.qianyuan.common.dao;

import com.qianyuan.common.domain.UserDepart;

import java.util.List;
import java.util.Map;

public interface UserDepartDao {
    int insert(UserDepart record);

    int insertSelective(UserDepart record);

    int deleteByUserId(Long id);

    int deleteDepartByUserIds(Map<String, Object> resultMap);

    List<Long> findUserIdByDepartId(Long id);

}
