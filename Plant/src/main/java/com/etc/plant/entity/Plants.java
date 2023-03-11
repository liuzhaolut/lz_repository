package com.etc.plant.entity;

/**
 * 植物
 * @author lz
 */
public class Plants {
    /**
     *id
     */
    private Integer plant_id;
    /**
     *植物名
     */
    private String plant_name;
    /**
     *价格
     */
    private double price;
    /**
     *简介
     */
    private String comment;
    /**
     *图片
     */
    private String pic;
    /**
     *分类
     */
    private String sign;
    /**
     *数量
     */
    private Integer count;
    /**
     *是否上架
     */
    private Integer state;

    public Plants(){

    }
    public Plants(Integer plant_id, String plant_name, double price, String comment, String pic, String sign, Integer count, Integer state) {
        this.plant_id = plant_id;
        this.plant_name = plant_name;
        this.price = price;
        this.comment = comment;
        this.pic = pic;
        this.sign = sign;
        this.count = count;
        this.state = state;
    }

    public Integer getPlant_id() {
        return plant_id;
    }

    public void setPlant_id(Integer plant_id) {
        this.plant_id = plant_id;
    }

    public String getPlant_name() {
        return plant_name;
    }

    public void setPlant_name(String plant_name) {
        this.plant_name = plant_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Plants{" +
                "plant_id=" + plant_id +
                ", plant_name='" + plant_name + '\'' +
                ", price=" + price +
                ", comment='" + comment + '\'' +
                ", pic='" + pic + '\'' +
                ", sign='" + sign + '\'' +
                ", count=" + count +
                ", state=" + state +
                '}';
    }
}
