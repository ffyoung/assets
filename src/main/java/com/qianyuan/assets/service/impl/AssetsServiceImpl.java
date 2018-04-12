package com.qianyuan.assets.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianyuan.assets.service.AssetsService;
import com.qianyuan.common.dao.AssetsDao;
import com.qianyuan.common.domain.Assets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  资产管理实现（业务）类
 *   - - - - - - - - - - -
 *   |    By   R o c k   |
 *   - - - - - - - - - - -
 * Created by rock on 2018-04-01
 */
@Service
public class AssetsServiceImpl implements AssetsService {

    @Autowired
    private AssetsDao assetsDao;



    @Override
    public Assets findAssetById(Long id) {
        return assetsDao.findAssetById(id);
    }

    @Override
    /**
     * 分页显示all
     */
    public PageInfo<Assets> findWithPage(Integer pageNow, Integer pageSize,String findContent) {
        pageNow = (pageNow == null)?1:pageNow;
        pageSize = pageSize == null?10:pageSize;
        findContent = findContent == null?"":findContent;
        PageHelper.startPage(pageNow,pageSize);
        List<Assets> list =  assetsDao.findAll(findContent);
        PageInfo<Assets> page = new PageInfo<>(list);
        return page;
    }

    @Override
    /**
     * 查询分页显示
     */
    public PageInfo<Assets> findByContent(String findContent, Integer pageNow) {
        pageNow = (pageNow == null)?1:pageNow;
        PageHelper.startPage(pageNow,10);
        List<Assets> list =  assetsDao.findByContent(findContent);
        PageInfo<Assets> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public int addAssets(Assets assets) {

        return assetsDao.addAssets(assets);
    }

}
