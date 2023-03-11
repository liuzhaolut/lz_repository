package com.etc.plant.service.impl;


import com.etc.plant.dao.CommentDao;
import com.etc.plant.entity.*;
import com.etc.plant.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lz
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDao dao;

    /**
     * 通过条件获取用户信息
     * @param author
     * @param email
     * @return
     */
    @Override
    public User getUid(String author, String email) {
        return dao.getUid(author, email);
    }

    /**
     * 添加评论
     * @param comment
     * @return
     */
    @Override
    public int addComment(Comment comment) {
        int no = 0;
        Comment comment1 = dao.judgeComment(comment);
        if (comment1 != null){
            no = -1;
        } else {
            no = dao.addComment(comment);
        }
        return no;
    }

    /**
     * 获取订单信息
     * @return
     */
    @Override
    public List<Order> getOrders() {
        return dao.getOrder();
    }

    /**
     * 判断是否可评论
     * @param oid
     * @param pid
     * @return
     */
    @Override
    public boolean judgeOrderInfo(int oid, String pid) {
        boolean flag = false;
        try {
            OrderInfo orderInfo = dao.judgeOrderInfo(oid, pid);
            if (orderInfo != null){
                flag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 获取评论信息
     * @param plant_id
     * @return
     */
    @Override
    public List<Comment> getComment(int plant_id) {
        List<Comment> comments = dao.getComment(plant_id);
        return comments;
    }

    /**
     * 获取用户信息
     * @param uid
     * @return
     */
    @Override
    public User getUser(int uid) {
        return dao.getUser(uid);
    }
}
