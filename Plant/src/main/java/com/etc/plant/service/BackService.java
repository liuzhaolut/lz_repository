package com.etc.plant.service;

import com.etc.plant.entity.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 后台服务层
 * @author lz
 */
@Repository
public interface BackService {
    /**
     * 获取用户信息
     * @return
     */
    public List<User> getUser();

    /**
     * 通过id获取角色信息
     * @param rid
     * @return
     */
    public Role getRoleById(int rid);

    /**
     * 删除用户
     * @param id
     * @return
     */
    public int deleteUser(int id);

    /**
     * 获取角色信息
     * @return
     */
    public List<Role> getRole();

    /**
     * 获取植物信息
     * @return
     */
    public List<Plants> getPlants();

    /**
     * 获取留言信息
     * @return
     */
    public List<Message> getMessage();

    /**
     * 修改角色信息
     * @param rid
     * @param rname
     * @return
     */
    public int updateRole(int rid, String rname);

    /**
     * 删除角色信息
     * @param rid
     * @return
     */
    public int deleteRole(int rid);

    /**
     * 添加角色信息
     * @param rname
     * @return
     */
    public int addRole(String rname);

    /**
     * 修改植物上下架
     * @param pid
     * @param st
     * @return
     */
    public int updatePlantState(int pid, int st);

    /**
     * 删除植物
     * @param pid
     * @return
     */
    public int deletePlant(int pid);

    /**
     * 移动花的类别
     * @param pid
     * @param remove
     * @return
     */
    public int updatePlants(int pid, String remove);

    /**
     * 排序
     * @param sort
     * @return
     */
    public List<Plants> sortPlant(String sort);

    /**
     * 上传植物
     * @param plant
     */
    public void upload(Plants plant);

    /**
     * 获取用户信息
     * @param uid
     * @return
     */
    public User getUserById(int uid);

    /**
     * 删除留言
     * @param mid
     * @return
     */
    public int deleteMessage(int mid);

    /**
     * 获取评论
     * @return
     */
    public List<Comment> getComment();

    /**
     * 获取评论的植物
     * @param pid
     * @return
     */
    public Plants getPlantById(int pid);

    /**
     * 删除评论
     * @param cid
     * @return
     */
    public int deleteComment(int cid);
}
