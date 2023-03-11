package com.dy.daoimpl;

import com.dy.bean.CnRegion;
import com.dy.dao.RegionDao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL
 */
public class RegionDaoImpl extends BaseDaoImpl implements RegionDao {
    @Override
    public List<CnRegion> findByLevel(int level) {
        List<CnRegion> cnRegions = new ArrayList<>();
        try {
            openDB();
            String sql = "SELECT * FROM cn_region WHERE LEVEL = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, level);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                CnRegion cnRegion = new CnRegion();
                int id = resultSet.getInt("id");
                String code = resultSet.getString("code");
                String name = resultSet.getString("name");
                cnRegion.setName(name);
                cnRegion.setId(id);
                cnRegion.setCode(code);
                cnRegions.add(cnRegion);
            }
            return cnRegions;
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
    public CnRegion findByCode(String code) {
        CnRegion cnRegion = null;
        try {
            openDB();
            String sql = "SELECT * FROM cn_region WHERE CODE = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, code);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String superior_code = resultSet.getString("superior_code");
                String name = resultSet.getString("name");
                String lng = resultSet.getString("lng");
                String lat = resultSet.getString("lat");
                int level = resultSet.getInt("level");
                cnRegion = new CnRegion(id, name, superior_code, lng,lat,level);
            }
            return cnRegion;
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
    public List<CnRegion> findByParentCode(String code) {
        List<CnRegion> cnRegions = new ArrayList<>();
        try {
            openDB();
            String sql = "SELECT * FROM cn_region WHERE SUPERIOR_CODE = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, code);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String c = resultSet.getString("code");
                String superior_code = resultSet.getString("superior_code");
                String name = resultSet.getString("name");
                CnRegion cnRegion = new CnRegion();
                cnRegion.setParentCode(superior_code);
                cnRegion.setId(id);
                cnRegion.setName(name);
                cnRegion.setCode(c);
                cnRegions.add(cnRegion);
            }
            return cnRegions;
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
}
