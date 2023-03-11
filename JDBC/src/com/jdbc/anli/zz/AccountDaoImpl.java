package com.jdbc.anli.zz;

import com.jdbc.anli.DButils;
import com.jdbc.anli.DateUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao{
    @Override
    public int insert(Account account) {
        return 0;
    }

    @Override
    public int delete(Account account) {
        return 0;
    }

    @Override
    public int update(Account account) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "update account set balance=? where cardNo=?;";
        try {
            connection = DButils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1,account.getBalance());
            preparedStatement.setString(2,account.getCardNo());
            int count = preparedStatement.executeUpdate();
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DButils.close(null,preparedStatement,null);
        }
        return 0;
    }

    @Override
    public Account selectOne(String cardNo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select cardNo,password,name,balance from account where cardNo=?;";
        try {
            connection = DButils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,cardNo);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Account account = new Account();
                account.setCardNo(resultSet.getString("cardNo"));
                account.setPassword(resultSet.getString("password"));
                account.setName(resultSet.getString("name"));
                account.setBalance(resultSet.getDouble("balance"));
                return account;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DButils.close(null,preparedStatement,resultSet);
        }
        return null;
    }
}
