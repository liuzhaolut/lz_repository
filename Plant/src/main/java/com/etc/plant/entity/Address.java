package com.etc.plant.entity;

import java.sql.Timestamp;

/**
 * 地址
 * @author lz
 */
public class Address {
    /**
     * id
     */
    private int id;
    /**
     *用户id
     */
    private int userId;
    /**
     *收件人姓名
     */
    private String userName;
    /**
     *收件人手机号
     */
    private String userPhone;
    /**
     *省份id
     */
    private int provinceId;
    /**
     *市的id
     */
    private int cityId;
    /**
     *区的id
     */
    private int areaId;
    /**
     *街道的id
     */
    private int streetId;
    /**
     *详细地址
     */
    private String userAddress;
    /**
     *邮编
     */
    private int zipCode;
    /**
     *是否默认地址
     */
    private int isDefault;
    /**
     * 创建时间
     */
    private Timestamp createTime;

    public Address(){

    }
    public Address(int id, int userId, String userName, String userPhone, int provinceId, int cityId, int areaId, int streetId, String userAddress, int zipCode, int isDefault) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.userPhone = userPhone;
        this.provinceId = provinceId;
        this.cityId = cityId;
        this.areaId = areaId;
        this.streetId = streetId;
        this.userAddress = userAddress;
        this.zipCode = zipCode;
        this.isDefault = isDefault;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public int getStreetId() {
        return streetId;
    }

    public void setStreetId(int streetId) {
        this.streetId = streetId;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", provinceId=" + provinceId +
                ", cityId=" + cityId +
                ", areaId=" + areaId +
                ", streetId=" + streetId +
                ", userAddress='" + userAddress + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
