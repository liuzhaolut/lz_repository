package com.dy.serviceimpl;

import com.dy.bean.Carts;
import com.dy.bean.Message;
import com.dy.bean.User;
import com.dy.service.BaseCarService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DELL
 */
public class SessionCartsService implements BaseCarService {

    @Override
    public void addCar(HttpSession session, int goodsId) {
//            未登录
        ArrayList<Carts> data = (ArrayList<Carts>) session.getAttribute("carts");
        if (data == null) {
            data = new ArrayList<>();
            session.setAttribute("carts", data);
        }
        Carts carts = new Carts(goodsId);
        int index = data.indexOf(carts);
        if (index != -1) {
            Carts oldCats = data.get(index);
            oldCats.setCartNum(oldCats.getCartNum() + 1);
        } else {
            carts.setCartNum(1);
            data.add(carts);
        }
        Integer count = (Integer) session.getAttribute("cartsCount");
        if(count == null){
            count = 0;
        }
        count++;
        session.setAttribute("cartsCount",count);
    }

    @Override
    public int updateCarNum(HttpSession session, int goodsId, int num) {
        ArrayList<Carts> cs = (ArrayList<Carts>) session.getAttribute("carts");
        if (cs == null){
            cs = new ArrayList<>();
        }
        Carts c = new Carts(goodsId);
        int i = cs.indexOf(c);
        if ( i != -1){
            cs.get(i).setCartNum(cs.get(i).getCartNum() + num);
            Integer count = (Integer) session.getAttribute("cartsCount");
            session.setAttribute("cartsCount", count + num);
            return 200;
        } else {
            return -1;
        }
    }

    @Override
    public int cartCheck(HttpSession session, int goodsId, int isCheck) {
        ArrayList<Carts> carts = (ArrayList<Carts>) session.getAttribute("carts");
        int index = indexof(carts, goodsId);
        if (index == -1) {
            return -1;
        } else {
            carts.get(index).setIsCheck(isCheck);
            return 200;
        }
    }

    @Override
    public int cartDel(HttpSession session, int goodsId) {
        ArrayList<Carts> carts = (ArrayList<Carts>) session.getAttribute("carts");
        int index = indexof(carts, goodsId);
        if (index == -1){
            return -1;
        } else {
            Carts carts1 = carts.remove(index);
            Integer count = (Integer) session.getAttribute("cartsCount");
            session.setAttribute("cartsCount", count - carts1.getCartNum());
            return 200;
        }
    }

    @Override
    public List<Carts> findByUserId(HttpSession session, int isCheck) {
        return null;
    }

    @Override
    public int cartDelByCheck(HttpSession session, int isCheck) {
        return 0;
    }

    private int indexof(ArrayList<Carts> cs, int goodsId){
        if (cs == null){
            return  -1;
        }
        return cs.indexOf(new Carts(goodsId));
    }
}
