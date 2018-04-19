package com.qianyuan.depart.service;

import com.github.pagehelper.PageInfo;
import com.qianyuan.common.domain.Department;


public interface DepartService {
    /**
     * 分页查询所有
     *
     * @return
     */
    PageInfo<Department> findWithPage(Integer pageNow, Integer pageSize, String content);


    /**
     * 根据部门名称或编号分页查找
     *
     * @param content
     * @return
     */
    PageInfo<Department> findByContent(String content, Integer pageNow);

    /**
     * 添加一个部门
     *
     * @param department
     * @return
     */
    int addDepart(Department department);

    /**
     * 根据ID查询部门信息
     *
     * @param id
     * @return
     */
    Department findById(Long id);

    /**
     * 部门信息修改
     *
     * @param department
     * @return
     */
    int updateByDepartInfo(Department department);

    /**
     * 根据ID 删除部门信息
     *
     * @param id
     * @return
     */
    int deleteById(Long id);

}
