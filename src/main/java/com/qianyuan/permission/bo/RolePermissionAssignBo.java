package com.qianyuan.permission.bo;

import com.qianyuan.common.domain.Role;

public class RolePermissionAssignBo extends Role {
    private String PermissionNames;
    private String PermissionIds;

    public String getPermissionNames() {
        return PermissionNames;
    }

    public void setPermissionNames(String permissionNames) {
        PermissionNames = permissionNames;
    }

    public String getPermissionIds() {
        return PermissionIds;
    }

    public void setPermissionIds(String permissionIds) {
        PermissionIds = permissionIds;
    }
}
