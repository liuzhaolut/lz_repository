package com.person.serviceimpl.user;

import com.person.dao.user.UserDao;
import com.person.daoimpl.user.UserDaoImpl;
import com.person.pojo.User;
import com.person.service.user.UserService;

/**
 * @author 逯博
 * @date 2022/6/25 15:51
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    /**
     * 登录功能
     *
     * @param username 用户名
     * @param password 密码
     * @return 返回用户名密码是否正确
     */
    @Override
    public User login(String username, String password) {
        User user = userDao.login(username, password);

        return user;
    }

    /**
     * 注册功能
     *
     * @param user 用户信息
     * @return 1代表新增成功 0代表新增失败
     */
    @Override
    public int regist(User user) {
        int state = userDao.regist(user);
        return state;
    }
}
