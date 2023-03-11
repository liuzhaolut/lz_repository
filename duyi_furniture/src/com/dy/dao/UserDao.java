package com.dy.dao;

import com.dy.bean.User;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

/**
 * @author DELL
 */
public interface UserDao {
    /**
     * 注册
     * @param u
     * @return
     */
    boolean reg(User u) throws SQLException, URISyntaxException, IOException, ClassNotFoundException;

    /**
     * 登录
     * @param u
     * @return
     */
    boolean login(User u) throws SQLException, URISyntaxException, IOException, ClassNotFoundException;

    /**
     * 修改密码
     * @param u
     * @param Pass
     * @return
     */
    boolean updatePassword(User u, String Pass) throws ClassNotFoundException, SQLException, URISyntaxException, IOException;
}
