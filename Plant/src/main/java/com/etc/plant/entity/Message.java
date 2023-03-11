package com.etc.plant.entity;

/**
 * 留言
 * @author lz
 */
public class Message {
    /**
     *留言id
     */
    private int message_id;
    /**
     *用户id
     */
    private int user_id;
    /**
     *留言内容
     */
    private String message;
    /**
     *手机号码
     */
    private String phone;
    /**
     *所在公司
     */
    private String compay;

    public Message(){

    }
    public Message(int message_id, int user_id, String message, String phone, String compay) {
        this.message_id = message_id;
        this.user_id = user_id;
        this.message = message;
        this.phone = phone;
        this.compay = compay;
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompay() {
        return compay;
    }

    public void setCompay(String compay) {
        this.compay = compay;
    }
}
