package com.dy.service;

import com.dy.bean.GoodClass;
import com.dy.bean.Goods;

import java.util.List;

/**
 * @author DELL
 */
public interface GoodsClassService {
    /***
     * 查询标题
     * @return
     */
    public List<GoodClass> findAll();

    /**
     * 查询商品分类
     * @param id
     * @return
     */
    public GoodClass findGoodsById(int id);
}
