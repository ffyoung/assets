package com.qianyuan.common.dao;

import com.qianyuan.assets.bo.AssetsBo;
import com.qianyuan.common.domain.Assets;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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
    int updateAssets(Assets assets);

    /**
     * 查询项目信息  by Id
     * @param id
     * @return
     */
    Assets findAssetById(Long id);


    /**
     * 查找所有第二代查询
     * @return
     */
    List<Assets> findAll(@Param("findContent") String findContent);


    /**
     * @param findContent
     * @return
     */
    List<Assets> findByContent(@Param("findContent") String findContent);

    List<Assets> selectBystorageDate(@Param("starttime") Date startdate, @Param("endtime") Date enddate);

    List<Assets> selectBybuyDate(@Param("starttime") Date startdate, @Param("endtime") Date enddate);

    List<Assets> selectByoutDate(@Param("starttime") Date startdate, @Param("endtime") Date enddate);

    List<Assets> selectAssetByDepartName(@Param("findContent") String findContent,@Param("partId") Long partId);

    List<Assets> selectAssetByStoraDate(@Param("partId") Long partId, @Param("starttime") Date startdate,
                                        @Param("endtime") Date enddate);

    List<Assets> selectAssetByBuyDate(@Param("partId") Long partId, @Param("starttime") Date startdate,
                                      @Param("endtime") Date enddate);

    List<Assets> selectAssetByOutDate(@Param("partId") Long partId, @Param("starttime") Date startdate,
                                      @Param("endtime") Date enddate);

    int addAssetList(List<Assets> assetList);
}
