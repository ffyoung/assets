package com.qianyuan.common.domain;

public class UserDepart {
    private Long uid;
    private Long did;

    public UserDepart(Long uid, Long did) {
        this.uid = uid;
        this.did = did;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }
}
