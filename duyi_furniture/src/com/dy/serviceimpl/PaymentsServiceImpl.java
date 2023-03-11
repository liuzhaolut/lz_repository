package com.dy.serviceimpl;

import com.dy.bean.Payments;
import com.dy.dao.PaymentsDao;
import com.dy.daoimpl.BaseDaoImpl;
import com.dy.daoimpl.PaymentsDaoImpl;
import com.dy.service.PaymentsService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL
 */
public class PaymentsServiceImpl implements PaymentsService {
    private PaymentsDao dao = new PaymentsDaoImpl();
    @Override
    public List<Payments> findAll() throws ClassNotFoundException, SQLException, IOException, URISyntaxException {
      return dao.findAll();
    }

    @Override
    public Payments findById(int id) {
        return dao.findById(id);
    }
}
