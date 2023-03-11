package com.etc.plant.dao;

import com.etc.plant.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台持久层
 * @author lz
 */
public interface BackDao {
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
    public Role getRoleById(@Param("rid") int rid);

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    public int deleteUser(@Param("id") int id);

    /**
     *获取角色信息
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
    public int updateRole(@Param("rid") int rid, @Param("rname") String rname);

    /**
     * 删除角色
     * @param rid
     * @return
     */
    public int deleteRole(@Param("rid") int rid);

    /**
     * 添加角色信息
     * @param rname
     * @return
     */
    public int addRole(@Param("rname") String rname);

    /**
     * 修改植物状态
     * @param st
     * @param pid
     * @return
     */
    public int updatePlantState(@Param("st") int st, @Param("pid") int pid);

    /**
     * 删除植物
     * @param pid
     * @return
     */
    public int deletePlant(@Param("pid") int pid);

    /**
     * 移动植物类别
     * @param pid
     * @param remove
     * @return
     */
    public int updatePlants(@Param("pid") int pid, @Param("remove") String remove);

    /**
     * 排序
     * @param sort
     * @return
     */
    public List<Plants> sortPlant(@Param("sort") String sort);

    /**
     * 上传
     * @param plant
     */
    public void upload(Plants plant);

    /**
     * 通过id获取用户
     * @param uid
     * @return
     */
    public User getUserById(@Param("uid") int uid);

    /**
     * 删除留言
     * @param mid
     * @return
     */
    public int deleteMessage(@Param("mid") int mid);

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
    public Plants getPlantById(@Param("pid") int pid);

    /**
     * 删除评论
     * @param cid
     * @return
     */
    public int deleteComment(@Param("cid") int cid);
}
