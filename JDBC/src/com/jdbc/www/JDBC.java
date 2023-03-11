package com.jdbc.www;

import java.io.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;

/**
 * jdbc开发步骤
 *  1、注册驱动
 *  2、连接数据库
 *  3、获取发送SQL对象
 * @author lz
 */
public class JDBC {
    public static Connection getConnection() throws ClassNotFoundException, IOException, SQLException {
        InputStream in = new FileInputStream("E:\\idea-Code\\Self_Learn\\JDBC\\database.properties");
        Properties properties = new Properties();
        properties.load(in);
        String driver = properties.getProperty("driver");
        Class.forName(driver);
        String url = properties.getProperty("url");
        String username = properties.getProperty("root");
        String pwd = properties.getProperty("root");
        Connection con = DriverManager.getConnection(url,username,pwd);
        if (con != null){
            System.out.println("连接成功");
        }else {
            System.out.println("连接失败");
        }
        return con;
    }
}
