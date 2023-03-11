package com.etc.plant.service;

import com.etc.plant.entity.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 地址服务层
 * @author lz
 */
@Repository
public interface AddressService {
    /**
     * 通过用户id获取地址
     * @param user_id
     * @return
     */
    public List<Address> findByUserId(int user_id);
}
