package com.etc.plant.service;

import com.etc.plant.entity.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 购物车服务层
 * @author lz
 */
@Repository
public interface CartService {
    /**
     * 添加到收藏夹
     * @param user
     * @param pid
     * @param colour
     * @param size
     * @return
     */
    public int addCollection(User user, int pid, String colour, String size);

    /**
     * 获取收藏夹信息
     * @param user
     * @return
     */
    public List<Collection> getCollection(User user);

    /**
     * 获取收藏夹植物的信息
     * @param pid
     * @return
     */
    public Plants getUserPlant(int pid);

    /**
     * 获取购物车信息
     * @param user
     * @return
     */
    public List<Carts> getShopCar(User user);

    /**
     * 添加购物车
     * @param user
     * @param pid
     * @param colour
     * @param size
     * @return
     */
    public int addShopCar(User user, int pid, String colour, String size);

    /**
     * 修改购物车个数
     * @param uid
     * @param parseInt
     * @param parseInt1
     */
    public void updateCarNum(int uid, int parseInt, int parseInt1);

    /**
     *
     * @param uid
     * @param parseInt
     * @param parseInt1
     * @return
     */
    public int cartCheck(int uid, int parseInt, int parseInt1);

    /**
     * 获取收藏夹
     * @param cid
     * @return
     */
    public List<Collection> getCollectionById(int cid);

    /**
     * 删除收藏夹
     * @param cid
     */
    public void deleteColl(int cid);

    /**
     * 获取支付购物车信息
     * @param parseInt
     * @return
     */
    public List<Carts> getCartById(int parseInt);

    /**
     * 获取购物车
     * @param uid
     * @param parseInt
     * @return
     */
    public Carts getCartByMore(int uid, int parseInt);

    /**
     * 删除购物车信息
     * @return
     */
    public int deleteCar(int cid);

    /**
     * 支付
     * @param countMap
     * @param sumMap
     * @param ids
     * @param order
     */
    public void pay(Map<String, Integer> countMap, Map<String, Double> sumMap, String[] ids, Order order);

    /**
     * 获取卡id
     * @param card
     * @return
     */
    public int getCardId(int uid, String card);

    /**
     * 地址id
     * @param uid
     * @param add
     * @return
     */
    public int getAddressId(int uid, String add);

    /**
     * 添加地址
     * @param address
     */
    public void addAddress(Address address);

    /**
     * 获取购物车
     * @return
     */
    public List<Carts> getCart();
}
