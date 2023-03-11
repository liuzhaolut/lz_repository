package com.dy.servlet.user;


import com.dy.bean.Message;
import com.dy.bean.User;
import com.dy.service.UserService;
import com.dy.serviceimpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author DELL
 */
@WebServlet("/reg.do")
public class RegServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        //1.    接收参数
        String userPhone = request.getParameter("userPhone");
        String password = request.getParameter("password");
        String smsCode = request.getParameter("smsCode");
        //2.    验证手机号 和 短信验证码
        HttpSession session = request.getSession();
        Object smsPhone = session.getAttribute("smsPhone");
        Object smsCode2 = session.getAttribute("smsCode");
        Message msg = null;
        if(!userPhone.equals(smsPhone) || !smsCode.equals(smsCode2)){
            msg = new Message(-1,"验证码有误");
        }else{
            //3.    进行注册
            System.out.println(userPhone + " 测试 " + password);
            User u = new User(userPhone,password);
            /*String ip = request.getRemoteAddr();
            u.setLastIp(ip);*/
            UserService userService = new UserServiceImpl();
            boolean flag = userService.reg(u);
            System.out.println(flag);
            if(flag){
                //注册成功
                msg = new Message(200,"注册成功");
            }else{
                //注册失败
                msg = new Message(-2,"注册失败");
            }
        }
        response.getWriter().append(msg.toJson());

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
