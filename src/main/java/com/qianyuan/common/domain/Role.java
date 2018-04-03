package com.qianyuan.common.domain;

import java.util.LinkedList;
import java.util.List;

/**
 * 角色实体类
 * - - - - - - - - - - -
 * |    By   R o c k   |
 * - - - - - - - - - - -
 * Created by rock on 2018-04-02
 */
public class Role {

    /**
     *  ID
     */
    private Long id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色类型，编码
     */
    private String type;

    /**
     * 角色拥有权限
     */
    private List<Permission> permissions = new LinkedList<>();


    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
