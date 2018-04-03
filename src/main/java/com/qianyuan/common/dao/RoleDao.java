package com.qianyuan.common.dao;

import com.qianyuan.common.domain.Role;

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


}
