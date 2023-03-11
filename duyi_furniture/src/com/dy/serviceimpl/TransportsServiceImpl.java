package com.dy.serviceimpl;

import com.dy.bean.Transports;
import com.dy.dao.TransportsDao;
import com.dy.daoimpl.BaseDaoImpl;
import com.dy.daoimpl.TransportsDaoImpl;
import com.dy.service.TransportsService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL
 */
public class TransportsServiceImpl implements TransportsService {
    private TransportsDao dao = new TransportsDaoImpl();
    @Override
    public List<Transports> findAll() {
        return dao.findAll();
    }

    @Override
    public Transports findById(int id) {
       return dao.findById(id);
    }
}
