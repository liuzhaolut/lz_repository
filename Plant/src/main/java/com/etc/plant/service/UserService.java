package com.etc.plant.service;

import com.etc.plant.entity.Message;
import com.etc.plant.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户服务层
 * @author lz
 */
@Repository
public interface UserService {
    /**
     * 判断用户名
     * @param name
     * @param el
     * @return
     */
    public boolean judgeName(String name, String el);

    /**
     * 注册
     * @return
     */
    public boolean regist(User u);


    /**
     * 登录
     * @return
     */
    public User login(String name, String pd, String el);

    /**
     * 注册2
     * @param el
     * @param pd
     * @return
     */
    public int reg(String el, String pd);

    /**
     * 修改密码
     * @param name
     * @param pwd
     * @return
     */
    public int updatePwd(String name, String pwd);

    /**
     * 获取用户id
     * @param name
     * @param email
     * @return
     */
    public int getUserId(String name, String email);

    /**
     * 添加留言
     * @param message1
     * @return
     */
    public int addMessage(Message message1);
}
