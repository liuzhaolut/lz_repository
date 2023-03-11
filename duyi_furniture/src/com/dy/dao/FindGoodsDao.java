package com.dy.dao;

import com.dy.bean.Carts;
import com.dy.bean.Goods;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author DELL
 */
public interface FindGoodsDao {
    List<Goods> findGoodsCart(List<Carts> carts);
    /**
     * 查询所有
     * @return
     */
    List<Goods> findAll(int orderBy) throws ClassNotFoundException, SQLException, URISyntaxException, IOException;

    /**
     * 查询一级分类
     * @param class1Id
     * @param page
     * @param size
     * @return
     */
    List<Goods> findGoodsByClass1(int class1Id, int page, int size, int ordeBy);
    /**
     * 查询二级分类
     * @param class2Id
     * @param page
     * @param size
     * @return
     */
    List<Goods> findGoodsByClass2(int class2Id, int page, int size, int ordeBy);

    /**
     * 根据用户输入商品名称模糊查询
     * @param name
     * @param page
     * @param size
     * @return
     */
    List<Goods> findGoodsLikeName(String name, int page , int size, int ordeBy);

    /**
     * 查询商品id
     * @param id
     * @return
     */
    Goods findGoodsById(int id);
}
