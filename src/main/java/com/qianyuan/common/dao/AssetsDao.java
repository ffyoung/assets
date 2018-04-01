package com.qianyuan.common.dao;


import com.github.pagehelper.Page;
import com.qianyuan.common.domain.Assets;
import com.qianyuan.common.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
    int deleteAssetsById(Long id);

    /**
     * 更具项目内容修改信息
     * @param assets
     * @return
     */
    Assets updateAssets(Assets assets);

    /**
     * 查询项目信息  by Id
     * @param id
     * @return
     */
    Assets findAssetById(Long id);


    /**
     * 查找所有
     * @return
     */
    List<Assets> findAll();


    List<Assets> findByContent(String findContent);





}
