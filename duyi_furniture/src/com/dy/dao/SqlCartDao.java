package com.dy.dao;

import com.dy.bean.Carts;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author DELL
 */
public interface SqlCartDao {
    /**
     * 添加购物车
     * @param userId
     * @param gooosId
     */
    void addCar(int userId, int gooosId) throws ClassNotFoundException, SQLException, IOException, URISyntaxException;

    /**
     * 修改购物车数量
     * @param userId
     * @param goodsId
     * @param num
     * @return
     */
    int updateCartNum(int userId, int goodsId, int num) throws ClassNotFoundException, SQLException, URISyntaxException, IOException;

    /**
     * 修改选中状态
     * @param userId
     * @param goodsId
     * @param isCheck
     * @return
     */
    int cartCheck(int userId, int goodsId, int isCheck) throws ClassNotFoundException, SQLException, URISyntaxException, IOException;

    /**
     * 购物车中删除商品
     * @param userId
     * @param goodsId
     * @return
     */
    int cartDel(int userId, int goodsId) throws ClassNotFoundException, SQLException, URISyntaxException, IOException;

    /**
     * 查询购物车信息
     * @param userId
     * @return
     */
    List<Carts> findByUserId(int userId);

    /**
     * 用于插入数据库，插入session中的购物车数据
     * @param userId
     * @param data
     * @return
     */
    int insertSessionCarts(int userId, List<Carts> data);

    /**
     * 查询
     * @param userId
     * @param isCheck
     * @return
     */
    List<Carts> findByUserId(int userId, int isCheck);
    /**
     * 购物车中删除商品
     * @param userId
     * @return
     */
    int cartDelByCheck(int userId, int isCheck) ;

}
