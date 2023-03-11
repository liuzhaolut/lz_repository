package com.etc.plant.service.impl;

import com.etc.plant.dao.CartDao;
import com.etc.plant.entity.*;
import com.etc.plant.service.CartService;
import com.etc.plant.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author lz
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartDao dao;

    /**
     * 添加收藏夹
     * @param user
     * @param pid
     * @param colour
     * @param size
     * @return
     */
    @Override
    public int addCollection(User user, int pid, String colour, String size) {
        int no = 0;
        int uid = user.getUser_id();
        Collection collection = dao.judgeColl(uid,pid);
        try{
            if (collection != null) {
                no = -1;
            } else {
                no = dao.addCollection(uid, pid, colour, size);
            }
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("收藏夹..." + e.getMessage());
        }
        return no;
    }

    /**
     * 获取收藏夹
     * @param user
     * @return
     */
    @Override
    public List<Collection> getCollection(User user) {
        int uid = user.getUser_id();
        List<Collection> collection = null;
        try{
            collection = dao.getCollection(uid);
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("收藏夹..." + e.getMessage());
        }
        return collection;
    }

    /**
     * 通过id获取商品
     * @param pid
     * @return
     */
    @Override
    public Plants getUserPlant(int pid) {
        Plants plants = null;
        try{
            plants = dao.getUserPlant(pid);
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("收藏夹..." + e.getMessage());
        }
        return plants;
    }

    /**
     * 通过id获取购物车
     * @param user
     * @return
     */
    @Override
    public List<Carts> getShopCar(User user) {
        int uid = user.getUser_id();
        List<Carts> carts = null;
        try{
            carts = dao.getShopCar(uid);
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("收藏夹..." + e.getMessage());
        }
        return carts;
    }

    /**
     * 添加购物车
     * @param user
     * @param pid
     * @param colour
     * @param size
     * @return
     */
    @Override
    public int addShopCar(User user, int pid, String colour, String size) {
        int no = 0;
        int uid = user.getUser_id();
        Carts carts = dao.judgeCart(uid, pid);
        try {
            if (carts != null) {
                int n = dao.updateNum(uid, pid);
                if (n > 0){
                    no = -1;
                }
            } else {
                no = dao.addCart(uid, pid, colour, size);
                System.out.println(no + "====no");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug("收藏夹..." + e.getMessage());
        }
        return no;
    }

    /**
     * 修改购物车数量
     * @param uid
     * @param parseInt
     * @param parseInt1
     */
    @Override
    public void updateCarNum(int uid, int parseInt, int parseInt1) {
        dao.updateCartNum(uid, parseInt, parseInt1);
    }

    /**
     * 判断是否选中
     * @param uid
     * @param pid
     * @param isCheck
     * @return
     */
    @Override
    public int cartCheck(int uid, int pid, int isCheck) {
        int no =  dao.cartCheck(uid, pid, isCheck);
        return no;
    }

    /**
     * 通过id获取收藏夹信息
     * @param cid
     * @return
     */
    @Override
    public List<Collection> getCollectionById(int cid) {
        List<Collection> collection = null;
        try{
            collection = dao.getCollectionById(cid);
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("收藏夹..." + e.getMessage());
        }
        return collection;
    }

    /**
     * 删除收藏夹
     * @param cid
     */
    @Override
    public void deleteColl(int cid) {
        try{
            dao.deleteColl(cid);
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("收藏夹..." + e.getMessage());
        }
    }

    /**
     * 通过id获取购物车信息
     * @param cid
     * @return
     */
    @Override
    public List<Carts> getCartById(int cid) {
        List<Carts> carts = null;
        try{
            carts = dao.getCartById(cid);
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("收藏夹..." + e.getMessage());
        }
        return carts;
    }

    /**
     * 多条件获取购物车信息
     * @param uid
     * @param pid
     * @return
     */
    @Override
    public Carts getCartByMore(int uid, int pid) {
        Carts carts = null;
        try{
            carts = dao.getCartByMore(uid, pid);
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("收藏夹..." + e.getMessage());
        }
        return carts;
    }

    /**
     * 删除购物车信息
     * @param cid
     * @return
     */
    @Override
    public int deleteCar(int cid) {
        int no = 0;
        Carts carts = dao.judgeCartById(cid);
        try{
            if (carts != null) {
                no = dao.deleteCar(cid);
            } else {
                no = -1;
            }
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("购物车..." + e.getMessage());
        }
        return no;
    }

    /**
     * 支付操作
     * @param countMap
     * @param sumMap
     * @param ids
     * @param order
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void pay(Map<String, Integer> countMap, Map<String, Double> sumMap, String[] ids, Order order) {
        int uid = order.getUserId();
        int cardId = order.getPaymentId();
        double sum = order.getMoney();
        try {
//            修改账户余额
            dao.updateCount(sum, cardId);
//            添加订单信息
            dao.addOrder(order);
            for (String id:ids
                 ) {
                int pid = Integer.parseInt(id);
                int count = countMap.get(id);
                double sumi = sumMap.get(id);
//                修改植物数量
                dao.updatePidCount(pid, count);
//                清理购物车
                dao.removeCar(uid, pid);
                int oid = dao.getOid(order);
                Plants plants = dao.getUserPlant(pid);
                OrderInfo orderInfo = new OrderInfo(oid, pid, count, sumi, plants.getPlant_name(), plants.getPic());
//                添加订单详情
                dao.addOrderInfo(orderInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug(e.getMessage() + "购物车...");
        }
    }

    /**
     * 获取购物车
     * @param uid
     * @param card
     * @return
     */
    @Override
    public int getCardId(int uid, String card) {
        int no = 0;
        Card card1 = dao.judgeCard(uid, card);
        try{
            if (card1 != null) {
                no = dao.getCardId(card);
            } else {
                no = -1;
            }
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("购物车..." + e.getMessage());
        }
        return no;
    }

    /**
     * 获取地址id
     * @param uid
     * @param add
     * @return
     */
    @Override
    public int getAddressId(int uid, String add) {
        int no = 0;
        try{
            no = dao.getAddressId(uid, add);
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("购物车..." + e.getMessage());
        }
        return no;
    }

    /**
     * 添加地址信息
     * @param address
     */
    @Override
    public void addAddress(Address address) {
        dao.addAddress(address);
    }

    /**
     * 获取全部购物车
     * @return
     */
    @Override
    public List<Carts> getCart() {
        return dao.getCart();
    }
}
