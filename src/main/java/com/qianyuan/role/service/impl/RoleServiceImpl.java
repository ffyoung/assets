package com.qianyuan.role.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianyuan.common.dao.RoleDao;
import com.qianyuan.common.dao.RolePermissionDao;
import com.qianyuan.common.domain.Role;
import com.qianyuan.common.domain.RolePermission;
import com.qianyuan.common.domain.UserRole;
import com.qianyuan.core.shiro.token.manager.TokenManager;
import com.qianyuan.permission.bo.PermissionBo;
import com.qianyuan.permission.bo.RolePermissionAssignBo;
import com.qianyuan.role.service.RoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    @Autowired
    RolePermissionDao rolePermissionDao;

//    @Autowired
//    RolePermissionDao rolePermissionDao;


    /**
     * 分页查询所有
     * @param pageNow
     * @param pageSize
     * @param content
     * @return
     */
    @Override
    public PageInfo<Role> findWithPage(Integer pageNow, Integer pageSize, String content) {
        pageNow = (pageNow == null) ? 1 : pageNow;
        pageSize = pageSize == null?10:pageSize;
        content = content == null ? "" : content;
        PageHelper.startPage(pageNow, pageSize);
        List<Role> list = roleDao.findAll(content);
        PageInfo<Role> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public Set<String> findRoleByUserId(Long id) {
        return roleDao.findRoleByUserId(id);
    }

    @Override
    public PageInfo<Role> findbyRoleNOT(String content, Integer pageNow) {
        pageNow = (pageNow == null) ? 1 : pageNow;
        PageHelper.startPage(pageNow, 10);
        List<Role> list = roleDao.findbyRoleNOT(content);
        PageInfo<Role> page = new PageInfo<>(list);
        return page;
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
    public PageInfo<RolePermissionAssignBo> findRoleAndPermission(Integer pageNo, Integer pageSize, String content) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<RolePermissionAssignBo> list = roleDao.findRoleAndPermission(content);
        PageInfo<RolePermissionAssignBo> page = new PageInfo<>(list);
        return page;

    }

    @Override
    public List<PermissionBo> selectPermissionByRoleId(Long id) {
        return roleDao.selectPermissionByRoleId(id);
    }

    @Override
    public Map<String, Object> addPermissiontoRole(Long roleId, String ids) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        int count = 0;
        try {
            //先删除原有的。
            rolePermissionDao.deleteByRoleId(roleId);
            //如果ids,role 的id 有值，那么就添加。没值象征着：把这个用户（userId）所有角色取消。
            if (StringUtils.isNotBlank(ids)) {
                String[] idArray = null;

                //这里有的人习惯，直接ids.split(",") 都可以，我习惯这么写。清楚明了。
                if (StringUtils.contains(ids, ",")) {
                    idArray = ids.split(",");
                } else {
                    idArray = new String[]{ids};
                }
                //添加新的。
                for (String pid : idArray) {
                    //这里严谨点可以判断，也可以不判断。这个{@link StringUtils 我是重写了的}
                    if (StringUtils.isNotBlank(pid)) {
                        RolePermission entity = new RolePermission(roleId, new Long(pid));
                        count += rolePermissionDao.insertSelective(entity);
                    }
                }
            }
            resultMap.put("status", 200);
            resultMap.put("message", "操作成功");
        } catch (Exception e) {
            resultMap.put("status", 400);
            resultMap.put("message", "操作失败，请重试！");
        }
        //清空用户的权限，迫使再次获取权限的时候，得重新加载
        TokenManager.clearUserAuthByUserId(roleId);
        resultMap.put("count", count);
        return resultMap;
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
