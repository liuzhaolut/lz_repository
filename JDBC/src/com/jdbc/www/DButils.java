package com.jdbc.www;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 封装数据库连接工具类
 * @author  lz
 */
public class DButils {
//    存储配置文件
    private static final Properties PROPERTIES = new Properties();


    static {
        InputStream in = DButils.class.getResourceAsStream("/database.properties");
        try {
            PROPERTIES.load(in);
            Class.forName(PROPERTIES.getProperty("driver"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
         }
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(PROPERTIES.getProperty("url"),PROPERTIES.getProperty("username"),PROPERTIES.getProperty("password"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }

    /**
     * 释放资源
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
