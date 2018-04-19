package com.qianyuan.depart.bo;

import com.qianyuan.common.domain.Department;
import com.qianyuan.common.domain.Permission;
import com.qianyuan.common.util.StringUtils;

public class DepartBo extends Department {
    /**
     * 角色ID (用String， 考虑多个ID，现在只有一个ID)
     */
    private String userId;
    /**
     * 是否勾选
     */
    private String marker;

    public boolean isChecked() {
        return StringUtils.equals(userId, marker);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }
}
