package com.etc.plant.entity;

import com.google.gson.Gson;

/**
 * 发送信息方式
 * @author lz
 */
public class Msg {
    /**
     * 状态
     */
    private int status;
    /**
     * 信息
     */
    private String msg;
    /**
     * 数据
     */
    private Object data;

    public Msg() {
    }

    public Msg(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Msg(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Msg(String msg, Object data) {
        this.msg = msg;
        this.data = data;
    }

    public Msg(Object data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public String toJson() {
        return new Gson().toJson(this);
    }
}
