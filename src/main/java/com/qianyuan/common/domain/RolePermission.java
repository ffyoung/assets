package com.qianyuan.common.domain;

public class RolePermission {
    private Long rid;
    private Long pid;

    public RolePermission() {
    }

    public RolePermission(Long rid, Long pid) {
        this.rid = rid;
        this.pid = pid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
}
