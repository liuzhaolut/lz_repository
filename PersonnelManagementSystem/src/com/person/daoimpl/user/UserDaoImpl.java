package com.person.daoimpl.user;

import com.person.dao.user.UserDao;
import com.person.pojo.Emp;
import com.person.pojo.User;
import com.person.util.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author 逯博
 * @date 2022/6/25 15:54
 */
public class UserDaoImpl implements UserDao {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    /**
     * 登录功能
     *
     * @param username 用户名
     * @param password 密码
     * @return 返回改用户对象
     */
    @Override
    public User login(String username, String password) {
        User user = new User();
        try {
            connection = DbUtils.getConnection();
            String sql = "select * from user where username = ? and password = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, username);
            preparedStatement.setObject(2, password);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("uid");
                String un = resultSet.getString("username");
                String pw = resultSet.getString("password");
                String email = resultSet.getString("email");

                user.setUserId(id);
                user.setUserName(un);
                user.setPassWord(pw);
                user.setEmail(email);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 注册功能
     *
     * @param user 用户信息
     * @return 1代表新增成功 0代表新增失败
     */
    @Override
    public int regist(User user) {
        int state = 0;
        try {
            connection = DbUtils.getConnection();
            String sql = "insert into user(username,password,email) values(?,?,?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,user.getUserName());
            preparedStatement.setObject(2,user.getPassWord());
            preparedStatement.setObject(3, user.getEmail());

            // i 表示修改成功的行数
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                state = 1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return state;
    }
}
