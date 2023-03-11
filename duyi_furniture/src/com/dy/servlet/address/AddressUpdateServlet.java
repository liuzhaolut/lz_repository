package com.dy.servlet.address;

import com.dy.bean.Address;
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
@WebServlet("/addressUpdate.do")
public class AddressUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String userPhone = request.getParameter("userPhone");
        int code1 = Integer.parseInt(request.getParameter("code1"));
        int code2 = Integer.parseInt(request.getParameter("code2"));
        int code3 = Integer.parseInt(request.getParameter("code3"));
        int code4 = Integer.parseInt(request.getParameter("code4"));
        String userAddress = request.getParameter("userAddress");
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int userId = user.getId();
        AddressService service = new AddressServiceImpl();
        Address address = new Address(-1, userId, userName, userPhone, code1, code2, code3, code4, userAddress, 0, null);
        service.updateById(id, address);
        Message message = new Message("ok");
        response.getWriter().append(message.toJson());
    }
}
