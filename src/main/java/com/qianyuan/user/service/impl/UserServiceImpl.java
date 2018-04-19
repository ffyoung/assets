package com.qianyuan.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianyuan.common.dao.UserDao;
import com.qianyuan.common.dao.UserDepartDao;
import com.qianyuan.common.dao.UserRoleDao;
import com.qianyuan.common.domain.User;
import com.qianyuan.common.domain.UserDepart;
import com.qianyuan.common.domain.UserRole;
import com.qianyuan.core.shiro.token.manager.TokenManager;
import com.qianyuan.depart.bo.DepartBo;
import com.qianyuan.depart.bo.UserDepartAssign;
import com.qianyuan.role.bo.RoleBo;
import com.qianyuan.role.bo.UserRoleAssignBo;
import com.qianyuan.user.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  User业务逻辑类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private UserDepartDao userDepartDao;


    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User login(String username, String password) {
        User user= userDao.findUser(username,password);
        if (user!=null){
            return user;
        }
        return null;
    }

    @Override
    public PageInfo<UserRoleAssignBo> findUserAndRole(Integer pageNow, Integer pageSize, String content) {
        pageNow = pageNow == null ? 1 : pageNow;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNow, pageSize);
        List<UserRoleAssignBo> list = userDao.findUserAndRole(content);
        PageInfo<UserRoleAssignBo> page = new PageInfo<>(list);
        return page;
    }

    public PageInfo<UserDepartAssign> findUserAndDepart(Integer pageNow, Integer pageSize, String content) {
        pageNow = pageNow == null ? 1 : pageNow;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNow, pageSize);
        List<UserDepartAssign> list = userDao.findUserAndDepart(content);
        PageInfo<UserDepartAssign> page = new PageInfo<>(list);
        return page;
    }


    @Override
    public List<RoleBo> selectRoleByUserId(Long id) {
        return userDao.selectRoleByUserId(id);
    }

    @Override
    public List<DepartBo> selectDepartByUserId(Long id) {
        return userDao.selectDepartByUserId(id);
    }


    @Override
    public User findByAccount(String username) {
        return userDao.findByAccount(username);
    }


    @Override
    public Map<String, Object> addRole2User(Long userId, String ids) {
        Map<String,Object> resultMap = new HashMap<String, Object>();
        int count = 0;
        try {
            //先删除原有的。
            userRoleDao.deleteByUserId(userId);
            //如果ids,role 的id 有值，那么就添加。没值象征着：把这个用户（userId）所有角色取消。
            if(StringUtils.isNotBlank(ids)){
                String[] idArray = null;

                //这里有的人习惯，直接ids.split(",") 都可以，我习惯这么写。清楚明了。
                if(StringUtils.contains(ids, ",")){
                    idArray = ids.split(",");
                }else{
                    idArray = new String[]{ids};
                }
                //添加新的。
                for (String rid : idArray) {
                    //这里严谨点可以判断，也可以不判断。这个{@link StringUtils 我是重写了的}
                    if(StringUtils.isNotBlank(rid)){
                        UserRole entity = new UserRole(userId,new Long(rid));
                        count += userRoleDao.insertSelective(entity);
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
        TokenManager.clearUserAuthByUserId(userId);
        resultMap.put("count", count);
        return resultMap;
    }

    @Override
    public Map<String, Object> addDepartToUser(Long userId, String ids) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        int count = 0;
        try {
            //先删除原有的。
            userDepartDao.deleteByUserId(userId);
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
                for (String did : idArray) {
                    //这里严谨点可以判断，也可以不判断。这个{@link StringUtils 我是重写了的}
                    if (StringUtils.isNotBlank(did)) {
                        UserDepart entity = new UserDepart(userId, new Long(did));
                        count += userDepartDao.insertSelective(entity);
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
        TokenManager.clearUserAuthByUserId(userId);
        resultMap.put("count", count);
        return resultMap;
    }

}
