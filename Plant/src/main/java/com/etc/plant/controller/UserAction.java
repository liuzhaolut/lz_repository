package com.etc.plant.controller;

import com.etc.plant.entity.Carts;
import com.etc.plant.entity.Message;
import com.etc.plant.entity.Msg;
import com.etc.plant.entity.User;
import com.etc.plant.service.UserService;

import com.etc.plant.util.SendSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * 用户控制层
 * @author lz
 */
@Controller
public class UserAction {
    @Autowired
    UserService userService;

    /**
     * 判断用户是否存在
     * @param request
     * @param response
     */
    @RequestMapping("/judgeNameServlet")
    public void judgeNameServlet(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        String name = request.getParameter("username");
        String el = request.getParameter("el");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean flag = userService.judgeName(name, el);
        if (flag) {
            out.print("1");
        } else {
            out.print("0");
            session.setAttribute("uname",name);
            session.setAttribute("el", el);
        }
    }

    /**
     * 注册用户信息
     * @param request
     * @param response
     */
    @RequestMapping("/regist")
    public void registServlet(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        response.setContentType("text/json;charset=utf-8");
        //1.    接收参数
        String userPhone = request.getParameter("userPhone");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String smsCode = request.getParameter("smsCode");
        //2.    验证手机号 和 短信验证码
        Object smsPhone = session.getAttribute("smsPhone");
        Object smsCode2 = session.getAttribute("smsCode");
        Msg msg = null;
        if(!userPhone.equals(smsPhone) || !smsCode.equals(smsCode2)){
            msg = new Msg(-1,"验证码有误");
        }else{
            //3.    进行注册
            System.out.println(userPhone + " 测试 " + password);
            User u = new User();
            u.setUserphone(userPhone);
            u.setPwd(password);
            u.setUser_email(email);
            u.setUser_name(name);
            boolean flag = userService.regist(u);
            System.out.println(flag);
            if(flag){
                //注册成功
                msg = new Msg(200,"注册成功");
            }else{
                //注册失败
                msg = new Msg(-2,"注册失败");
            }
        }
        try {
            response.getWriter().append(msg.toJson());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 第二种注册方式
     * @param request
     * @param response
     */
    @RequestMapping("rge")
    public void reg(HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String el = (String) session.getAttribute("el");
        String pd = request.getParameter("pd");
        if (el != null) {
            int no = userService.reg(el, pd);
            if (no > 0) {
                out.print("1");
            } else {
                out.print("0");
            }
        } else {
            out.print("0");
        }
    }

    /**
     * 登录用户信息
     * @return
     */
    @RequestMapping("/loginServlet")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("username");
        String pwd = request.getParameter("password");
        String remember = request.getParameter("remember");
        HttpSession session = request.getSession();
        if (name != null) {
            User user = userService.login(name, pwd, null);
            if (user == null) {
//                未登录
                return "login.jsp";
            } else {
//                已登录
                if ("on".equals(remember)) {
                    Cookie cookie = new Cookie("remember", name + "#" + pwd + "#");
//            设置cookie的有效时长
                    cookie.setMaxAge(60 * 2);
//            设置好的cookie添加到浏览器端
                    response.addCookie(cookie);
                }
                session.setAttribute("user",user);
                String type = request.getParameter("type");
                if ("car".equals(type)) {
                    return "forward:getShopCarServlet.do";
                } else if ("collection".equals(type)) {
                    return "forward:getCollectionServlet.do";
                } else {
                    //            登录成功
                    return "index.jsp";
                }
            }
        } else {
            String el = request.getParameter("email");
            String pd = request.getParameter("pwd");
            User user = userService.login(null, pd, el);
            if (user == null) {
                return "login.jsp";
            } else {
                session.setAttribute("user",user);
                String type = request.getParameter("type");
                if ("car".equals(type)) {
                    return "forward:getShopCarServlet.do";
                } else if ("collection".equals(type)) {
                    return "forward:getCollectionServlet.do";
                } else {
                    //            登录成功
                    return "index.jsp";
                }
            }
        }
    }

    /**
     * 发送短信验证
     * @param request
     * @param response
     */
    @RequestMapping("/sms")
    public void sms(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/json;charset=utf-8");
        //1.    接收请求中的参数  (手机号码 和 status)
        String status = request.getParameter("status");
        String userPhone = request.getParameter("userPhone");
        HttpSession session = request.getSession();
        //2.    发送短信
        int num = SendSms.random();
        Msg msg = null;
        switch (status){
            case "1":{
                //发送注册短信
                boolean flag = SendSms.send(userPhone, num);
                if(flag){
                    //成功
                    msg = new Msg(200,"短信发送成功");
                    session.setAttribute("smsPhone", userPhone);
                    session.setAttribute("smsCode","" + num);
                }else{
                    //失败
                    msg = new Msg(-1,"短信发送失败,请检查手机号码");
                }
                break;
            }
        }
        try {
            response.getWriter().append(msg.toJson());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @RequestMapping("/logoutServlet")
    public String logoutServlet(HttpServletRequest request, HttpServletResponse response){
//         销毁session
        request.getSession().invalidate();
//        清除cookie
        Cookie[] cookies = request.getCookies();
//        判断是否为空，之后进行操作
        if (cookies != null) {
//            查询自己设置的cookie
            for (Cookie c:cookies
            ) {
                if ("cuser" .equals(c.getName())) {
                    c.setMaxAge(0);
                    response.addCookie(c);
                }
            }
        }
        return "index.jsp";
    }

    /**
     * 修改密码
     * @param request
     * @return
     */
    @RequestMapping("/updatePwdServlet")
    public String updatePwdServlet(HttpServletRequest request){
        String name = request.getParameter("mname");
        String pwd = request.getParameter("newpass");
        int no = userService.updatePwd(name, pwd);
        if (no > 0) {
            return "login.jsp";
        }
        return "404page.jsp";
    }

    /**
     * 添加留言信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/addMessageServlet")
    public String addMessageServlet(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        String name = request.getParameter("your-name");
        String email = request.getParameter("your-email");
        String phone = request.getParameter("your-phone");
        String company = request.getParameter("your-company");
        String message = request.getParameter("your-message");
        User user = new User();
        user.setUser_name(name);
        user.setUser_email(email);
        int id = userService.getUserId(name, email);
        System.out.println(id);
        Message message1 = new Message();
        message1.setMessage(message);
        message1.setPhone(phone);
        message1.setUser_id(id);
        message1.setCompay(company);
        int no = userService.addMessage(message1);
        if (no > 0) {
            session.setAttribute("message","留言成功");
            return "contact.jsp";
        }
        return "404page.jsp";
    }
}
