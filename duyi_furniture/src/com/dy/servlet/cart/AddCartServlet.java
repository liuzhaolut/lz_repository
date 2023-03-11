package com.dy.servlet.cart;

import com.dy.bean.Carts;
import com.dy.bean.Message;
import com.dy.bean.User;
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
@WebServlet("/addGoodsCar.do")
public class AddCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("goodsId");
        HttpSession session = request.getSession();
        BaseCarService baseCarService = null;

        if(session.getAttribute("user") == null){
            baseCarService = new SessionCartsService();
        } else {
            baseCarService = new SqlCartsService();
        }
        try {
            baseCarService.addCar(session, Integer.parseInt(id));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Message msg = new Message(200,"购物车加入成功");
        response.getWriter().append(msg.toJson());

    }
}
