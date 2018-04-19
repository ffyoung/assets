package com.qianyuan.common.dao;

import com.qianyuan.common.domain.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartDao {
    List<Department> findAll(@Param("content") String content);

    List<Department> findByContent(@Param("content") String content);

    int addDepart(Department department);

    Department findById(Long id);

    int updateByDepartInfo(Department department);

    int deleteById(Long id);

    List<Department> selectDepartName();
}
