package com.dy.serviceimpl;

import com.dy.bean.Address;
import com.dy.dao.AddressDao;
import com.dy.daoimpl.AddressDaoImpl;
import com.dy.service.AddressService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author DELL
 */
public class AddressServiceImpl implements AddressService {
    private AddressDao dao = new AddressDaoImpl();

    @Override
    public List<Address> findByUserId(int userId) throws ClassNotFoundException, SQLException, URISyntaxException, IOException {
        return dao.findByUserId(userId);
    }

    @Override
    public Address findById(int id) {
        return dao.findById(id);
    }

    @Override
    public boolean insert(Address address) {
        return dao.insert(address);
    }

    @Override
    public boolean insertDefault(Address address, int userId){
        insert(address);
        return updateDefaultById(address.getId(), userId);
    }

    @Override
    public boolean updateById(int id, Address newAddress) {
        return dao.updateById(id, newAddress);
    }

    @Override
    public boolean deleteById(int id) {
        return dao.deleteById(id);
    }

    @Override
    public boolean updateDefaultById(int id, int userId) {
        return dao.updateDefaultById(id, userId);
    }
}
