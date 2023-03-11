package com.dy.servlet.goods;

import com.dy.bean.GoodClass;
import com.dy.bean.Goods;
import com.dy.service.FindGoodsService;
import com.dy.service.GoodsClassService;
import com.dy.serviceimpl.FindGoodsServiceImpl;
import com.dy.serviceimpl.GoodsClassServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author DELL
 */
@WebServlet("/findGoods.do")
public class FindGoods extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FindGoodsService service = new FindGoodsServiceImpl();
        GoodsClassService service1 = new GoodsClassServiceImpl();
        String goodsId = request.getParameter("goodsId");
        int id = Integer.parseInt(goodsId);
        Goods goods = service.findGoodsById(id);
        GoodClass goodClass = service1.findGoodsById(id);
        if (goods != null) {
            GoodClass goodClass1 = service1.findGoodsById(goods.getClassid1());
            GoodClass goodClass2 = service1.findGoodsById(goods.getGetClassid2());
            request.setAttribute("goods", goods);
            request.setAttribute("class1", goodClass1);
            request.setAttribute("class2", goodClass2);
            request.getRequestDispatcher("proDetail.jsp").forward(request,response);
        }
    }
}
