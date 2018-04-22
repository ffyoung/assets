package com.qianyuan.assets.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.qianyuan.assets.bo.AssetsBo;
import com.qianyuan.common.domain.Assets;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * AssetsService 资产管理服务类
 *   - - - - - - - - - - -
 *   |    By   R o c k   |
 *   - - - - - - - - - - -
 * Created by rock on 2018-04-01
 */
public interface AssetsService {


    /**
     * 查询项目信息  all By Id
     * @param id
     * @return
     */
    Assets findAssetById(Long id);


    /**
     * 分页查找所有
     * @param pageNow
     * @param pageSize
     * @return
     */
    PageInfo<Assets> findWithPage(Integer pageNow, Integer pageSize,String findContent);


    /**
     * 根据内容信息分页查找
     * @param findContent
     * @return
     */
    PageInfo<Assets> findByContent(String findContent,Integer pageNow);

    /**
     * 资产添加
     * @param assets
     * @return
     */
    int addAssets(Assets assets);

    /**
     * 根据存储时间查询
     * @param starttime
     * @param endtinme
     * @return
     */
    List<Assets> selectBystorageDate(Date starttime, Date endtinme);

    /**
     * 根据购入日期查询
     * @param starttime
     * @param endtinme
     * @return
     */
    List<Assets> selectBybuyDate(Date starttime, Date endtinme);

    /**
     * 根据出库日期查询
     * @param starttime
     * @param endtinme
     * @return
     */
    List<Assets> selectByoutDate(Date starttime, Date endtinme);

    /**
     * 根据内容修修改
     * @param assets
     * @return
     */
    int updateAssets(Assets assets);

    /**
     * 根据部门查询产品信息
     *
     * @return
     */
    PageInfo<Assets> selectAssetByDepartName(Integer pageNow, Integer pageSize, String findContent, Long partId);


    /**
     *
     */
    Map<String, Object> addAsset2Depart(Long aid, Long did);

    /**
     * 根据部门Id入库日期查询
     *
     * @param partId
     * @param starttime
     * @param endtinme
     * @return
     */
    List<Assets> selectAssetByStoraDate(Long partId, Date starttime, Date endtinme);

    /**
     * 根据部门Id购买日期查询
     *
     * @param partId
     * @param starttime
     * @param endtinme
     * @return
     */
    List<Assets> selectAssetByBuyDate(Long partId, Date starttime, Date endtinme);

    /**
     * 根据部门Id出库日期查询
     *
     * @param partId
     * @param starttime
     * @param endtinme
     * @return
     */
    List<Assets> selectAssetByOutDate(Long partId, Date starttime, Date endtinme);
}
