package com.dy.test;

import com.dy.bean.CnRegion;
import com.dy.dao.RegionDao;
import com.dy.daoimpl.RegionDaoImpl;

import java.util.List;

/**
 * @author DELL
 */
public class RegionTest {
    public static void main(String[] args) {
        RegionDao dao = new RegionDaoImpl();
//        List<CnRegion> cnRegions = dao.findByLevel(1);
//        List<CnRegion> cnRegions = dao.findByParentCode("610100");
        CnRegion cnRegions = dao.findByCode("");
        System.out.println(cnRegions);
    }
}
