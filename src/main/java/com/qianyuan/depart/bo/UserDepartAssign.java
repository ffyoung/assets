package com.qianyuan.depart.bo;

import com.qianyuan.common.domain.User;

public class UserDepartAssign extends User {
    private String departName;
    private String departId;

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }
}
