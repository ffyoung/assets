package com.qianyuan.common.domain;

public class DepartAsset {
    private Long did;
    private Long aid;

    public DepartAsset(Long did, Long aid) {
        this.did = did;
        this.aid = aid;
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }
}
