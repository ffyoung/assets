package com.qianyuan.assets.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.qianyuan.common.domain.Assets;

import java.util.List;

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
    PageInfo<Assets> findWithPage(Integer pageNow, Integer pageSize);


    /**
     * 根据内容信息分页查找
     * @param findContent
     * @return
     */
    PageInfo<Assets> findByContent(String findContent,Integer pageNow);

    int addAssets(Assets assets);


}
