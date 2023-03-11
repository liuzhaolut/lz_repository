package com.dy.service;

import com.dy.bean.Order;
import com.dy.bean.OrderGoods;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author DELL
 */
public interface OrderService {
    /**
     * 插入订单中的所有商品
     * @param orderGoods
     * @return
     */
    public boolean insert(List<OrderGoods> orderGoods);

    /**
     * 根据订单id，查询商品
     * @return
     */
    public List<OrderGoods> findByOrderId(int orderId);

    /**
     * 插入订单
     * @param order
     * @return
     */
    int insert(Order order);

    /**
     * 根据用户id，查询所有订单
     * @return
     */
    List<Order> findByUserId(int userId) throws ClassNotFoundException, SQLException, URISyntaxException, IOException;

    /**
     * 通过id，查询单个订单
     * @return
     */
    Order findById(int id);
}
