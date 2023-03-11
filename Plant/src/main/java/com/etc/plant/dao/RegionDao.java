package com.etc.plant.dao;

import com.etc.plant.entity.Region;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 地址级联持久层
 * @author lz
 */
public interface RegionDao {
    /**
     * 根据级别查询
     * @param level
     * @return
     */
    public List<Region> findByLevel(@Param("level") int level);

    /**
     * 根据城市码查询信息
     * @param code
     * @return
     */
    public Region findByCode(@Param("code") String code);

    /**
     * 根据城市码，查询所有子城市
     * @param code
     * @return
     */
    public List<Region> findByParentCode(@Param("code") String code);
}
