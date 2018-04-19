package com.qianyuan.depart.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianyuan.common.dao.DepartDao;
import com.qianyuan.common.domain.Department;
import com.qianyuan.depart.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartServiceImpl implements DepartService {
    @Autowired
    DepartDao departDao;

    @Override
    public PageInfo<Department> findWithPage(Integer pageNow, Integer pageSize, String content) {
        pageNow = (pageNow == null) ? 1 : pageNow;
        pageSize = pageSize == null ? 10 : pageSize;
        content = content == null ? "" : content;
        PageHelper.startPage(pageNow, pageSize);
        List<Department> list = departDao.findAll(content);
        PageInfo<Department> page = new PageInfo<>(list);
        return page;
    }


    @Override
    public PageInfo<Department> findByContent(String content, Integer pageNow) {
        pageNow = (pageNow == null) ? 1 : pageNow;
        PageHelper.startPage(pageNow, 10);
        List<Department> list = departDao.findByContent(content);
        PageInfo<Department> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public int addDepart(Department department) {
        return departDao.addDepart(department);
    }

    @Override
    public Department findById(Long id) {
        return departDao.findById(id);
    }

    @Override
    public int updateByDepartInfo(Department department) {
        return departDao.updateByDepartInfo(department);
    }

    @Override
    public int deleteById(Long id) {
        return departDao.deleteById(id);
    }
}
