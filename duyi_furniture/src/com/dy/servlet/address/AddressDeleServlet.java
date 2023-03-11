package com.dy.servlet.address;

import com.dy.bean.Message;
import com.dy.service.AddressService;
import com.dy.serviceimpl.AddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author DELL
 */
@WebServlet("/addressDele.do")
public class AddressDeleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        AddressService service = new AddressServiceImpl();
        boolean flag = service.deleteById(id);
        Message message = null;
        if (flag) {
            message = new Message(200,"删除成功");
        } else {
            message = new Message(-1,"删除失败");
        }
        response.getWriter().append(message.toJson());
    }
}
