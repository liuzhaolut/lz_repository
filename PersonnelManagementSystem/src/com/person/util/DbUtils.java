package com.person.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


/**
 * @author 刘昭
 * 工具类 - 数据库连接
 * @date 2022/6/25
 */
public class DbUtils {
    private static Properties properties = new Properties();

    /**
     * 静态块：读取文件
     */
    static {
        InputStream in = DbUtils.class.getResourceAsStream("/resource/db.properties");
        try {
            properties.load(in);
            Class.forName(properties.getProperty("driver"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),properties.getProperty("password"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    /**
     * 事务开始
     */
    public void begin(){
        Connection connection = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 事务提交
     */
    public void commit(){
        Connection connection = null;
        try {
            connection = getConnection();
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(connection, null, null);
        }
    }

    /**
     * 事务回滚
     */
    public void rollback(){
        Connection connection = null;
        try {
            connection = getConnection();
            connection.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(connection, null, null);
        }
    }

    /**
     * 关闭连接
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet){
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
