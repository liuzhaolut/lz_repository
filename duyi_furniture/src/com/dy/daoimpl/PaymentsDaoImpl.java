package com.dy.daoimpl;

import com.dy.bean.Payments;
import com.dy.dao.PaymentsDao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL
 */
public class PaymentsDaoImpl extends BaseDaoImpl implements PaymentsDao {
    @Override
    public List<Payments> findAll() {
        List<Payments> payments = new ArrayList<>();
        try {
            openDB();
            String sql = "SELECT * FROM jj_payments";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String img = resultSet.getString("img");
                Payments payments1 = new Payments(id, name, img);
                payments.add(payments1);
            }
            return payments;
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
    public Payments findById(int id) {
        Payments payments = new Payments();
        try {
            openDB();
            String sql = "SELECT * FROM jj_payments WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                String name = resultSet.getString("name");
                String img = resultSet.getString("img");
                payments.setImg(img);
                payments.setName(name);
            }
            return payments;
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
