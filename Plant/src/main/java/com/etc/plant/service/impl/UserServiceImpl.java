package com.etc.plant.service.impl;

import com.etc.plant.dao.UserDao;
import com.etc.plant.entity.Message;
import com.etc.plant.entity.User;
import com.etc.plant.service.UserService;
import com.etc.plant.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lz
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao dao;

    /**
     * 判断是否可添加
     * @param name
     * @param el
     * @return
     */
    @Override
    public boolean judgeName(String name, String el) {
        boolean flag = true;
        try{
            User user = dao.judgeName(name, el);
            if (user == null){
                flag = false;
            }
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug(e.getMessage() + "用户...");
        }
        return flag;
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        boolean flag = false;
        try{
            int no = dao.regist(user);
            if (no > 0){
                flag = true;
            }
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("用户..." + e.getMessage());
        }
        return flag;
    }

    /**
     * 登录信息
     * @param name
     * @param pd
     * @param el
     * @return
     */
    @Override
    public User login(String name, String pd, String el) {
        User user = null;
        try{
            user = dao.login(name, pd, el);
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("用户..." + e.getMessage());
        }
        return user;
    }

    /**
     * 注册信息
     * @param el
     * @param pd
     * @return
     */
    @Override
    public int reg(String el, String pd) {
        int no = 0;
        try{
            no = dao.reg(el, pd);
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("用户..." + e.getMessage());
        }
        return no;
    }

    /**
     * 修改密码
     * @param name
     * @param pwd
     * @return
     */
    @Override
    public int updatePwd(String name, String pwd) {
        int no = 0;
        User user = dao.judgeName(name,null);
        try{
            if (user != null) {
                no = dao.updatePwd(name, pwd);
            }
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("用户..." + e.getMessage());
        }
        return no;
    }

    /**
     * 获取用户id
     * @param name
     * @param email
     * @return
     */
    @Override
    public int getUserId(String name, String email) {
        int no = 0;
        User user = dao.judgeName(name,null);
        try{
            if (user != null) {
                no = dao.getUserId(name, email);
            }
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("用户..." + e.getMessage());
        }
        return no;
    }

    /**
     * 添加留言
     * @param message1
     * @return
     */
    @Override
    public int addMessage(Message message1) {
        int no = 0;
        try {
            no = dao.addMessage(message1);
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("留言" + e.getMessage());
        }
        return no;
    }

}
