package com.qianyuan.common.dao;


import com.qianyuan.common.domain.Assets;
import com.qianyuan.common.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * 产品信息Dao
 * Created by rock on 2018-03-31
 */
public interface AssetsDao {

    /**
     * 新增项目
     * @param asset
     * @return
     */
    int addAssets(Assets asset);

    /**
     * 项目删除
     * @param id
     * @return
     */
    int deleteAssets(Long id);

    /**
     * 更具项目内容修改信息
     * @param id
     * @return
     */
    Assets updateAssets(Long id);

    /**
     * 查询项目信息  by Id
     * @param id
     * @return
     */
    Assets findById(Long id);





}
