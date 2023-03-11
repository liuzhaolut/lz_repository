package com.dy.servlet.user;

import com.dy.bean.Carts;
import com.dy.bean.Message;
import com.dy.bean.User;
import com.dy.service.UserService;
import com.dy.serviceimpl.SqlCartsService;
import com.dy.serviceimpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author DELL
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userPhone = request.getParameter("userPhone");
        String pwd = request.getParameter("pwd");
        System.out.println(userPhone + "   " + pwd);
        User u = new User(userPhone, pwd);
        UserService userService = new UserServiceImpl();
        boolean flag = userService.login(u);
        Message msg = null;
        if (flag) {
            String loginUrl = (String) request.getSession().getAttribute("loginUrl");
            HttpSession session = request.getSession();
            msg = new Message(200, "恭喜你，登录成功了！");
            session.setAttribute("user", u);
            if (loginUrl != null){
                msg.setStatus(201);
                msg.setData(loginUrl);
                request.getSession().removeAttribute("loginUrl");
            }
//            面向切面
//            合并购物车操作
            updateCartStatus(session);

        } else {
            msg = new Message(-1,"很遗憾，账号或者密码错误");
        }
        response.getWriter().append(msg.toJson());
    }

    private void updateCartStatus(HttpSession session) {
        ArrayList<Carts> carts = (ArrayList<Carts>) session.getAttribute("carts");
        User user = (User) session.getAttribute("user");
        if (carts != null && carts.size() > 0){
            session.removeAttribute("carts");
            session.removeAttribute("cartsCount");
            new Thread(){
                @Override
                public void run() {
//                    批处理 aop:切面技术
                    SqlCartsService sqlCartsService = new SqlCartsService();
                    sqlCartsService.insertSessionCarts(user.getId(), carts);
                }
            }.start();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
