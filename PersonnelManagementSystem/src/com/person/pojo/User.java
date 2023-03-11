package com.person.pojo;

/**
 * @author itcherish
 * @date 2022/6/21 20:43
 */
public class User {
    private Integer userId;
    private String userName;
    private String passWord;
    private String email;

    public User() {
    }

    public User(Integer userId, String userName, String passWord, String email) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
