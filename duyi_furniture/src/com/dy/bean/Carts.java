package com.dy.bean;

import java.util.Objects;

/**
 * 购物车
 * @author lz
 */
public class Carts {
//    id
    private int id;
//    用户id
    private int userId;
//    商品id
    private int goodsId;
//    是否选中（0,1）
    private int isCheck;
//    商品数量
    private int cartNum;

    public Carts(int id, int userId, int goodsId, int isCheck, int cartNum) {
        this.id = id;
        this.userId = userId;
        this.goodsId = goodsId;
        this.isCheck = isCheck;
        this.cartNum = cartNum;
    }

    public Carts(int goodsId) {
        this.goodsId = goodsId;
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

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(int isCheck) {
        this.isCheck = isCheck;
    }

    public int getCartNum() {
        return cartNum;
    }

    public void setCartNum(int cartNum) {
        this.cartNum = cartNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Carts carts = (Carts) o;
        return goodsId == carts.goodsId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, goodsId, isCheck, cartNum);
    }
}
