package com.etc.plant.service;

import com.etc.plant.entity.Region;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 地址级联服务层
 * @author lz
 */
@Repository
public interface RegionService {
    /**
     * 根据级别查询
     * @param level
     * @return
     */
    List<Region> findByLevel(int level);

    /**
     * 根据城市码查询信息
     * @param code
     * @return
     */
    Region findByCode(String code);

    /**
     * 根据城市码，查询所有子城市
     * @param code
     * @return
     */
    List<Region> findByParentCode(String code);
}
