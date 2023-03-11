package com.etc.plant.dao;

import com.etc.plant.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 购物车持久层
 * @author lz
 */
public interface CartDao {
    /**
     * 判断收藏夹
     * @param uid
     * @param pid
     * @return
     */
    public Collection judgeColl(@Param("uid") int uid, @Param("pid") int pid);

    /**
     * 添加到收藏夹
     * @param uid
     * @param pid
     * @param colour
     * @param size
     * @return
     */
    public int addCollection(@Param("uid") int uid, @Param("pid") int pid, @Param("colour") String colour, @Param("size") String size);

    /**
     * 获取收藏夹
     * @param uid
     * @return
     */
    public List<Collection> getCollection(@Param("uid") int uid);

    /**
     * 获取收藏夹花的信息
     * @param pid
     * @return
     */
    public Plants getUserPlant(@Param("pid") int pid);


    /**
     * 获取购物车
     * @param uid
     * @return
     */
    public List<Carts> getShopCar(@Param("uid") int uid);

    /**
     * 判断购物车
     * @param uid
     * @param pid
     * @return
     */
    public Carts judgeCart(@Param("uid") int uid, @Param("pid") int pid);

    /**
     * 添加购物车
     * @param uid
     * @param pid
     * @param colour
     * @param size
     * @return
     */
    public int addCart(@Param("uid") int uid, @Param("pid") int pid, @Param("colour") String colour, @Param("size") String size);

    /**
     * 修改数量
     * @param uid
     * @param pid
     */
    public int updateNum(@Param("uid") int uid, @Param("pid") int pid);

    /**
     * 修改数量
     * @param uid
     * @param parseInt
     * @param parseInt1
     * @return
     */
    public int updateCartNum(@Param("uid") int uid, @Param("pid") int parseInt, @Param("type") int parseInt1);

    /**
     * 是否选中
     * @param uid
     * @param pid
     * @param isCheck
     * @return
     */
    public int cartCheck(@Param("uid") int uid, @Param("pid") int pid, @Param("isCheck") int isCheck);

    /**
     * 获取收藏夹
     * @param cid
     * @return
     */
    public List<Collection> getCollectionById(@Param("cid") int cid);

    /**
     * 删除收藏夹
     * @param cid
     */
    public void deleteColl(@Param("cid") int cid);

    /**
     * 通过id获取购物车
     * @param cid
     * @return
     */
    public List<Carts> getCartById(@Param("cid") int cid);

    /**
     * 获取购物车
     * @param uid
     * @param pid
     * @return
     */
    public Carts getCartByMore(@Param("uid")int uid, @Param("pid") int pid);

    /**
     * 删除购物车
     * @param cid
     * @return
     */
    public int deleteCar(@Param("cid") int cid);

    /**
     * 判断购物车
     * @param cid
     * @return
     */
    public Carts judgeCartById(@Param("cid") int cid);

    /**
     * 判断有无此卡
     * @param card
     * @return
     */
    public Card judgeCard(@Param("uid") int uid, @Param("card") String card);

    /**
     * 获取卡id
     * @param card
     * @return
     */
    public int getCardId(@Param("card")String card);

    /**
     * 获取地址id
     * @param add
     * @return
     */
    public int getAddressId(@Param("uid") int uid, @Param("add") String add);

    /**
     * 添加地址
     * @param address
     */
    public void addAddress(Address address);

    /**
     * 修改余额
     * @param sum
     * @param cardId
     */
    public void updateCount(@Param("sum") double sum, @Param("cardId") int cardId);

    /**
     * 修改植物数量
     * @param id
     * @param count
     */
    public void updatePidCount(@Param("pid") int id, @Param("count") int count);

    /**
     * 清理购物车
     * @param uid
     * @param id
     */
    public void removeCar(@Param("uid") int uid, @Param("pid") int id);

    /**
     * 添加订单
     * @param order
     */
    public void addOrder(Order order);

    /**
     * 获取订单id
     * @param order
     * @return
     */
    public int getOid(Order order);

    /**
     * 添加订单详情
     * @param orderInfo
     */
    public void addOrderInfo(OrderInfo orderInfo);

    /**
     * 获取购物车
     * @return
     */
    public List<Carts> getCart();
}
