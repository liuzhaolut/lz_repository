package com.dy.service;

import com.dy.bean.User;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

/**
 * @author DELL
 */
public interface UserService {
    /**
     * 注册
     * @param u
     * @return
     */
    public boolean reg(User u) ;

    /**
     * 登录
     * @param u
     * @return
     */
    public boolean login(User u) ;

    /**
     * 修改密码
     * @param u
     * @param Pass
     * @return
     */
    public boolean updatePassword(User u, String Pass);
}
