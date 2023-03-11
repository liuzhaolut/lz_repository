package com.etc.plant.service;

import com.etc.plant.entity.Comment;
import com.etc.plant.entity.Order;
import com.etc.plant.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 评论服务层
 * @author DELL
 */
@Repository
public interface CommentService {
    /**
     * 获取用户id
     * @param author
     * @param email
     * @return
     */
    public User getUid(String author, String email);

    /**
     * 添加评论
     * @param comment
     */
    public int addComment(Comment comment);

    /**
     * 获取所有订单
     * @return
     */
    public List<Order> getOrders();

    /**
     * 判断是否有此订单详情
     * @param oid
     * @param pid
     * @return
     */
    public boolean judgeOrderInfo(int oid, String pid);

    /**
     * 获取评论
     * @param id
     * @return
     */
    public List<Comment> getComment(int id);

    /**
     * 获取用户信息
     * @param uid
     * @return
     */
    public User getUser(int uid);
}
