package com.dy.servlet.cart;

import com.dy.bean.Carts;
import com.dy.bean.Message;
import com.dy.service.BaseCarService;
import com.dy.serviceimpl.SessionCartsService;
import com.dy.serviceimpl.SqlCartsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author DELL
 */
@WebServlet("/cartNumUpdate.do")
public class CartNumUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodsId = request.getParameter("goodsId");
        String num = request.getParameter("num");
        BaseCarService service = null;
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null){
            service = new SessionCartsService();
        } else {
            service = new SqlCartsService();
        }
        try {
            service.updateCarNum(session, Integer.parseInt(goodsId), Integer.parseInt(num));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Message message = new Message(200, "购物车加入成功");
        response.getWriter().append(message.toJson());
    }
}
