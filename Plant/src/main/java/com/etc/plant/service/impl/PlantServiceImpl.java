package com.etc.plant.service.impl;

import com.etc.plant.dao.PlantDao;
import com.etc.plant.entity.Plants;
import com.etc.plant.service.PlantService;
import com.etc.plant.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lz
 */
@Service
public class PlantServiceImpl implements PlantService {
    @Autowired
    PlantDao dao;

    /**
     * 获取今日特价商品
     * @return
     */
    @Override
    public List<Plants> getTodayPlant() {
        List<Plants> plants = null;
        try{
            plants = dao.getTodayPlant();
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug("植物..." + e.getMessage());
        }
        return plants;
    }

    /**
     * 获取热卖商品
     * @return
     */
    @Override
    public List<Plants> getGoodPlant() {
        List<Plants> plants = null;
        try{
            plants = dao.getGoodPlant();
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug("植物..." + e.getMessage());
        }
        return plants;
    }

    /**
     * 获取新品
     * @return
     */
    @Override
    public List<Plants> getNewPlant() {
        List<Plants> plants = null;
        try{
            plants = dao.getNewPlant();
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug("植物..." + e.getMessage());
        }
        return plants;
    }

    /**
     * 获取好评商品
     * @return
     */
    @Override
    public List<Plants> getTopPlant() {
        List<Plants> plants = null;
        try{
            plants = dao.getTopPlant();
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug("植物..." + e.getMessage());
        }
        return plants;
    }

    /**
     * 获取商品细节信息
     * @param pid
     * @return
     */
    @Override
    public List<Plants> getPlantDetail(int pid) {
        List<Plants> plants = null;
        try{
            plants = dao.getPlantDetail(pid);
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug("植物..." + e.getMessage());
        }
        return plants;
    }

    /**
     * 分页显示商品信息
     * @param pro
     * @return
     */
    @Override
    public int getPage(int pro) {
        int no = 0;
        int page = 0;
        try{
            no = dao.getPage(pro);
            if (no % pro == 0){
                page = no / pro;
            } else {
                page = no / pro + 1;
            }
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("植物..." + e.getMessage());
        }
        return page;
    }

    /**
     * 获取商品信息
     * @param s
     * @param page
     * @param pro
     * @return
     */
    @Override
    public List<Plants> getPlant(String s, int page, int pro) {
        List<Plants> plants = null;
        int n = (page - 1) * pro;
        try{
            plants = dao.getPlant(s, n, pro);
        } catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("植物..." + e.getMessage());
        }
        return plants;
    }
}
