package com.dy.serviceimpl;

import com.dy.bean.Carts;
import com.dy.bean.User;
import com.dy.dao.SqlCartDao;
import com.dy.daoimpl.SqlCartsDaoImpl;
import com.dy.service.BaseCarService;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL
 */
public class SqlCartsService implements BaseCarService {
    private static SqlCartDao dao = new SqlCartsDaoImpl();
    private int getUserId(HttpSession session){
        User user = (User) session.getAttribute("user");
        int userId = user.getId();
        return  userId;
    }
    @Override
    public void addCar(HttpSession session, int goodsId)  {
        int userId = getUserId(session);
        try {
            dao.addCar(userId, goodsId);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int updateCarNum(HttpSession session, int goodsId, int num) {
        int userId = getUserId(session);
        int no = 0;
        try {
            no =  dao.updateCartNum(userId, goodsId, num);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return no;
    }

    @Override
    public int cartCheck(HttpSession session, int goodsId, int isCheck){
        int userId = getUserId(session);
        int no = 0;
        try {
            no =  dao.cartCheck(userId, goodsId, isCheck);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return no;
    }

    @Override
    public int cartDel(HttpSession session, int goodsId)  {
        int userId = getUserId(session);
        int no = 0;
        try {
            no =  dao.cartDel(userId, goodsId);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return no;
    }


    public List<Carts> findByUserId(int userId){
        return dao.findByUserId(userId);
    }

    public int insertSessionCarts(int userId, List<Carts> data){
        return dao.insertSessionCarts(userId,data);
    }

    @Override
    public List<Carts> findByUserId(HttpSession session, int isCheck) {
       return dao.findByUserId(getUserId(session), isCheck);
    }

    @Override
    public int cartDelByCheck(HttpSession session, int isCheck) {
        return dao.cartDelByCheck(getUserId(session), isCheck);
    }
}
