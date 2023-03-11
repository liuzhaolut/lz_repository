package com.etc.plant.service;

import com.etc.plant.entity.Plants;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品服务层
 * @author lz
 */
@Repository
public interface PlantService {
    /**
     * 显示今日特卖
     * @return
     */
    public List<Plants> getTodayPlant();

    /**
     * 显示分类商品
     * @return
     */
    public List<Plants> getGoodPlant();

    /**
     * 获取新商品
     * @return
     */
    public List<Plants> getNewPlant();

    /**
     * 热卖商品
     * @return
     */
    public List<Plants> getTopPlant();

    /**
     * 显示植物细节
     * @param pid
     * @return
     */
    public List<Plants> getPlantDetail(int pid);

    /**
     * 分页
     * @param pro
     * @return
     */
    public int getPage(int pro);

    /**
     * 显示商品
     * @param s
     * @param page
     * @param pro
     * @return
     */
    public List<Plants> getPlant(String s, int page, int pro);
}
