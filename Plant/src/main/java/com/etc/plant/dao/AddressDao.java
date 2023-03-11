package com.etc.plant.dao;

import com.etc.plant.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 地址持久层
 * @author lz
 */
public interface AddressDao {
    /**
     * 通过id获取地址
     * @param user_id
     * @return
     */
    public List<Address> findByUserId(@Param("uid") int user_id);
}
