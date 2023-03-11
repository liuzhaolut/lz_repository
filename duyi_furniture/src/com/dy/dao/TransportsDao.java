package com.dy.dao;

import com.dy.bean.Transports;

import java.util.List;

/**
 * @author DELL
 */
public interface TransportsDao {
    /**
     * 查询所有运送方式
     * @return
     */
    List<Transports> findAll();

    /**
     * 通过id查询方式
     * @param id
     * @return
     */
    Transports findById(int id);
}
