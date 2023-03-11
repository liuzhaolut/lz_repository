package com.dy.bean;

/**
 * @author DELL
 */
public class CnRegion {
//    id
    private int id;
//    地区码
    private String code;
//    地区名称
    private String name;
//    地区简称
    private String shortName;
//    上级地区编码 如果是0，表示无
    private String parentCode;
//    经度
    private String LNG;
//    纬度
    private String lat;
//    排序
    private int sort;
//    地区级别 1 省份  2市 3县/区  4街道
    private int level;

    public CnRegion(int id, String name, String parentCode, String LNG, String lat, int level) {
        this.id = id;
        this.name = name;
        this.parentCode = parentCode;
        this.LNG = LNG;
        this.lat = lat;
        this.level = level;
    }

    public CnRegion(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public CnRegion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getLNG() {
        return LNG;
    }

    public void setLNG(String LNG) {
        this.LNG = LNG;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "CnRegion{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", parentCode='" + parentCode + '\'' +
                ", LNG='" + LNG + '\'' +
                ", lat='" + lat + '\'' +
                ", sort=" + sort +
                ", level=" + level +
                '}';
    }
}
