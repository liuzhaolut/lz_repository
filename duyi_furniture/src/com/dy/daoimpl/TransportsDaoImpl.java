package com.dy.daoimpl;

import com.dy.bean.Payments;
import com.dy.bean.Transports;
import com.dy.dao.TransportsDao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL
 */
public class TransportsDaoImpl extends BaseDaoImpl implements TransportsDao {
    @Override
    public List<Transports> findAll() {
        List<Transports> transports = new ArrayList<>();
        try {
            openDB();
            String sql = "SELECT * FROM jj_transports";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Transports transports1 = new Transports(id, name);
                transports.add(transports1);
            }
            return transports;
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
    public Transports findById(int id) {
        Transports transports = new Transports();
        try {
            openDB();
            String sql = "SELECT * FROM jj_transports WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String name = resultSet.getString("name");
                transports.setName(name);
            }
            return transports;
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
