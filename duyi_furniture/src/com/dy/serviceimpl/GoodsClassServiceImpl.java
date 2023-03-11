package com.dy.serviceimpl;

import com.dy.bean.GoodClass;
import com.dy.dao.GoodsClassDao;
import com.dy.daoimpl.GoodsClassDaoImpl;
import com.dy.service.GoodsClassService;
import com.dy.util.Log;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author DELL
 */
public class GoodsClassServiceImpl implements GoodsClassService {
    private static GoodsClassDao dao = new GoodsClassDaoImpl();

    /**
     * 查询分类
     * @return
     */
    @Override
    public List<GoodClass> findAll() {
        List<GoodClass> goodClasses = null;
        try {
            goodClasses = dao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug("标题" + e.getMessage());
        } finally {
            ((GoodsClassDaoImpl)dao).closeDB();
        }
        return goodClasses;
    }

    @Override
    public GoodClass findGoodsById(int id) {
       GoodClass goodClass = null;
        try {
            goodClass = dao.findGoodsById(id);
        } catch (Exception e) {
            e.printStackTrace();
            Log.mylog.debug("标题" + e.getMessage());
        } finally {
            ((GoodsClassDaoImpl)dao).closeDB();
        }
        return goodClass;
    }
}
