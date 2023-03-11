package com.dy.serviceimpl;

import com.dy.bean.CnRegion;
import com.dy.dao.RegionDao;
import com.dy.daoimpl.RegionDaoImpl;
import com.dy.service.RegionService;
import com.dy.util.DataUtil;

import java.util.List;

/**
 * @author DELL
 */
public class RegionServiceImpl implements RegionService {
    private RegionDao dao = new RegionDaoImpl();
    @Override
    public List<CnRegion> findByLevel(int level) {
        if (level == 1){
            List<CnRegion> city = (List<CnRegion>) DataUtil.data.get("city");
            if (city == null){
                city = dao.findByLevel(level);
                DataUtil.data.put("citys", city);
            }
            return city;
        }
        return dao.findByLevel(level);
    }

    @Override
    public CnRegion findByCode(String code) {
        return dao.findByCode(code);
    }

    @Override
    public List<CnRegion> findByParentCode(String code) {
        return dao.findByParentCode(code);
    }
}
