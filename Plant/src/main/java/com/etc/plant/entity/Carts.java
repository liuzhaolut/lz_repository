package com.etc.plant.entity;

import java.util.Objects;

/**
 * 购物车
 * @author lz
 */
public class Carts {
    /**
     * id
     */
    private int cart_id;
    /**
     * 用户id
     */
    private int user_id;
    /**
     * 商品id
     */
    private int plant_id;
    /**
     *是否选中（0,1）
     */
    private int isCheck;
    /**
     *商品数量
     */
    private int cartNum;
    /**
     *商品颜色
     */
    private String colour;
    /**
     *尺寸
     */
    private String size;

    public Carts(){

    }
    public Carts(int cart_id, int user_id, int plant_id, int isCheck, int cartNum, String colour, String size) {
        this.cart_id = cart_id;
        this.user_id = user_id;
        this.plant_id = plant_id;
        this.isCheck = isCheck;
        this.cartNum = cartNum;
        this.colour = colour;
        this.size = size;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPlant_id() {
        return plant_id;
    }

    public void setPlant_id(int plant_id) {
        this.plant_id = plant_id;
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

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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
        return plant_id == carts.plant_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cart_id, user_id, plant_id, colour, size, isCheck, cartNum);
    }
}
