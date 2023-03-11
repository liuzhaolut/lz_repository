package com.etc.plant.service.impl;

import com.etc.plant.dao.AddressDao;
import com.etc.plant.entity.Address;
import com.etc.plant.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lz
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressDao dao;

    /**
     * 查找地址信息
     * @param user_id
     * @return
     */
    @Override
    public List<Address> findByUserId(int user_id) {
        return dao.findByUserId(user_id);
    }
}
