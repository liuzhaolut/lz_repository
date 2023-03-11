package com.dy.servlet.order;

import com.dy.bean.*;
import com.dy.daoimpl.SqlCartsDaoImpl;
import com.dy.service.BaseCarService;
import com.dy.service.FindGoodsService;
import com.dy.service.OrderService;
import com.dy.serviceimpl.FindGoodsServiceImpl;
import com.dy.serviceimpl.OrderServiceImpl;
import com.dy.serviceimpl.SqlCartsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL
 */
@WebServlet("/buy.do")
public class BuyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String addressId = request.getParameter("addressId");
        String payId = request.getParameter("payId");
        String trId = request.getParameter("trId");
        String goodsId = request.getParameter("goodsId");
        String num = request.getParameter("goodsNum");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        Order order = new Order();
        order.setAddressId(Integer.parseInt(addressId));
        order.setPaymentId(Integer.parseInt(payId));
        order.setTransportId(Integer.parseInt(trId));
        order.setUserId(user.getId());

        List<OrderGoods> orderGoods =  new ArrayList<>();
        BaseCarService sqlCartsService = new SqlCartsService();
        FindGoodsService findGoodsService = new FindGoodsServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        if (goodsId == null){
//            查询选中购物车
            List<Carts> carts = sqlCartsService.findByUserId(session, 0);
//            删除购物车
            sqlCartsService.cartDelByCheck(session, 0);

            List<Goods> goods = findGoodsService.findGoodsCart(carts);
            ArrayList<Goods> gs2 = new ArrayList<>();
            for (int i = 0; i < carts.size(); i++) {
                Carts c = carts.get(i);
                for (int j = 0; j < goods.size(); j++) {
                    if (c.getGoodsId() == goods.get(j).getId()){
                        gs2.add(goods.get(j));
                        break;
                    }
                }
            }
            goods = gs2;
            double money = 0;
            for (int i = 0; i < carts.size(); i++) {
                money += carts.get(i).getCartNum() * goods.get(i).getPrice();
            }
            order.setMoney(money);
            int orderId = orderService.insert(order);
            for (int i = 0; i < carts.size(); i++) {
                OrderGoods order1 = new OrderGoods(-1, orderId, goods.get(i).getId(), carts.get(i).getCartNum(), goods.get(i).getPrice(), goods.get(i).getName(), goods.get(i).getImg().get(0));
                orderGoods.add(order1);
            }

        }else {
            List<Goods> goods = new ArrayList<>();
            Goods goods1 = findGoodsService.findGoodsById(Integer.parseInt(goodsId));
            goods.add(goods1);
            order.setMoney(goods1.getPrice() + Integer.parseInt(num));
            int orderId = orderService.insert(order);
            OrderGoods order1 = new OrderGoods(-1, orderId, Integer.parseInt(goodsId), Integer.parseInt(num), goods1.getPrice(), goods1.getName(), goods1.getImg().get(0));
            orderGoods.add(order1);
        }
        orderService.insert(orderGoods);
        response.sendRedirect("ok.jsp");
    }
}
