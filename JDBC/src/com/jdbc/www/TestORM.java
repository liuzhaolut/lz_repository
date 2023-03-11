package com.jdbc.www;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试ORM
 */
public class TestORM {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> users = new ArrayList<>();
        try {
            connection = DButils.getConnection();
            preparedStatement = connection.prepareStatement("select * from user;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("userId");
                String name = resultSet.getString("username");
                String pwd = resultSet.getString("password");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                User user = new User();
                user.setUserId(id);
                user.setUsername(name);
                user.setPassword(pwd);
                user.setAddress(address);
                user.setPhone(phone);
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DButils.close(connection,preparedStatement,resultSet);
        }
        for (User u:users
             ) {
            System.out.println(u.toString());
        }
    }
}
