package com.dy.serviceimpl;

import com.dy.bean.User;
import com.dy.dao.UserDao;
import com.dy.daoimpl.UserDaoImpl;
import com.dy.service.UserService;

/**
 * @author DELL
 */
public class UserServiceImpl implements UserService {
    /**
     * 住册
     * @param u
     * @return
     */
    @Override
    public boolean reg(User u) {
        UserDao dao = new UserDaoImpl();
        boolean flag = false;
        try {
            flag = dao.reg(u);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            ((UserDaoImpl) dao).closeDB();
        }
        return flag;
    }

    /**
     * 登录
     * @param u
     * @return
     */
    @Override
    public boolean login(User u) {
        UserDao dao = new UserDaoImpl();
        boolean flag = false;
        try {
            flag = dao.login(u);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            ((UserDaoImpl) dao).closeDB();
        }
        return flag;
    }

    /**
     * 修改密码
     * @param u
     * @param Pass
     * @return
     */
    @Override
    public boolean updatePassword(User u, String Pass) {
        UserDao dao = new UserDaoImpl();
        boolean flag = false;
        try {
            flag = dao.updatePassword(u, Pass);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            ((UserDaoImpl) dao).closeDB();
        }
        return flag;
    }
}
