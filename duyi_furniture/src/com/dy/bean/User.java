package com.dy.bean;

import java.util.Date;
import java.util.Objects;

/**
 * 用户表
 * @author lz
 */
public class User {
//    id
    private int id;
//    手机号码
    private String userPhone;
//    邮箱
    private String email;
//    密码
    private String password;
//    昵称
    private String nickName;
//    头像图片地址
    private String userPhoto;
//    最后登录ip
    private String lastIp;
//    最后登录时间
    private Date lastTime;
//    注册时间
    private Date createTime;

    public User() {
    }

    public User(String userPhone, String password) {
        this.userPhone = userPhone;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userPhone='" + userPhone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                ", lastIp='" + lastIp + '\'' +
                ", lastTime=" + lastTime +
                ", createTime=" + createTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(userPhone, user.userPhone) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(nickName, user.nickName) &&
                Objects.equals(userPhoto, user.userPhoto) &&
                Objects.equals(lastIp, user.lastIp) &&
                Objects.equals(lastTime, user.lastTime) &&
                Objects.equals(createTime, user.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userPhone, email, password, nickName, userPhoto, lastIp, lastTime, createTime);
    }
}
