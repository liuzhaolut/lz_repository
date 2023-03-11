package com.dy.daoimpl;

import com.dy.bean.User;
import com.dy.dao.UserDao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * @author DELL
 */
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    /**
     * 注册
     * @param u
     * @return
     * @throws SQLException
     * @throws URISyntaxException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public boolean reg(User u) throws SQLException, URISyntaxException, IOException, ClassNotFoundException {
        openDB();
        String sql = "INSERT INTO jj_users(userphone, password, createTime) values (?,?,Now())";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, u.getUserPhone());
        preparedStatement.setString(2, u.getPassword());
        int no = preparedStatement.executeUpdate();
        return no > 0;
    }

    /**
     * 登录
     * @param u
     * @return
     * @throws SQLException
     * @throws URISyntaxException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public boolean login(User u) throws SQLException, URISyntaxException, IOException, ClassNotFoundException {
        openDB();
        String sql = "SELECT * FROM jj_users WHERE userphone = ? AND password = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, u.getUserPhone());
        preparedStatement.setString(2, u.getPassword());
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            loginSuccessUpdate(u.getLastIp(), u.getUserPhone());
            u.setCreateTime(resultSet.getDate("createTime"));
            u.setId(resultSet.getInt("id"));
            u.setEmail(resultSet.getString("email"));
//            u.setLastIp(resultSet.getString("lastIp"));
//            u.setLastTime(resultSet.getDate("lastTime"));
            u.setNickName(resultSet.getString("nickname"));
            u.setUserPhoto(resultSet.getString("userphoto"));
            return true;
        } else {
            return false;
        }

    }

    /**
     * 登录成功时修改IP
     * @param lastIp
     */
    private void loginSuccessUpdate(String lastIp, String userPhone) throws ClassNotFoundException, SQLException, URISyntaxException, IOException {
        openDB();
        String sql = "UPDATE jj_users SET lastip = ?, lastTime = ?  WHERE userphone = ?;";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, lastIp);
        preparedStatement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
        preparedStatement.setString(3, userPhone);
        preparedStatement.executeUpdate();
    }

    /**
     * 修改密码
     * @param u
     * @param Pass
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws URISyntaxException
     * @throws IOException
     */
    @Override
    public boolean updatePassword(User u, String Pass) throws ClassNotFoundException, SQLException, URISyntaxException, IOException {
        openDB();
        String sql = "UPDATE jj_users SET password = ? WHERE userphone = ? And password = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, Pass);
        preparedStatement.setString(2, u.getUserPhone());
        preparedStatement.setString(3, u.getPassword());
        int no = preparedStatement.executeUpdate();
        return no > 0;
    }
}
