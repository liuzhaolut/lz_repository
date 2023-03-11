package com.jdbc.anli;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 数据库连接工具类
 * @author lz
 */
public class DButils {
    private static final Properties PROPERTIES = new Properties();

//    创建一个threadlocal对象
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
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
     * 连接数据库
     * @return
     */
    public static Connection getConnection(){
//        姜丹签的线程绑定的connection对象，赋值给connection
        Connection connection = threadLocal.get();
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(PROPERTIES.getProperty("url"),PROPERTIES.getProperty("username"),PROPERTIES.getProperty("password"));
//                新连接存储在当前线程共享中
                threadLocal.set(connection);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    /**
     * 开启事务
     */
    public static void begin(){
        Connection connection = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    /**
     * 回滚事务
     */
    public static void rollback(){
        Connection connection = null;
        try {
            connection = getConnection();
            connection.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(connection,null,null);
        }
    }
    /**
     * 提交事务
     */
    public static void commit(){
        Connection connection = null;
        try {
            connection = getConnection();
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(connection,null,null);
        }
    }
    /**
     * 关闭连接
     * @param connection
     * @param statement
     * @param resultSet
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (resultSet != null){
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
//                移除连接对象
                threadLocal.remove();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
