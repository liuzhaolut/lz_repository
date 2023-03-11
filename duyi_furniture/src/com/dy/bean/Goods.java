package com.dy.bean;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 商品
 * @author lz
 */
public class Goods {
//    自增ID
    private int id;
//    商品名称
    private String name;
//    商品图片
    private String imgs;
//    商品价格
    private double price;
//    商品简述
    private String gedsc;
//    商品库存
    private int stock;
//    评价数
    private int appraiseNum;
//    商品详情
    private String info;
//    创建时间
    private Date createTime;
//    一级分类
    private int classid1;
//    二级分类
    private int getClassid2;

    public Goods(int id, String name, String imgs, double price, String gedsc, int stock, int appraiseNum, String info, Date createTime, int classid1, int getClassid2) {
        this.id = id;
        this.name = name;
        this.imgs = imgs;
        this.price = price;
        this.gedsc = gedsc;
        this.stock = stock;
        this.appraiseNum = appraiseNum;
        this.info = info;
        this.createTime = createTime;
        this.classid1 = classid1;
        this.getClassid2 = getClassid2;
    }

    public Goods() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGedsc() {
        return gedsc;
    }

    public void setGedsc(String gedsc) {
        this.gedsc = gedsc;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getAppraiseNum() {
        return appraiseNum;
    }

    public void setAppraiseNum(int appraiseNum) {
        this.appraiseNum = appraiseNum;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getClassid1() {
        return classid1;
    }

    public void setClassid1(int classid1) {
        this.classid1 = classid1;
    }

    public int getGetClassid2() {
        return getClassid2;
    }

    public void setGetClassid2(int getClassid2) {
        this.getClassid2 = getClassid2;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imgs='" + imgs + '\'' +
                ", price=" + price +
                ", gedsc='" + gedsc + '\'' +
                ", stock=" + stock +
                ", appraiseNum=" + appraiseNum +
                ", info='" + info + '\'' +
                ", createTime=" + createTime +
                ", classid1=" + classid1 +
                ", getClassid2=" + getClassid2 +
                '}';
    }
    public List<String> getImg(){
        // 商品图片
        List<String> imgList = null;
        if ("[" .equals(imgs)) {
            imgList = new ArrayList<>();
            imgList.add("img/imgs/errorGoodsImg.jpg");
        } else {
            Gson gs = new Gson();
            imgList = gs.fromJson(imgs, List.class);
        }
        return imgList;
    }
}
