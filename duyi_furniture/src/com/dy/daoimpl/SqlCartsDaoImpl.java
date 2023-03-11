package com.dy.daoimpl;

import com.dy.bean.Carts;
import com.dy.dao.SqlCartDao;


import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL
 */
public class SqlCartsDaoImpl extends BaseDaoImpl implements SqlCartDao {
    /**
     * 加入购物车
     * @param userId
     * @param gooosId
     */
    @Override
    public void addCar(int userId, int gooosId) throws ClassNotFoundException, SQLException, IOException, URISyntaxException {
        openDB();
        boolean flag = findByUserIdAndGoodsId(userId, gooosId);
        String sql = "";
        if (flag) {
            sql = "UPDATE jj_carts SET cartNum = cartNum + 1 WHERE userId = ? AND goodsId = ? ";

        }else {
            sql = "INSERT INTO jj_carts(USERID, ISCHECK, GOODSID, cartNum) VALUES (?,0,?,1)";

        }
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, userId);
        preparedStatement.setInt(2, gooosId);
        preparedStatement.executeUpdate();
        closeDB();
    }

    /**
     * 查询某个用户的购物车中是否有某商品
     * @param userId
     * @param gooosId
     * @return
     */
    private boolean findByUserIdAndGoodsId(int userId, int gooosId) throws IOException, URISyntaxException, SQLException, ClassNotFoundException {
        try {
            String sql = "SELECT id FROM jj_carts WHERE userId = ? and goodsId = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, gooosId);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 修改商品
     * @param userId
     * @param goodsId
     * @param num
     * @return
     */
    @Override
    public int updateCartNum(int userId, int goodsId, int num) throws ClassNotFoundException, SQLException, URISyntaxException, IOException {
        openDB();
        try{
            String sql = "UPDATE jj_carts SET cartNum = cartNum + ? WHERE userId = ? AND goodsId = ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, num);
            preparedStatement.setInt(2, userId);
            preparedStatement.setInt(3, goodsId);
            return preparedStatement.executeUpdate()>0?200:-1;
        } finally {
            closeDB();
        }
    }

    @Override
    public int cartCheck(int userId, int goodsId, int isCheck) throws ClassNotFoundException, SQLException, URISyntaxException, IOException {
        openDB();
        try{
            String sql = "UPDATE jj_carts SET cartNum = ? WHERE userId = ? AND goodsId = ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, isCheck);
            preparedStatement.setInt(2, userId);
            preparedStatement.setInt(3, goodsId);
            return preparedStatement.executeUpdate()>0?200:-1;
        } finally {
            closeDB();
        }
    }

    @Override
    public int cartDel(int userId, int goodsId) throws ClassNotFoundException, SQLException, URISyntaxException, IOException {
        openDB();
        try{
            String sql = "DELETE FROM jj_carts WHERE userId = ? AND goodsId = ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, goodsId);
            return preparedStatement.executeUpdate()>0?200:-1;
        } finally {
            closeDB();
        }
    }

    @Override
    public List<Carts> findByUserId(int userId) {
        List<Carts> carts = new ArrayList<>();
        try {
            openDB();
            String sql = "SELECT * FROM jj_carts WHERE userId = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                int goodsId = resultSet.getInt("goodsId");
                int isCheck = resultSet.getInt("isCheck");
                int cartNum = resultSet.getInt("cartNum");
                Carts e = new Carts(id,userId,goodsId,isCheck,cartNum);
                carts.add(e);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return carts;
    }

    @Override
    public int insertSessionCarts(int userId, List<Carts> data) {
//        事务
        try {
            openDB();
            statement = connection.createStatement();
            String sql = null;
//            向执行环境中，添加一个sql语句，到批处理中
            for (Carts c : data){
                if (findByUserIdAndGoodsId(userId, c.getGoodsId())){
                    sql = "UPDATE jj_carts SET cartNum = cartNum + " + c.getCartNum() + ",isCheck=" + c.getIsCheck() + " WHERE userId = "+  userId +" AND goodsId = "+  c.getGoodsId() +"";
                }else {
                    sql = "INSERT INTO jj_carts(USERID, ISCHECK, GOODSID, CARTNUM) VALUES("+ userId + ","+ c.getIsCheck() +"," + c.getGoodsId() + ","+ c.getCartNum() +")";
                }
                statement.addBatch(sql);
            }
//            执行批处理
            statement.executeBatch();
            return 200;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return -1;
    }

    @Override
    public List<Carts> findByUserId(int userId, int isCheck) {
        List<Carts> carts = new ArrayList<>();
        try {
            openDB();
            String sql = "SELECT * FROM jj_carts WHERE userId = ? AND isCheck = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, isCheck);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                int goodsId = resultSet.getInt("goodsId");
                int cartNum = resultSet.getInt("cartNum");
                Carts e = new Carts(id,userId,goodsId,isCheck,cartNum);
                carts.add(e);
            }
            return carts;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
       return null;
    }

    @Override
    public int cartDelByCheck(int userId, int isCheck) {
        try {
            openDB();
            String sql = "DELETE FROM jj_carts WHERE userId = ? AND isCheck = ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, isCheck);
            return preparedStatement.executeUpdate()>0?200:-1;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return -1;
    }
}
