package com.dy.daoimpl;





import com.dy.dao.BaseDao;
import com.dy.util.DbInfo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;

/**
 * @author lz
 */
public class BaseDaoImpl implements BaseDao {
    /**
     * 定义所有数据库对象属性
     */
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Statement statement;


    /**
     * 打开数据库
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IOException
     * @throws URISyntaxException
     */
    @Override
    public void openDB() throws ClassNotFoundException, SQLException, IOException, URISyntaxException {
//        创建实例
        DbInfo dbInfo = DbInfo.getInstance();
//        获取实例
        DbInfo.ConfigInfo configInfo = dbInfo.getProperties();
//        添加驱动
        Class.forName(configInfo.getDriver());
//        数据库连接
        connection = DriverManager.getConnection(configInfo.getUrl(), configInfo.getUsername(), configInfo.getPassword());
    }


    /**
     * 关闭数据库
     */
    @Override
    public void closeDB(){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 打开事务
     * @throws SQLException
     * @throws URISyntaxException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void openTransaction() throws SQLException, URISyntaxException, IOException, ClassNotFoundException {
//        所谓打开事务，其实就是将打开数据库的自动提交功能改为false
        openDB();
        if (connection != null){
            connection.setAutoCommit(false);
        }
    }

    /**
     *  提交事务
     * @throws SQLException
     */
    @Override
    public void commitTransaction() throws SQLException {
        if (connection != null){
            connection.commit();
        }
    }

    /**
     * 回滚事务
     * @throws SQLException
     */
    @Override
    public void rollbackTransaction() throws SQLException {
        if (connection != null){
            connection.rollback();
        }
    }
}
