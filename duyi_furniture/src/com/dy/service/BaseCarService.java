package com.dy.service;

import com.dy.bean.Carts;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author DELL
 */
public interface BaseCarService {
    /**
     * 添加商品
     * @param session
     * @param goodsId
     */
    void addCar(HttpSession session, int goodsId) throws ClassNotFoundException, SQLException, URISyntaxException, IOException;

    /**
     * 商品数量修改
     * @param session
     * @param goodsId
     * @param num
     */
    int updateCarNum(HttpSession session, int goodsId, int num) throws ClassNotFoundException, SQLException, IOException, URISyntaxException;

    /**
     * 选择购物车
     * @param session
     * @param goodsId
     * @param isCheck
     * @return
     */
    int cartCheck(HttpSession session, int goodsId, int isCheck) throws ClassNotFoundException, SQLException, IOException, URISyntaxException;

    /**
     * 删除购物车商品
     * @param session
     * @param goodsId
     * @return
     */
    int cartDel(HttpSession session, int goodsId) throws ClassNotFoundException, SQLException, IOException, URISyntaxException;
    /**
     * 查询
     * @param isCheck
     * @return
     */
    List<Carts> findByUserId(HttpSession session, int isCheck);
    /**
     * 购物车中删除商品
     * @return
     */
    int cartDelByCheck(HttpSession session, int isCheck) ;
}
