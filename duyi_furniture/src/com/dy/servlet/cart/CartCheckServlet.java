package com.dy.servlet.cart;

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

/**
 * @author DELL
 */
@WebServlet("/cartCheck.do")
public class CartCheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodsId = request.getParameter("goodsId");
        String isCheck = request.getParameter("isCheck");
        HttpSession session = request.getSession();
        BaseCarService service = null;
        if (session.getAttribute("user") == null){
            service = new SessionCartsService();
        }else {
            service = new SqlCartsService();
        }
        int i = 0;
        try {
            i = service.cartCheck(session, Integer.parseInt(goodsId), Integer.parseInt(isCheck));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Message message = new Message(i, "");
        response.getWriter().append(message.toJson());
    }
}
