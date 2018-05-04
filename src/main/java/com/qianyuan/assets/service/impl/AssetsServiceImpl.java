package com.qianyuan.assets.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianyuan.assets.service.AssetsService;
import com.qianyuan.common.dao.AssetsDao;
import com.qianyuan.common.dao.DepartAssetDao;
import com.qianyuan.common.domain.Assets;
import com.qianyuan.common.domain.DepartAsset;
import com.qianyuan.common.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @Override
    public void addAssetList(MultipartFile file) throws Exception {
        List<Assets> assetsList = new ArrayList<>();
        InputStream in = file.getInputStream();
        List<List<Object>> listob = new ExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        in.close();
        System.out.println("!!!!!!!!!!!!!!!!!!!!" + "开始遍历");
        //遍历listob数据，把数据放到List中
        for (int i = 0; i < listob.size(); i++) {
            List<Object> ob = listob.get(i);
            Assets assets = new Assets();
            //通过遍历实现把每一列封装成一个model中，再把所有的model用List集合装载
            java.util.Date date = null;
            date = formatter.parse(ob.get(0).toString());
            java.sql.Date sdate = new java.sql.Date(date.getTime());
            assets.setStorageDate(sdate);
            assets.setItemName(String.valueOf(ob.get(1)));
            assets.setCoding(String.valueOf(ob.get(2)));
            assets.setStandard(String.valueOf(ob.get(3)));
            assets.setModel(String.valueOf(ob.get(4)));
            assets.setInCount(Long.valueOf(String.valueOf(ob.get(5))));
            assets.setUnit(String.valueOf(ob.get(6)));
            assets.setPrice(Double.parseDouble(ob.get(7).toString()));
            assets.setValue(String.valueOf(ob.get(8)));
            assets.setPropertyUnit(String.valueOf(ob.get(9)));
            java.util.Date date2 = null;
            date2 = formatter.parse(ob.get(10).toString());
            java.sql.Date sdate2 = new java.sql.Date(date2.getTime());
            assets.setBuyDate(sdate2);
            java.util.Date date3 = null;
            date3 = formatter.parse(ob.get(11).toString());
            java.sql.Date sdate3 = new java.sql.Date(date3.getTime());
            assets.setOutDate(sdate3);
            assets.setOutCount(Long.valueOf(String.valueOf(ob.get(12))));
            assets.setArea(String.valueOf(ob.get(13)));
            assets.setGoodsType(String.valueOf(ob.get(14)));
            assets.setGoodsProperty(String.valueOf(ob.get(15)));
            assets.setManagerStatus(String.valueOf(ob.get(16)));
            assets.setUnitUse(String.valueOf(ob.get(17)));
            assets.setManager(String.valueOf(ob.get(18)));
            assets.setInputMessage(String.valueOf(ob.get(19)));
            java.util.Date date1 = null;
            date1 = formatter.parse(ob.get(20).toString());
            java.sql.Date sdate1 = new java.sql.Date(date1.getTime());
            assets.setInputDate(sdate1);
            assets.setAuditor(null);
            assets.setAuditorDate(null);
            assets.setAuthorizer(null);
            assets.setAuthorizerDate(null);
            assets.setPicture(null);
            assets.setUseType(null);
            assets.setRemark(null);

            assetsList.add(assets);
            System.out.println(assets.toString());
        }
        //批量插入
        assetsDao.addAssetList(assetsList);
    }


}
