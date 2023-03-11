package com.dy.daoimpl;

import com.dy.bean.Address;
import com.dy.dao.AddressDao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL
 */
public class AddressDaoImpl extends BaseDaoImpl implements AddressDao {
    @Override
    public List<Address> findByUserId(int userId) {
        List<Address> addresses = new ArrayList<>();
        try {
            openDB();
            String sql = "SELECT * FROM jj_address WHERE userId = ? ORDER BY ISDEFAULT DESC";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Address address = new Address();
                address.setId(resultSet.getInt("id"));
                address.setUserName(resultSet.getString("userName"));
                address.setUserPhone(resultSet.getString("userPhone"));
                address.setProvinceId(resultSet.getInt("provinceId"));
                address.setCityId(resultSet.getInt("cityId"));
                address.setAreaId(resultSet.getInt("areaId"));
                address.setStreetId(resultSet.getInt("streetId"));
                address.setUserAddress(resultSet.getString("userAddress"));
                address.setIsDefault(resultSet.getInt("isDefault"));
                address.setCreateTime(resultSet.getTimestamp("createTime"));
                addresses.add(address);
            }
            return addresses;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return null;
    }

    @Override
    public Address findById(int id) {
        Address address = null;
        try {
            openDB();
            String sql = "SELECT * FROM jj_address WHERE Id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                address = new Address();
                address.setUserId(resultSet.getInt("userId"));
                address.setUserName(resultSet.getString("userName"));
                address.setUserPhone(resultSet.getString("userPhone"));
                address.setProvinceId(resultSet.getInt("provinceId"));
                address.setCityId(resultSet.getInt("cityId"));
                address.setAreaId(resultSet.getInt("areaId"));
                address.setStreetId(resultSet.getInt("streetId"));
                address.setUserAddress(resultSet.getString("userAddress"));
                address.setIsDefault(resultSet.getInt("isDefault"));
                address.setCreateTime(resultSet.getTimestamp("createTime"));
            }
            return address;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return null;
    }

    @Override
    public boolean insert(Address address) {
        try {
            openDB();
            String sql = "INSERT INTO jj_address(USERID, USERNAME, USERPHONE, PROVINCEID, CITYID, AREAID, STREETID, USERADDRESS, ISDEFAULT, CREATETIME)  VALUES (?,?,?,?,?,?,?,?,?,Now())";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, address.getUserId());
            preparedStatement.setString(2, address.getUserName());
            preparedStatement.setString(3, address.getUserPhone());
            preparedStatement.setInt(4, address.getProvinceId());
            preparedStatement.setInt(5, address.getCityId());
            preparedStatement.setInt(6, address.getAreaId());
            preparedStatement.setInt(7, address.getStreetId());
            preparedStatement.setString(8, address.getUserAddress());
            preparedStatement.setInt(9, address.getIsDefault());
//            preparedStatement.setTimestamp(10,  address.getCreateTime());
            preparedStatement.executeUpdate();
//            作用：用于获取最新插入的自增的字段值
            ResultSet result = preparedStatement.getGeneratedKeys();
//            select last_insert_id();:基于连接
//            select @@IDENTITY:基于全局
            if (result.next()) {
                int id = result.getInt(1);
                address.setId(id);
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return false;
    }

    @Override
    public boolean updateById(int id, Address address) {
        try {
            openDB();
            String sql = "UPDATE jj_address SET USERNAME = ?, USERPHONE = ?, PROVINCEID =?, CITYID = ?, AREAID = ?, STREETID = ?, USERADDRESS = ? WHERE Id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, address.getUserName());
            preparedStatement.setString(2, address.getUserPhone());
            preparedStatement.setInt(3, address.getProvinceId());
            preparedStatement.setInt(4, address.getCityId());
            preparedStatement.setInt(5, address.getAreaId());
            preparedStatement.setInt(6, address.getStreetId());
            preparedStatement.setString(7, address.getUserAddress());
            preparedStatement.setInt(8, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        try {
            openDB();
            String sql = "DELETE FROM jj_address WHERE Id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateDefaultById(int id, int userId) {
        try {
            openDB();
            statement = connection.createStatement();
            statement.addBatch( "UPDATE jj_address SET isDefault = 0 WHERE userId = "+ userId);
            statement.addBatch("UPDATE jj_address SET isDefault = 1 WHERE Id = "+ id);
            statement.executeBatch();
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return false;
    }
}
