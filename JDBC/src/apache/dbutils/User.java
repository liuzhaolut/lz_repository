package apache.dbutils;

import java.util.Date;

public class User {
    private int userId;
    private String username;
    private String password;
    private String address;
    private String phone;
    private Date createdate;

    public User() {

    }

    public User(String username, String password, String address, String phone, Date createdate) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.createdate = createdate;
    }

    public User(int userId, String username, String password, String address, String phone, Date createdate) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", createdate=" + createdate +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
