package com.qianyuan.common.domain;

import java.util.List;

public class Permission {
    /**
     * id
     */
    private Long id;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限资源
     */
    private String url;
    private List<Role> rolesList;

    public List<Role> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Role> rolesList) {
        this.rolesList = rolesList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
