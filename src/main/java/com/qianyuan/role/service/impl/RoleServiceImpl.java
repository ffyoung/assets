package com.qianyuan.role.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianyuan.common.dao.RoleDao;
import com.qianyuan.common.domain.Role;
import com.qianyuan.permission.bo.PermissionBo;
import com.qianyuan.permission.bo.RolePermissionAssignBo;
import com.qianyuan.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * - - - - - - - - - - -
 * |    By   R o c k   |
 * - - - - - - - - - - -
 * Created by rock on 2018-04-03
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

//    @Autowired
//    RolePermissionDao rolePermissionDao;


    /**
     * 查询角色
     * @return
     */
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    /**
     * 分页查询所有
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Role> findWithPage(Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo,pageSize);
        List<Role> list =  roleDao.findAll();
        PageInfo<Role> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public Set<String> findRoleByUserId(Long id) {
        return roleDao.findRoleByUserId(id);
    }

    @Override
    public Role findbyRoleNOT(String content) {
        return roleDao.findbyRoleNOT(content);
    }

    @Override
    public int addRole(Role role) {
        return roleDao.addRole(role);
    }

    @Override
    public Role findById(Long id) {
        return roleDao.findById(id);
    }

    @Override
    public int updateByRoleInfo(Role role) {
        return roleDao.updateByRoleInfo(role);
    }

    @Override
    public int deleteById(Long id) {
        return roleDao.deleteById(id);
    }

    @Override
    public PageInfo<RolePermissionAssignBo> findRoleAndPermission(Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<RolePermissionAssignBo> list = roleDao.findRoleAndPermission();
        PageInfo<RolePermissionAssignBo> page = new PageInfo<>(list);
        return page;

    }

    @Override
    public List<PermissionBo> selectPermissionByRoleId(Long id) {
        return roleDao.selectPermissionByRoleId(id);
    }

    @Override
    public Map<String, Object> addPermissiontoRole(Long userId, String ids) {
        return null;
    }


//    @Override
//    public PageInfo<RolePermissionAllocationBo> findRoleAndPermission(Integer pageNo, Integer pageSize) {
//        pageNo = pageNo == null?1:pageNo;
//        pageSize = pageSize == null?10:pageSize;
//        PageHelper.startPage(pageNo,pageSize);
//        List<RolePermissionAllocationBo> list =  rolePermissionDao.findRoleAndPermission();
//        PageInfo<RolePermissionAllocationBo> page = new PageInfo<>(list);
//        return page;
//    }
}
