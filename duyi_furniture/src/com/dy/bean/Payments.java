package com.dy.bean;

/**
 * 支付方式
 * @author lz
 */
public class Payments {
//    id
    private int id;
//    支付方式名称
    private String name;
//    图片地址
    private String img;

    public Payments(int id, String name, String img) {
        this.id = id;
        this.name = name;
        this.img = img;
    }

    public Payments(){
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
