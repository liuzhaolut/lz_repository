package com.jdbc.anli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * dao的实现类
 * @author lz
 */
public class DaoImpl implements Dao{

    @Override
    public int addUser(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "insert into user(username,password,address,phone) values(?,?,?,?);";
        try {
            connection = DButils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getAddress());
            preparedStatement.setString(4,user.getPhone());
            int count = preparedStatement.executeUpdate();
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DButils.close(connection,preparedStatement,null);
        }
        return 0;
    }

    @Override
    public int deleteUser(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "delete from user where username = ?;";
        try {
            connection = DButils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            int count = preparedStatement.executeUpdate();
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DButils.close(connection,preparedStatement,null);
        }
        return 0;
    }

    @Override
    public int updateUser(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update user set password = ?,address = ?,phone = ? where username = ?";
        try {
            connection = DButils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getPassword());
            preparedStatement.setString(2,user.getAddress());
            preparedStatement.setString(3,user.getPhone());
            preparedStatement.setString(4,user.getUsername());
            int count = preparedStatement.executeUpdate();
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DButils.close(connection,preparedStatement,null);
        }
        return 0;
    }

    @Override
    public User selectOne(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from user where username = ?;";
        User u = new User();
        try {
            connection = DButils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                u.setUserId(resultSet.getInt("userId"));
                u.setUsername(resultSet.getString("username"));
                u.setPassword(resultSet.getString("password"));
                u.setAddress(resultSet.getString("address"));
                u.setPhone(resultSet.getString("phone"));
            }
            return u;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DButils.close(connection,preparedStatement,null);
        }
        return null;
    }

    @Override
    public List<User> selectAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> users = new ArrayList<>();
        try {
            connection = DButils.getConnection();
            preparedStatement = connection.prepareStatement("select * from user ;");
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
        return users;
    }
}
