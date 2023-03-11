package com.person.service.user;


import com.person.pojo.User;

/**
 * @author 逯博
 * @date 2022/6/25 15:52
 */
public interface UserService {
    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 返回用户
     */
    public User login(String username, String password);

    /**
     * 注册功能
     * @param user 用户信息
     * @return 1代表新增成功 0代表新增失败
     */
    public int regist(User user);
}
