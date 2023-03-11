package com.dy.bean;

/**
 * 配送方式
 * @author lz
 */
public class Transports {
//    id
    private int id;
//    配送方式名称
    private String name;

    public Transports(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Transports() {

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
}
