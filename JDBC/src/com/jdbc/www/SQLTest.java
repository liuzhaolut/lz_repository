package com.jdbc.www;

import java.io.IOException;
import java.sql.*;
import java.util.Arrays;

/**
 * 测试jdbc使用数据库
 */
public class SQLTest {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
//        addData();
        selectData();
    }

    /**
     * 数据库添加数据
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void addData() throws SQLException, IOException, ClassNotFoundException {
        Connection connection = JDBC.getConnection();
        Statement statement = connection.createStatement();
        String sql = "insert into user(username, `password`, address, phone) values('张ju','123','北京昌沙河','13884527561');";
        int result = statement.executeUpdate(sql);
        if (result == 1) {
            System.out.println("新增成功");
        } else {
            System.out.println("新增失败");
        }
        statement.close();
        connection.close();
    }

    /**
     * PreparedStatemen
     * 不会造成SQL注入
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void selectData() throws SQLException, IOException, ClassNotFoundException {
        Connection connection = DButils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from user where username = ? ;");
        statement.setString(1, "张ju");
        ResultSet result = statement.executeQuery();
        while (result.next()) {
//            根据列名
            int id = result.getInt("userId");
            String name = result.getString("username");
            String password = result.getString("password");
            String address = result.getString("address");
            String phone = result.getString("phone");
            System.out.println("查询结果为： " + id + "   " + name + "  " +password + "  " + address + "  " + phone);
        }
        DButils.close(connection,statement,result);
    }

    /**
     * 会造成SQL注入
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void selectData1() throws SQLException, IOException, ClassNotFoundException {
        Connection connection = JDBC.getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from user ;";
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
//            根据数据类型获得
//            int id = result.getInt(1);
//            String name = result.getString(2);
//            String password = result.getString(3);
//            String address = result.getString(4);
//            String phone = result.getString(5);
//            System.out.println("查询结果为： " + id + "   " + name + "  " +password + "  " + address + "  " + phone);
//            根据列名
            int id = result.getInt("userId");
            String name = result.getString("username");
            String password = result.getString("password");
            String address = result.getString("address");
            String phone = result.getString("phone");
            System.out.println("查询结果为： " + id + "   " + name + "  " +password + "  " + address + "  " + phone);
        }
        statement.close();
        connection.close();
    }
}
