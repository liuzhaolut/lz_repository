package com.dy.test;

import com.dy.bean.User;
import com.dy.dao.UserDao;
import com.dy.daoimpl.UserDaoImpl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

/**
 * @author DELL
 */
public class UserTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, URISyntaxException {
        UserDao dao = new UserDaoImpl();
        User u = new User();
        u.setUserPhone("18177001233");
        u.setPassword("123");
        u.setLastIp("123.221.23.12");
//        boolean reg = dao.reg(u);
//        boolean login = dao.login(u);
        String s = "111";
        boolean update = dao.updatePassword(u, s);
        System.out.println(update);
    }
}
