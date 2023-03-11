package com.etc.plant.dao;

import com.etc.plant.entity.Plants;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品持久层
 * @author lz
 */
public interface PlantDao {
    /**
     * 获取今日特卖
     * @return
     */
    public List<Plants> getTodayPlant();

    /**
     * 获取商品
     * @return
     */
    public List<Plants> getGoodPlant();

    /**
     * 获取新的商品
     * @return
     */
    public List<Plants> getNewPlant();

    /**
     * 获取热卖商品
     * @return
     */
    public List<Plants> getTopPlant();

    /**
     * 植物详情
     * @param pid
     * @return
     */
    public List<Plants> getPlantDetail(@Param("pid") int pid);

    /**
     * 分页
     * @param pro
     * @return
     */
    public int getPage(int pro);

    /**
     * 获取商品
     * @param s
     * @param page
     * @param pro
     * @return
     */
    public List<Plants> getPlant(@Param("s") String s, @Param("page") int page, @Param("pro") int pro);
}
