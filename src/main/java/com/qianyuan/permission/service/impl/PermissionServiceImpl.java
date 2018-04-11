package com.qianyuan.permission.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianyuan.common.dao.PermissionDao;
import com.qianyuan.common.domain.Permission;
import com.qianyuan.permission.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionDao permissionDao;

    @Override
    /**
     *查询权限
     * @return
     */
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    /**
     * 分页查询所有
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Permission> findWithPage(Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<Permission> list = permissionDao.findAll();
        PageInfo<Permission> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public Set<String> findPermissionByRolerId(Long id) {

        return permissionDao.findPermissionByRoleId(id);
    }

    @Override
    public Permission findbyPermissionNOT(String content) {
        return permissionDao.findbyPermissionNOT(content);
    }


    @Override
    public int addPermission(Permission permission) {
        return permissionDao.addPermission(permission);
    }

    @Override
    public Permission findById(Long id) {
        return permissionDao.findById(id);
    }

    @Override
    public int updateByPermissionInfo(Permission permission) {
        return permissionDao.updateByPermissionInfo(permission);
    }

    @Override
    public int deleteById(Long id) {
        return permissionDao.deleteById(id);
    }
}
