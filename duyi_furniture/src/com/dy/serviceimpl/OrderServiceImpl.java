package com.dy.serviceimpl;

import com.dy.bean.Order;
import com.dy.bean.OrderGoods;
import com.dy.dao.OrderDao;
import com.dy.daoimpl.OrderDaoImpl;
import com.dy.service.OrderService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author DELL
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao dao = new OrderDaoImpl();
    @Override
    public boolean insert(List<OrderGoods> orderGoods) {
        return dao.insert(orderGoods);
    }

    @Override
    public List<OrderGoods> findByOrderId(int orderId) {
        return dao.findByOrderId(orderId);
    }

    @Override
    public int insert(Order order) {
        return dao.insert(order);
    }

    @Override
    public List<Order> findByUserId(int userId) throws ClassNotFoundException, SQLException, URISyntaxException, IOException {
        return dao.findByUserId(userId);
    }

    @Override
    public Order findById(int id) {
        return dao.findById(id);
    }
}
