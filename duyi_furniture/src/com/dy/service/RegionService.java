package com.dy.service;

import com.dy.bean.CnRegion;

import java.util.List;

/**
 * @author DELL
 */
public interface RegionService {
    /**
     * 根据级别查询
     * @param level
     * @return
     */
    List<CnRegion> findByLevel(int level);

    /**
     * 根据城市码查询信息
     * @param code
     * @return
     */
    CnRegion findByCode(String code);

    /**
     * 根据城市码，查询所有子城市
     * @param code
     * @return
     */
    List<CnRegion> findByParentCode(String code);
}
