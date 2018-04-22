package com.qianyuan.assets.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianyuan.assets.bo.AssetsBo;
import com.qianyuan.assets.service.AssetsService;
import com.qianyuan.common.dao.AssetsDao;
import com.qianyuan.common.dao.DepartAssetDao;
import com.qianyuan.common.domain.Assets;
import com.qianyuan.common.domain.DepartAsset;
import com.qianyuan.common.domain.UserRole;
import com.qianyuan.core.shiro.token.manager.TokenManager;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private DepartAssetDao departAssetDao;




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

    @Override
    public List<Assets> selectBystorageDate(Date starttime, Date endtinme) {
        return assetsDao.selectBystorageDate(starttime, endtinme);
    }

    @Override
    public List<Assets> selectBybuyDate(Date starttime, Date endtinme) {
        return assetsDao.selectBybuyDate(starttime, endtinme);
    }

    @Override
    public List<Assets> selectByoutDate(Date starttime, Date endtinme) {
        return assetsDao.selectByoutDate(starttime, endtinme);
    }

    @Override
    public int updateAssets(Assets assets) {
        return assetsDao.updateAssets(assets);
    }

    @Override
    public PageInfo<Assets> selectAssetByDepartName(Integer pageNow, Integer pageSize, String findContent, Long partId) {
        pageNow = (pageNow == null) ? 1 : pageNow;
        pageSize = pageSize == null ? 10 : pageSize;
        findContent = findContent == null ? "" : findContent;
        PageHelper.startPage(pageNow, pageSize);
        List<Assets> list = assetsDao.selectAssetByDepartName(findContent,partId);
        PageInfo<Assets> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public Map<String, Object> addAsset2Depart(Long aid, Long did) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            //先删除原有的。
            int temp = departAssetDao.deleteByAssetId(aid);
            DepartAsset entity = new DepartAsset(did, aid);
            int count = departAssetDao.insertSelective(entity);
            resultMap.put("status", 200);
            resultMap.put("message", "操作成功");
        } catch (Exception e) {
            resultMap.put("status", 400);
            resultMap.put("message", "操作失败，请重试！");
        }
        return resultMap;
    }

    @Override
    public List<Assets> selectAssetByStoraDate(Long partId, Date starttime, Date endtinme) {
        return assetsDao.selectAssetByStoraDate(partId, starttime, endtinme);
    }

    @Override
    public List<Assets> selectAssetByBuyDate(Long partId, Date starttime, Date endtinme) {
        return assetsDao.selectAssetByBuyDate(partId, starttime, endtinme);
    }

    @Override
    public List<Assets> selectAssetByOutDate(Long partId, Date starttime, Date endtinme) {
        return assetsDao.selectAssetByOutDate(partId, starttime, endtinme);
    }

}
