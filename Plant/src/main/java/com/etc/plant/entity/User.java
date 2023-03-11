package com.etc.plant.entity;

import java.sql.Timestamp;

/**
 * 用户
 * @author lz
 */
public class User {
    /**
     *id
     */
    private int user_id;
    /**
     *角色id
     */
    private int role_id;
    /**
     *邮箱
     */
    private String user_email;
    /**
     *密码
     */
    private String pwd;
    /**
     *用户名
     */
    private String user_name;
    /**
     *头像
     */
    private String userPhoto;
    /**
     *电话号码
     */
    private String userphone;
    /**
     *最后登录时间
     */
    private Timestamp lastTime;
    /**
     *创建时间
     */
    private Timestamp creatrTime;

    public User(){
    }
    public User(int user_id, int role_id, String user_email, String pwd, String user_name, String userPhoto, String userphone, Timestamp lastTime, Timestamp creatrTime) {
        this.user_id = user_id;
        this.role_id = role_id;
        this.user_email = user_email;
        this.pwd = pwd;
        this.user_name = user_name;
        this.userPhoto = userPhoto;
        this.userphone = userphone;
        this.lastTime = lastTime;
        this.creatrTime = creatrTime;
    }

    public User(String pwd, String userphone) {
        this.pwd = pwd;
        this.userphone = userphone;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public Timestamp getLastTime() {
        return lastTime;
    }

    public void setLastTime(Timestamp lastTime) {
        this.lastTime = lastTime;
    }

    public Timestamp getCreatrTime() {
        return creatrTime;
    }

    public void setCreatrTime(Timestamp creatrTime) {
        this.creatrTime = creatrTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", role_id=" + role_id +
                ", user_email='" + user_email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
