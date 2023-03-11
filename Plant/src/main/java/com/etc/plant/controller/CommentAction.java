package com.etc.plant.controller;

import com.etc.plant.entity.*;
import com.etc.plant.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 评论控制层
 * @author lz
 */
@Controller
public class CommentAction {
    @Autowired
    CommentService commentService;

    /**
     * 添加评论
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/addComment")
    @ResponseBody
    public void addComment(HttpServletRequest request, HttpServletResponse response)  {
        String start = request.getParameter("start");
        String comment = request.getParameter("comment");
        String id = request.getParameter("pid");
        User user = (User) request.getSession().getAttribute("user");
        int uid = user.getUser_id();
        int pid = Integer.parseInt(id);
        Comment comment1 = new Comment(uid, pid, comment, start);
        int no = commentService.addComment(comment1);
        try {
            String msg = "";
            if (no > 0){
                msg = "1";
            }else if (no == -1){
                msg = "-1";
            } else {
                msg = "0";
            }
            response.getWriter().print(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断评论是否存在
     * @param request
     * @param pid
     * @param response
     */
    @RequestMapping("/judgeComment")
    public void judgeComment(HttpServletRequest request, String pid, HttpServletResponse response){
        List<Order> orders = commentService.getOrders();
        try {
            PrintWriter out = response.getWriter();
            int oid = 0;
            boolean f = false;
            for (int i = 0; i < orders.size(); i++) {
                oid = orders.get(i).getOrderId();
                boolean flag = commentService.judgeOrderInfo(oid, pid);
                if (flag){
                    f = true;
                }
            }
            if (f){
                out.print("1");
            } else {
                out.print("0");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
