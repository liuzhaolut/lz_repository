package com.dy.test;

import com.dy.bean.Address;
import com.dy.bean.Carts;
import com.dy.bean.Goods;
import com.dy.dao.*;
import com.dy.daoimpl.AddressDaoImpl;
import com.dy.daoimpl.FindGoodsDaoImpl;
import com.dy.daoimpl.GoodsClassDaoImpl;
import com.dy.daoimpl.SqlCartsDaoImpl;
import com.dy.servlet.goods.FindGoods;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL
 */
public class GoodsTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, URISyntaxException {
//        GoodsClassDao dao = new GoodsClassDaoImpl();
//        List<GoodClass> goodClasses = dao.findAll();
//        for (GoodClass g: goodClasses
//             ) {
//            System.out.println(g.toString());
//        }
//        FindGoodsDao findGoods = new FindGoodsDaoImpl();
//        List<Goods> goods = findGoods.findAll();
//        List<Goods> goods = findGoods.findGoodsByClass1(1,10,10,0);
//        List<Goods> goods = findGoods.findGoodsByClass2(101,1,10,0);
//        List<Goods> goods = findGoods.findGoodsLikeName("茶几",1,10,0);
////        Goods goods = findGoods.findGoodsById(161);
//        System.out.println(goods);
//        List<Carts> carts = new ArrayList<>();
//        Carts carts1 = new Carts();
//        carts1.setGoodsId(1);
//
//        Carts carts2 = new Carts();
//        carts2.setGoodsId(2);
//        carts.add(carts2);
//        FindGoodsDao dao1 = new FindGoodsDaoImpl();
//        List<Goods> data = dao1.findGoodsCart(carts);
//        System.out.println(data);
//        SqlCartDao dao = new SqlCartsDaoImpl();
////        dao.addCar(2,1);
////        dao.updateCartNum(2,1,-1);
//        dao.cartCheck(2,1,1);
        AddressDao dao = new AddressDaoImpl();
//        List<Address> addresses = dao.findByUserId(2);
//        Address addresses = dao.findById(1);
//        Address addresses = new Address(-1,-1,"xc","4567998256",110000,110100,110101,110101001,"嘻嘻嘻嘻",0,null);
        boolean flag  = dao.deleteById(3);
        System.out.println(flag);
    }
}
