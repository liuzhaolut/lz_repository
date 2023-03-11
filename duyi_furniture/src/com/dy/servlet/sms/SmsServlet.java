package com.dy.servlet.sms;


import com.dy.bean.Message;
import com.dy.util.SendSms;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用于发送短信的servlet
 * 请求时的参数:
 *  1.  status  :
 *         1    :   发送注册短信
 *  2.  userPhone
 * @author DELL
 */
@WebServlet("/sms.do")
public class SmsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        //1.    接收请求中的参数  (手机号码 和 status)
        String status = request.getParameter("status");
        String userPhone = request.getParameter("userPhone");
        HttpSession session = request.getSession();
        //2.    发送短信
        int num = SendSms.random();
        Message msg = null;
        switch (status){
            case "1":{
                //发送注册短信
                boolean flag = SendSms.send(userPhone, num);
                if(flag){
                    //成功
                    msg = new Message(200,"短信发送成功");
                    session.setAttribute("smsPhone", userPhone);
                    session.setAttribute("smsCode","" + num);
                }else{
                    //失败
                    msg = new Message(-1,"短信发送失败,请检查手机号码");
                }
                break;
            }
        }
        response.getWriter().append(msg.toJson());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
