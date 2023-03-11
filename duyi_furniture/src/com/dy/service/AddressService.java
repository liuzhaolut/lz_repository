package com.dy.service;

import com.dy.bean.Address;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author DELL
 */
public interface AddressService {
    /**
     * 通过用户id获取地址
     * @param userId
     * @return
     */
    public List<Address> findByUserId(int userId) throws ClassNotFoundException, SQLException, URISyntaxException, IOException;

    /**
     * 通过id,查询某个收货地址
     * @param id
     * @return
     */
    public Address findById(int id);

    /**
     * 增加地址
     * @param address
     * @return
     */
    public boolean insert(Address address);

    /**
     * 修改地址信息
     * @param id
     * @param newAddress
     * @return
     */
    public boolean updateById(int id, Address newAddress);

    /**
     * 删除地址
     */
    public boolean deleteById(int id);

    /**
     * 修改默认地址
     * @param id
     * @return
     */
    public boolean updateDefaultById(int id, int userId);

    /**
     * 增加默认值
     * @param address
     * @param userId
     * @return
     */
    public boolean insertDefault(Address address, int userId);
}
