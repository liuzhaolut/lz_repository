package com.etc.plant.dao;

import com.etc.plant.entity.Comment;
import com.etc.plant.entity.Order;
import com.etc.plant.entity.OrderInfo;
import com.etc.plant.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 评论持久层
 * @author lz
 */
public interface CommentDao {
    /**
     * 获取用户id
     * @param author
     * @param email
     * @return
     */
    public User getUid(@Param("uname") String author,@Param("email") String email);

    /**
     * 添加评论
     * @param comment
     */
    public int addComment(Comment comment);

    /**
     * 判断有无此订单
     * @param uid
     * @param pid
     * @return
     */
    public Order judgeOrder(@Param("uid") String uid, @Param("pid") String pid);

    /**
     * 获取订单
     * @return
     */
    public List<Order> getOrder();

    /**
     * 判断是否有此详情
     * @param oid
     * @param pid
     * @return
     */
    public OrderInfo judgeOrderInfo(@Param("oid") int oid, @Param("pid") String pid);

    /**
     * 判断是否评论过
     * @param comment
     * @return
     */
    public Comment judgeComment(Comment comment);

    /**
     * 获取评论
     * @param plant_id
     * @return
     */
    public List<Comment> getComment(@Param("pid") Integer plant_id);

    /**
     * 获取uid
     * @param uid
     * @return
     */
    public User getUser(@Param("uid") int uid);
}
