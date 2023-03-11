package com.etc.plant.service.impl;



import com.etc.plant.dao.RegionDao;
import com.etc.plant.entity.Region;
import com.etc.plant.service.RegionService;
import com.etc.plant.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lz
 */
@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    RegionDao dao;

    /**
     * 通过条件查询地址信息
     * @param level
     * @return
     */
    @Override
    public List<Region> findByLevel(int level) {
        if (level == 1){
            List<Region> city = (List<Region>) DataUtil.data.get("city");
            if (city == null){
                city = dao.findByLevel(level);
                DataUtil.data.put("citys", city);
            }
            return city;
        }
        return dao.findByLevel(level);
    }

    /**
     * 通过code查找地址信息
     * @param code
     * @return
     */
    @Override
    public Region findByCode(String code) {
        return dao.findByCode(code);
    }

    /**
     * 通过父code查找地址信息
     * @param code
     * @return
     */
    @Override
    public List<Region> findByParentCode(String code) {
        return dao.findByParentCode(code);
    }
}
