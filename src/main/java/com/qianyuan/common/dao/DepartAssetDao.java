package com.qianyuan.common.dao;

import com.qianyuan.common.domain.DepartAsset;

/**
 * - - - - - - - - - - -
 * |    By   R o c k   |
 * - - - - - - - - - - -
 * Created by rock on 2018-04-20
 */
public interface DepartAssetDao {


    /**
     * 根据AssetId删除t_depart_asset的内容
     * @param aid
     * @return
     */
    int deleteByAssetId(Long aid);

    /**
     * add
     * @param record
     * @return
     */
    int insertSelective(DepartAsset record);

}
