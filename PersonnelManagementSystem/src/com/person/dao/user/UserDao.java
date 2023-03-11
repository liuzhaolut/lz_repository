package com.person.dao.user;

import com.person.pojo.User;

/**
 * @author 逯博
 * @date 2022/6/25 15:53
 */
public interface UserDao {

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 返回改用户对象
     */
    public User login(String username, String password);

    /**
     * 注册功能
     * @param user 用户信息
     * @return 1代表新增成功 0代表新增失败
     */
    public int regist(User user);
}
