package com.dy.dao;

import com.dy.bean.GoodClass;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author DELL
 */
public interface GoodsClassDao {
    /**
     * 查询所有分类
     * @return
     */
    List<GoodClass> findAll() throws ClassNotFoundException, SQLException, URISyntaxException, IOException;

    /**
     * 获取商品分类
     * @param id
     * @return
     */
    GoodClass findGoodsById(int id) throws ClassNotFoundException, SQLException, URISyntaxException, IOException;
}
