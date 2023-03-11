package com.etc.plant.service.impl;

import com.etc.plant.dao.BackDao;
import com.etc.plant.entity.*;
import com.etc.plant.service.BackService;
import com.etc.plant.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DELL
 */
@Service
public class BackServiceImpl implements BackService {
    @Autowired
    BackDao dao;

    /**
     * 获取用户信息
     * @return
     */
    @Override
    public List<User> getUser() {
        List<User> users = null;
        try {
            users = dao.getUser();
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("用户..." + e.getMessage());
        }
        return users;
    }

    /**
     * 获取角色id
     * @param rid
     * @return
     */
    @Override
    public Role getRoleById(int rid) {
        return dao.getRoleById(rid);
    }

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    @Override
    public int deleteUser(int id) {
        return dao.deleteUser(id);
    }

    /**
     * 获取角色信息
     * @return
     */
    @Override
    public List<Role> getRole() {
        List<Role> roles = null;
        try {
            roles = dao.getRole();
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("用户..." + e.getMessage());
        }
        return roles;
    }

    /**
     * 获取商品信息
     * @return
     */
    @Override
    public List<Plants> getPlants() {
        List<Plants> plants = null;
        try {
            plants = dao.getPlants();
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("用户..." + e.getMessage());
        }
        return plants;
    }

    /**
     * 获取留言信息
     * @return
     */
    @Override
    public List<Message> getMessage() {
        List<Message> messages = null;
        try {
            messages = dao.getMessage();
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("用户..." + e.getMessage());
        }
        return messages;
    }

    /**
     * 修改角色信息
     * @param rid
     * @param rname
     * @return
     */
    @Override
    public int updateRole(int rid, String rname) {
        int no = 0;
        try {
            no = dao.updateRole(rid, rname);
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("用户..." + e.getMessage());
        }
        return no;
    }

    /**
     * 删除角色
     * @param rid
     * @return
     */
    @Override
    public int deleteRole(int rid) {
        int no = 0;
        try {
            no = dao.deleteRole(rid);
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("用户..." + e.getMessage());
        }
        return no;
    }

    /**
     * 添加角色信息
     * @param rname
     * @return
     */
    @Override
    public int addRole(String rname) {
        int no = 0;
        try {
            no = dao.addRole(rname);
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("用户..." + e.getMessage());
        }
        return no;
    }

    /**
     * 修改商品状态
     * @param pid
     * @param st
     * @return
     */
    @Override
    public int updatePlantState(int pid, int st) {
        int no = 0;
        try{
            no = dao.updatePlantState(st, pid);
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("收藏夹..." + e.getMessage());
        }
        return no;
    }

    /**
     * 删除商品
     * @param pid
     * @return
     */
    @Override
    public int deletePlant(int pid) {
        int no = 0;
        try{
            no = dao.deletePlant(pid);
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("收藏夹..." + e.getMessage());
        }
        return no;
    }

    /**
     * 修改商品信息
     * @param pid
     * @param remove
     * @return
     */
    @Override
    public int updatePlants(int pid, String remove) {
        int no = 0;
        try{
            no = dao.updatePlants(pid, remove);
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("植物..." + e.getMessage());
        }
        return no;
    }

    /**
     * 商品排序
     * @param sort
     * @return
     */
    @Override
    public List<Plants> sortPlant(String sort) {
        List<Plants> plants = null;
        try{
            plants = dao.sortPlant(sort);
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("植物..." + e.getMessage());
        }
        return plants;
    }

    /**
     * 上传商品
     * @param plant
     */
    @Override
    public void upload(Plants plant) {
        try {
            dao.upload(plant);
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug("植物..." + e.getMessage());
        }
    }

    /**
     * 通过id获取用户信息
     * @param uid
     * @return
     */
    @Override
    public User getUserById(int uid) {
        User user = null;
        try {
            user = dao.getUserById(uid);
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug("植物..." + e.getMessage());
        }
        return user;
    }

    /**
     * 删除留言信息
     * @param mid
     * @return
     */
    @Override
    public int deleteMessage(int mid) {
        int no = 0;
        try {
            no = dao.deleteMessage(mid);
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("留言" + e.getMessage());
        }
        return no;
    }

    /**
     * 获取评论
     * @return
     */
    @Override
    public List<Comment> getComment() {
        return dao.getComment();
    }

    /**
     * 获取商品通过商品id
     * @param pid
     * @return
     */
    @Override
    public Plants getPlantById(int pid) {
        return dao.getPlantById(pid);
    }

    /**
     * 删除评论
     * @param cid
     * @return
     */
    @Override
    public int deleteComment(int cid) {
        int no = 0;
        try {
            no = dao.deleteComment(cid);
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("留言" + e.getMessage());
        }
        return no;
    }
}
