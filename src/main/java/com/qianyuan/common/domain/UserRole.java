package com.qianyuan.common.domain;

/**
 * user_role 中间表
 * - - - - - - - - - - -
 * |    By   R o c k   |
 * - - - - - - - - - - -
 * Created by rock on 2018-04-02
 */
public class UserRole {

    /**
     * user表中的id
     */
    private Long uid;
    /**
     * 角色表中的id
     */
    private Long rid;

    public UserRole() {
    }

    public UserRole(Long uid, Long rid) {
        this.uid = uid;
        this.rid = rid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
