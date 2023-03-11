package com.dy.daoimpl;

import com.dy.bean.GoodClass;
import com.dy.dao.GoodsClassDao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL
 */
public class GoodsClassDaoImpl extends BaseDaoImpl implements GoodsClassDao {
    @Override
    public List<GoodClass> findAll() throws ClassNotFoundException, SQLException, URISyntaxException, IOException {
        List<GoodClass> data = new ArrayList<>();
        openDB();
        String sql = "SELECT * FROM jj_class";
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            int parentId = resultSet.getInt("parentId");
            String className = resultSet.getString("className");
            GoodClass goodClass = new GoodClass(id, parentId, className);
            data.add(goodClass);
        }
        return data;
    }

    @Override
    public GoodClass findGoodsById(int id) throws ClassNotFoundException, SQLException, URISyntaxException, IOException {
       GoodClass data = null;
        openDB();
        String sql = "SELECT * FROM jj_class where id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            int cid = resultSet.getInt("id");
            int parentId = resultSet.getInt("parentId");
            String className = resultSet.getString("className");
            data = new GoodClass(cid, parentId, className);
            return data;
        }
        return null;
    }
}
