package com.dy.daoimpl;

import com.dy.bean.Order;
import com.dy.bean.OrderGoods;
import com.dy.dao.OrderDao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL
 */
public class OrderDaoImpl extends BaseDaoImpl implements OrderDao {
    @Override
    public boolean insert(List<OrderGoods> orderGoods) {
        try {
            openDB();
            statement = connection.createStatement();
            for (int i = 0; i < orderGoods.size(); i++) {
                OrderGoods goods = orderGoods.get(i);
                statement.addBatch("INSERT INTO jj_order_goods(orderId, goodsId, goodsNum, goodsPrice, goodsName, goodsImg) VALUES (" + goods.getOrderId() + "," + goods.getGoodsId() + "," + goods.getGoodsNum() + "," + goods.getGoodsPrice() + ",'" + goods.getGoodsName() + "','" + goods.getGoodsImg() + "')");
            }
            statement.executeBatch();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return true;
    }

    @Override
    public List<OrderGoods> findByOrderId(int orderId) {
        List<OrderGoods> orderGoods = new ArrayList<>();
        try {
            openDB();
            String sql = "SELECT * FROM jj_order_goods WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int goodsId = resultSet.getInt("goodsId");
                int goodsNum = resultSet.getInt("goodsNum");
                double goodsPrice = resultSet.getDouble("goodsPrice");
                String goodsName = resultSet.getString("goodsName");
                String goodsImg = resultSet.getString("goodsImg");
                OrderGoods orderGoods1 = new OrderGoods(id, orderId, goodsId, goodsNum, goodsPrice, goodsName, goodsImg);
                orderGoods.add(orderGoods1);
            }
            return orderGoods;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return null;
    }

    @Override
    public int insert(Order order) {
        try {
            openDB();
            String sql = "INSERT INTO jj_orders(USERID, STATUS, MONEY, PAYMENTID, TRANSPORTID, ADDRESSID, ISAPPRAISE, CREATETIME) VALUES (?,0,?,?,?,?,0,Now())";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, order.getUserId());
            preparedStatement.setDouble(2, order.getMoney());
            preparedStatement.setInt(3, order.getPaymentId());
            preparedStatement.setInt(4, order.getTransportId());
            preparedStatement.setInt(5, order.getAddressId());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                return id;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return -1;
    }

    @Override
    public List<Order> findByUserId(int userId) {
        List<Order> orders = new ArrayList<>();
        try {
            openDB();
            String sql = "SELECT  * FROM jj_orders WHERE userId = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int status = resultSet.getInt("status");
                int paymentsId = resultSet.getInt("paymentId");
                int transportId = resultSet.getInt("transportId");
                int addressId = resultSet.getInt("addressId");
                int isAppraise = resultSet.getInt("isAppraise");
                String expressNo = resultSet.getString("expressNo");
                double money = resultSet.getDouble("money");
                Timestamp createTime = resultSet.getTimestamp("createTime");
                Order o = new Order(id, userId, status, money, paymentsId, transportId, addressId, isAppraise, expressNo,  createTime);
                orders.add(o);
            }
            return orders;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
      return null;
    }

    @Override
    public Order findById(int id) {
        Order order = null;
        try {
            openDB();
            String sql = "SELECT  * FROM jj_orders WHERE Id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int userId = resultSet.getInt("userId");
                int status = resultSet.getInt("status");
                int paymentsId = resultSet.getInt("paymentId");
                int transportId = resultSet.getInt("transportId");
                int addressId = resultSet.getInt("addressId");
                int isAppraise = resultSet.getInt("isAppraise");
                String expressNo = resultSet.getString("expressNo");
                double money = resultSet.getDouble("money");
                Timestamp createTime = resultSet.getTimestamp("createTime");
                order = new Order(id, userId, status, money, paymentsId, transportId, addressId, isAppraise, expressNo, createTime);
            }
            return order;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return null;
    }
}
