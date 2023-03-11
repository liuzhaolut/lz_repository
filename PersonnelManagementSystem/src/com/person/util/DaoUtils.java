package com.person.util;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 刘昭
 * 工具类 - 封装exeQuery、exeUpdate方法
 * @date 2022/6/25
 */
public class DaoUtils {
    private static Connection connection = null;
    static {
        connection = DbUtils.getConnection();
    }
    /**
     * 查询
     * @param sql
     * @param objects
     * @return
     */
    public ResultSet exeQuery(String sql, Object...objects){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            if (objects != null){
                for (int i = 0; i < objects.length; i++) {
                    preparedStatement.setObject(i + 1,objects[i]);
                }
            }
            resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * 新增、删除、修改
     * @param sql
     * @param objects
     * @return
     */
    public int exeUpdate(String sql, Object[] objects){
        int result = 0;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            if (objects != null){
                for (int i = 0; i < objects.length; i++) {
                    preparedStatement.setObject(i + 1,objects[i]);
                }
            }
            result = preparedStatement.executeUpdate();
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
