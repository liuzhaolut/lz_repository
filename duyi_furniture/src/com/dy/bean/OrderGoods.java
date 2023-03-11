package com.dy.bean;

/**
 * 商品订单
 * @author lz
 */
public class OrderGoods {
//    id
    private int id;
//    订单id
    private int orderId;
//    商品id
    private int goodsId;
//    商品数量
    private int goodsNum;
//    商品单价
    private double goodsPrice;
//    商品名称
    private String goodsName;
//    商品主图
    private String goodsImg;

    public OrderGoods(int id, int orderId, int goodsId, int goodsNum, double goodsPrice, String goodsName, String goodsImg) {
        this.id = id;
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.goodsNum = goodsNum;
        this.goodsPrice = goodsPrice;
        this.goodsName = goodsName;
        this.goodsImg = goodsImg;
    }

    public OrderGoods() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }
}
