package com.dy.dao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

/**
 * 数据库连接
 * @author lz
 */
public interface BaseDao {
//    打开数据库
    public void openDB() throws ClassNotFoundException, SQLException, IOException, URISyntaxException;
//    关闭数据库资源
    public void closeDB();
    //    打开事务
    public void openTransaction() throws SQLException, URISyntaxException, IOException, ClassNotFoundException;
    //    提交事务
    public void commitTransaction() throws SQLException;
    //    回滚事务
    public void rollbackTransaction() throws SQLException;
}
