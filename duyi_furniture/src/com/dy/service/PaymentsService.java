package com.dy.service;

import com.dy.bean.Payments;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author DELL
 */
public interface PaymentsService {
    /**
     * 查询所有支付方式
     * @return
     */
    List<Payments> findAll() throws ClassNotFoundException, SQLException, URISyntaxException, IOException;

    /**
     * 通过id支付方式
     * @param id
     * @return
     */
    Payments findById(int id);
}
