package com.dy.servlet.address;

import com.dy.bean.Message;
import com.dy.bean.User;
import com.dy.service.AddressService;
import com.dy.serviceimpl.AddressServiceImpl;

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
@WebServlet("/addressDefault.do")
public class DefaultServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userId = user.getId();
        AddressService service = new AddressServiceImpl();
        boolean flag = service.updateDefaultById(id, userId);
        Message message = null;
        if (flag) {
            message = new Message(200,"设置成功");
        } else {
            message = new Message(-1,"设置失败");
        }
        response.getWriter().append(message.toJson());
    }
}
