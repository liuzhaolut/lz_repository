package com.dy.serviceimpl;

import com.dy.bean.Carts;
import com.dy.bean.Goods;
import com.dy.dao.FindGoodsDao;
import com.dy.daoimpl.FindGoodsDaoImpl;
import com.dy.service.FindGoodsService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author DELL
 */
public class FindGoodsServiceImpl implements FindGoodsService {
    private static FindGoodsDao dao = new FindGoodsDaoImpl();
    @Override
    public List<Goods> findAll(int orderBy) throws ClassNotFoundException, SQLException, URISyntaxException, IOException {
        return dao.findAll(orderBy);
    }

    @Override
    public List<Goods> findGoodsByClass1(int class1Id, int page, int size, int ordeBy) {
        return dao.findGoodsByClass1(class1Id, page, size, ordeBy);
    }

    @Override
    public List<Goods> findGoodsByClass2(int class2Id, int page, int size, int ordeBy) {
        return dao.findGoodsByClass2(class2Id, (page-1)*size, size, ordeBy);
    }

    @Override
    public List<Goods> findGoodsLikeName(String name, int page, int size, int ordeBy) {
        return dao.findGoodsLikeName(name, page, size, ordeBy);
    }

    @Override
    public Goods findGoodsById(int id) {
        return dao.findGoodsById(id);
    }


    @Override
    public List<Goods> findGoodsCart(List<Carts> carts) {
        return dao.findGoodsCart(carts);
    }
}
