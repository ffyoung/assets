package com.qianyuan.permission.bo;

import com.qianyuan.common.domain.Permission;
import com.qianyuan.common.util.StringUtils;

public class PermissionBo extends Permission {
    /**
     * 角色ID (用String， 考虑多个ID，现在只有一个ID)
     */
    private String roleId;
    /**
     * 是否勾选
     */
    private String marker;

    public boolean isChecked() {
        return StringUtils.equals(roleId, marker);
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }
}
