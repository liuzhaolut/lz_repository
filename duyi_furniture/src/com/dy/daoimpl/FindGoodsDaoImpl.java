package com.dy.daoimpl;


import com.dy.bean.Carts;
import com.dy.bean.Goods;
import com.dy.dao.FindGoodsDao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 查询商品
 * @author DELL
 */
public class FindGoodsDaoImpl extends BaseDaoImpl implements FindGoodsDao {
    @Override
    public List<Goods> findGoodsCart(List<Carts> carts) {
        List<Goods> data = new ArrayList<>();
        try{
            openDB();
            String para = "";
            for (int i = 0; i < carts.size(); i++) {
                para += carts.get(i).getGoodsId();
                if (i != carts.size() - 1){
                    para += ",";
                }
            }
            String sql = "SELECT id,name,imgs,gdesc,price FROM jj_goods where id in(" + para + ") ";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String imgs = resultSet.getString("imgs");
                String gdesc = resultSet.getString("gdesc");
                double price = resultSet.getDouble("price");;
                Goods goods = new Goods();
                goods.setId(id);
                goods.setImgs(imgs);
                goods.setName(name);
                goods.setGedsc(gdesc);
                goods.setPrice(price);
                data.add(goods);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return data;
    }

    /**
     * 查询所有商品
     * @return
     */
    @Override
    public List<Goods> findAll(int orderBy) {
        List<Goods> data = new ArrayList<>();
        try{
            openDB();
            String sql = null;
            if (orderBy == 0) {
                sql = "SELECT * FROM jj_goods ORDER BY price ";
            } else {
                sql = "SELECT * FROM jj_goods ORDER BY price desc";
            }
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String imgs = resultSet.getString("imgs");
                double price = resultSet.getDouble("price");
                String gdesc = resultSet.getString("gdesc");
                int stock = resultSet.getInt("stock");
                int appraiseNum = resultSet.getInt("appraiseNum");
                String info = resultSet.getString("info");
                Date createTime = resultSet.getDate("createTime");
                int classid1 = resultSet.getInt("classid1");
                int classid2 = resultSet.getInt("classid2");
                Goods goods = new Goods(id, name, imgs, price, gdesc, stock, appraiseNum, info, createTime, classid1, classid2);
                data.add(goods);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return data;
    }

    /**
     * 根据一级分类查询
     * @param class1Id
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Goods> findGoodsByClass1(int class1Id, int page, int size, int ordeBy) {
        List<Goods> data = new ArrayList<>();
        try{
            openDB();
            String sql = null;
            if (ordeBy == 0) {
                sql = "SELECT * FROM jj_goods WHERE classId1 = ? ORDER BY price limit ?,?;";
            } else {
                sql = "SELECT * FROM jj_goods WHERE classId1 = ? ORDER BY price desc limit ?,?;";
            }
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, class1Id);
            preparedStatement.setInt(2, page);
            preparedStatement.setInt(3, size);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String imgs = resultSet.getString("imgs");
                double price = resultSet.getDouble("price");
                String gdesc = resultSet.getString("gdesc");
                int stock = resultSet.getInt("stock");
                int appraiseNum = resultSet.getInt("appraiseNum");
                String info = resultSet.getString("info");
                Date createTime = resultSet.getDate("createTime");
                int classid1 = resultSet.getInt("classid1");
                int classid2 = resultSet.getInt("classid2");
                Goods goods = new Goods(id, name, imgs, price, gdesc, stock, appraiseNum, info, createTime, classid1, classid2);
                data.add(goods);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return data;
    }

    /**
     * 根据二级分类查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Goods> findGoodsByClass2(int class2Id, int page, int size,  int ordeBy) {
        List<Goods> data = new ArrayList<>();
        try{
            openDB();
            String sql = null;
            if (ordeBy == 0) {
                sql = "SELECT * FROM jj_goods WHERE classId2 = ? ORDER BY price limit ?,?;";
            } else {
                sql = "SELECT * FROM jj_goods WHERE classId2 = ? ORDER BY price desc limit ?,?;";
            }
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, class2Id);
            preparedStatement.setInt(2, page);
            preparedStatement.setInt(3, size);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String imgs = resultSet.getString("imgs");
                double price = resultSet.getDouble("price");
                String gdesc = resultSet.getString("gdesc");
                int stock = resultSet.getInt("stock");
                int appraiseNum = resultSet.getInt("appraiseNum");
                String info = resultSet.getString("info");
                Date createTime = resultSet.getDate("createTime");
                int classid1 = resultSet.getInt("classid1");
                int classid2 = resultSet.getInt("classid2");
                Goods goods = new Goods(id, name, imgs, price, gdesc, stock, appraiseNum, info, createTime, classid1, classid2);
                data.add(goods);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return data;
    }

    /**
     * 根据名称模糊查询
     * @param name
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Goods> findGoodsLikeName(String name, int page, int size,  int ordeBy) {
        List<Goods> data = new ArrayList<>();
        try{
            openDB();
            String sql = null;
            if (ordeBy == 0) {
                sql = "SELECT * FROM jj_goods WHERE name LIKE ? ORDER BY price limit ?,?;";
            } else {
                sql = "SELECT * FROM jj_goods WHERE name LIKE ? ORDER BY price desc limit ?,?;";
            }
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setInt(2, page);
            preparedStatement.setInt(3, size);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                String imgs = resultSet.getString("imgs");
                double price = resultSet.getDouble("price");
                String gdesc = resultSet.getString("gdesc");
                int stock = resultSet.getInt("stock");
                int appraiseNum = resultSet.getInt("appraiseNum");
                String info = resultSet.getString("info");
                Date createTime = resultSet.getDate("createTime");
                int classid1 = resultSet.getInt("classid1");
                int classid2 = resultSet.getInt("classid2");
                Goods goods = new Goods(id, name1, imgs, price, gdesc, stock, appraiseNum, info, createTime, classid1, classid2);
                data.add(goods);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return data;
    }

    /**
     * 获取商品id
     * @param id
     * @return
     */
    @Override
    public Goods findGoodsById(int id) {
        Goods goods = null;
        try{
            openDB();
            String sql = "SELECT * FROM jj_goods WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int gid = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                String imgs = resultSet.getString("imgs");
                double price = resultSet.getDouble("price");
                String gdesc = resultSet.getString("gdesc");
                int stock = resultSet.getInt("stock");
                int appraiseNum = resultSet.getInt("appraiseNum");
                String info = resultSet.getString("info");
                Date createTime = resultSet.getDate("createTime");
                int classid1 = resultSet.getInt("classid1");
                int classid2 = resultSet.getInt("classid2");
                goods = new Goods(gid, name1, imgs, price, gdesc, stock, appraiseNum, info, createTime, classid1, classid2);
                return goods;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDB();
        }
        return null;
    }
}
