package com.etc.plant.dao;

import com.etc.plant.entity.Message;
import com.etc.plant.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * 用户持久层
 * @author lz
 */
public interface UserDao {
    /**
     * 判断用户名
     * @param name
     * @param el
     * @return
     */
    public User judgeName(@Param("name") String name, @Param("el") String el);

    /**
     * 注册
     * @return
     */
    public int regist(User user);

    /**
     * 登录
     * @return
     */
    public User login(@Param("name") String name, @Param("pwd") String pd,@Param("el") String el);

    /**
     * 注册2
     * @param el
     * @param pd
     * @return
     */
    public int reg(@Param("el") String el, @Param("pd") String pd);

    /**
     * 修改密码
     * @param name
     * @param pwd
     * @return
     */
    public int updatePwd(@Param("name") String name, @Param("pwd") String pwd);

    /**
     * 获取用户id
     * @param name
     * @param email
     * @return
     */
    public int getUserId(@Param("name") String name, @Param("email") String email);

    /**
     * 添加留言
     * @param message1
     * @return
     */
    public int addMessage(Message message1);
}
