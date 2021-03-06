package com.qianyuan.common.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

/**
 * 产品信息类
 * Created by rock on 2018-03-29
 */
public class Assets {

    /**
     * id
     */
    private Long id;
    /**
     * 存储日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date storageDate;
    /**
     * 物品名称
     */
    private String itemName;
    /**
     * 编码
     */
    private String coding;
    /**
     * 规格
     */
    private String standard;
    /**
     * 型号
     */
    private String model;
    /**
     * 入库数量
     */
    private Long inCount;
    /**
     * 单位
     */
    private String unit;
    /**
     * 价格
     */
    private Double price;
    /**
     * 估价
     */
    private String value;
    /**
     * 产权单位
     */
    private String propertyUnit;
    /**
     * 购置日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date buyDate;
    /**
     * 出库日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date outDate;

    /**
     * 出库数量
     */
    private Long outCount;
    /**
     * 产地
     */
    private String area;
    /**
     * 物品分类
     */
    private String goodsType;
    /**
     * 物品属性
     */
    private String goodsProperty;
    /**
     * 管理状态
     */
    private String managerStatus;
    /**
     * 使用单位
     */
    private String unitUse;
    /**
     * 管理责任人
     */
    private String manager;
    /**
     * 信息录入
     */
    private String inputMessage;
    /**
     * 录入日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inputDate;
    /**
     * 审核人
     */
    private String auditor;
    /**
     * 审核日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date auditorDate;
    /**
     * 核准人
     */
    private String authorizer;
    /**
     * 核准日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date authorizerDate;
    /**
     * 附图（链接）
     */
    private String picture;
    /**
     * 用途
     */
    private String useType;
    /**
     * 备注说明
     */
    private String remark;

    public Assets() {
    }
    public Long getInCount() {
        return inCount;
    }

    public void setInCount(Long inCount) {
        this.inCount = inCount;
    }


    public Long getOutCount() {
        return outCount;
    }

    public void setOutCount(Long outCount) {
        this.outCount = outCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }



    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPropertyUnit() {
        return propertyUnit;
    }

    public void setPropertyUnit(String propertyUnit) {
        this.propertyUnit = propertyUnit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsProperty() {
        return goodsProperty;
    }

    public void setGoodsProperty(String goodsProperty) {
        this.goodsProperty = goodsProperty;
    }

    public String getManagerStatus() {
        return managerStatus;
    }

    public void setManagerStatus(String managerStatus) {
        this.managerStatus = managerStatus;
    }

    public String getUnitUse() {
        return unitUse;
    }

    public void setUnitUse(String unitUse) {
        this.unitUse = unitUse;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getInputMessage() {
        return inputMessage;
    }

    public void setInputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }



    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }



    public String getAuthorizer() {
        return authorizer;
    }

    public void setAuthorizer(String authorizer) {
        this.authorizer = authorizer;
    }

    public Date getStorageDate() {
        return storageDate;
    }

    public void setStorageDate(Date storageDate) {
        this.storageDate = storageDate;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Date getAuditorDate() {
        return auditorDate;
    }

    public void setAuditorDate(Date auditorDate) {
        this.auditorDate = auditorDate;
    }

    public Date getAuthorizerDate() {
        return authorizerDate;
    }

    public void setAuthorizerDate(Date authorizerDate) {
        this.authorizerDate = authorizerDate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Assets{" +
                "id=" + id +
                ", storageDate=" + storageDate +
                ", itemName='" + itemName + '\'' +
                ", coding='" + coding + '\'' +
                ", standard='" + standard + '\'' +
                ", model='" + model + '\'' +
                ", inCount=" + inCount +
                ", unit='" + unit + '\'' +
                ", price='" + price + '\'' +
                ", value='" + value + '\'' +
                ", propertyUnit='" + propertyUnit + '\'' +
                ", buyDate=" + buyDate +
                ", outDate=" + outDate +
                ", outCount='" + outCount + '\'' +
                ", area='" + area + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", goodsProperty='" + goodsProperty + '\'' +
                ", managerStatus='" + managerStatus + '\'' +
                ", unitUse='" + unitUse + '\'' +
                ", manager='" + manager + '\'' +
                ", inputMessage='" + inputMessage + '\'' +
                ", inputDate=" + inputDate +
                ", auditor='" + auditor + '\'' +
                ", auditorDate=" + auditorDate +
                ", authorizer='" + authorizer + '\'' +
                ", authorizerDate=" + authorizerDate +
                ", picture='" + picture + '\'' +
                ", useType='" + useType + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
