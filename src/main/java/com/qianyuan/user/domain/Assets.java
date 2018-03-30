package com.qianyuan.user.domain;

/**
 * Created by rock on 2018-03-29
 */
public class Assets {

    private Long id;
    private String storageDate;
    private String itemName;
    private String coding;
    private String standard;
    private String model;
    private Long num;
    private String unit;
    private String price;
    private String value;
    private String propertyUnit;
    private String buyDate;
    private String outDate;
    private String area;
    private String goodsType;
    private String goodsProperty;
    private String managerStatus;
    private String unitUse;
    private String manager;
    private String inputMessage;
    private String inputDate;
    private String auditor;
    private String auditorDate;
    private String authorizer;
    private String authorizerDate;
    private String picture;
    private String useType;
    private String remark;

    public Assets() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStorageDate() {
        return storageDate;
    }

    public void setStorageDate(String storageDate) {
        this.storageDate = storageDate;
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

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
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

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getAuditorDate() {
        return auditorDate;
    }

    public void setAuditorDate(String auditorDate) {
        this.auditorDate = auditorDate;
    }

    public String getAuthorizer() {
        return authorizer;
    }

    public void setAuthorizer(String authorizer) {
        this.authorizer = authorizer;
    }

    public String getAuthorizerDate() {
        return authorizerDate;
    }

    public void setAuthorizerDate(String authorizerDate) {
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
                ", storageDate='" + storageDate + '\'' +
                ", itemName='" + itemName + '\'' +
                ", coding='" + coding + '\'' +
                ", standard='" + standard + '\'' +
                ", model='" + model + '\'' +
                ", num=" + num +
                ", unit='" + unit + '\'' +
                ", price='" + price + '\'' +
                ", value='" + value + '\'' +
                ", propertyUnit='" + propertyUnit + '\'' +
                ", buyDate='" + buyDate + '\'' +
                ", outDate='" + outDate + '\'' +
                ", area='" + area + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", goodsProperty='" + goodsProperty + '\'' +
                ", managerStatus='" + managerStatus + '\'' +
                ", unitUse='" + unitUse + '\'' +
                ", manager='" + manager + '\'' +
                ", inputMessage='" + inputMessage + '\'' +
                ", inputDate='" + inputDate + '\'' +
                ", auditor='" + auditor + '\'' +
                ", auditorDate='" + auditorDate + '\'' +
                ", authorizer='" + authorizer + '\'' +
                ", authorizerDate='" + authorizerDate + '\'' +
                ", picture='" + picture + '\'' +
                ", useType='" + useType + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
