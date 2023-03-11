package com.etc.plant.controller;

import com.etc.plant.entity.*;
import com.etc.plant.entity.Collection;
import com.etc.plant.service.CartService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.*;

/**
 * 购物车控制层
 * @author lz
 */
@Controller
public class CartAction {
    @Autowired
    CartService cartService;

    /**
     * 添加收藏夹
     * @param request
     * @return
     */
    @RequestMapping("/addCollectionServlet")
    public String addCollectionServlet(HttpServletRequest request){
        String result = "进入收藏夹....";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String plant_id = request.getParameter("plant_id");
        String colour = request.getParameter("color");
        String size = request.getParameter("size");
        int pid = 0;
        if (plant_id != null) {
            pid = Integer.parseInt(plant_id);
        }
        int no = cartService.addCollection(user, pid, colour, size);
        if (no > 0) {
            result = "添加成功";
            return "forward:getCollectionServlet.do?result=" + result ;
        } else if (no == -1) {
            result = "已添加过此商品";
            return "forward:getCollectionServlet.do?result=" + result ;
        } else {
            return "index.jsp" ;
        }
    }

    /**
     * 获取收藏夹信息
     * @param request
     * @return
     */
    @RequestMapping("/getCollectionServlet")
    public String getCollectionServlet(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Plants> plants = new ArrayList<>();
        List<Collection> collections = cartService.getCollection(user);
        int pid = 0;
        for (int i = 0; i < collections.size(); i++) {
            pid = collections.get(i).getPlant_id();
            Plants plants1 = cartService.getUserPlant(pid);
            plants.add(plants1);
        }
        if (collections != null) {
            session.setAttribute("coll", collections);
            session.setAttribute("cp", plants);
            session.setAttribute("result", "进入收藏夹...");
            return "collection.jsp";
        } else {
            session.setAttribute("result", "添加失败");
            return "index.jsp";
        }
    }

    /**
     * 获取购物车信息
     * @param request
     * @return
     */
    @RequestMapping("/getShopCarServlet")
    public String getShopCarServlet(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Carts> carts = cartService.getShopCar(user);
        List<Plants> plants = new ArrayList<>();
        int pid = 0;
        for (int i = 0; i < carts.size(); i++) {
            pid = carts.get(i).getPlant_id();
            Plants plants1 = cartService.getUserPlant(pid);
            plants.add(plants1);

        }
        if (carts != null) {
            session.setAttribute("pt", plants);
            session.setAttribute("carts", carts);
            session.setAttribute("result", "进入购物车...");
            return "shoppingcart.jsp";
        } else {
            session.setAttribute("result", "添加失败");
            return "index.jsp";
        }
    }

    /**
     * 添加购物车信息
     * @param request
     * @return
     */
    @RequestMapping("/addShopCarServlet")
    public String addShopCarServlet(HttpServletRequest request){
        String result = "进入购物车...";
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String plant_id = request.getParameter("plant_id");
        String colour = request.getParameter("color");
        String size = request.getParameter("size");
        int pid = 0;
        if (plant_id != null) {
            pid = Integer.parseInt(plant_id);
        }
        int no = cartService.addShopCar(user, pid, colour, size);
        if (no > 0) {
            result = "添加成功";
            return "forward:getShopCarServlet.do?result=" + result ;
        } else if (no == -1) {
            result = "已添加过此商品";
            return "forward:getShopCarServlet.do?result=" + result ;
        } else {
            return "index.jsp" ;
        }
    }

    /**
     * 修改购物车商品数量
     * @param pid
     * @param num
     * @param request
     * @param response
     */
    @RequestMapping("/cartNumUpdate")
    public void cartNumUpdate(String pid, String num, HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int uid = user.getUser_id();
        cartService.updateCarNum(uid, Integer.parseInt(pid), Integer.parseInt(num));
        Msg message = new Msg(200, "数量修改成功");
        try {
            response.getWriter().append(message.toJson());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断是否选中
     * @param request
     * @param response
     */
    @RequestMapping("/cartCheck")
    public void cartCheck(HttpServletRequest request, HttpServletResponse response){
        String pid = request.getParameter("pid");
        String isCheck = request.getParameter("isCheck");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int uid = user.getUser_id();
        int i = cartService.cartCheck(uid, Integer.parseInt(pid), Integer.parseInt(isCheck));
        Msg message = new Msg(i, "");
        try {
            response.getWriter().append(message.toJson());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从收藏夹加入购物车
     * @param request
     * @return
     */
    @RequestMapping("/addCarServlet")
    public String chageShopCarServlet(HttpServletRequest request){
        String[] coll = request.getParameterValues("choose");
        String result = "进入购物车...";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int no = 0;
        for (String id:coll
             ) {
            int cid = Integer.parseInt(id);
            List<Collection> collection = cartService.getCollectionById(cid);
            for (int i = 0; i < collection.size(); i++) {
                int pid = collection.get(i).getPlant_id();
                String color = collection.get(i).getColour();
                String size = collection.get(i).getSize();
                no = cartService.addShopCar(user, pid, color, size);
                cartService.deleteColl(cid);
            }
        }
        if (no > 0) {
            result = "添加成功";
            return "forward:getShopCarServlet.do?result=" + result ;
        } else if (no == -1) {
            result = "已添加过此商品";
            return "forward:getShopCarServlet.do?result=" + result ;
        } else {
            return "index.jsp" ;
        }
    }

    /**
     * 删除收藏夹
     * @param request
     * @param cid
     * @return
     */
    @RequestMapping("/deleteCollServlet")
    public String deleteCollServlet(HttpServletRequest request, String cid){
        cartService.deleteColl(Integer.parseInt(cid));
        return "forward:getCollectionServlet.do";
    }

    /**
     * 删除购物车
     * @param request
     * @return
     */
    @RequestMapping("/deleteCarServlet")
    public String deleteCarServlet(HttpServletRequest request){
        HttpSession session = request.getSession();
        String id = request.getParameter("cid");
        int cid = 0;
        if (id != null) {
            cid = Integer.parseInt(id);
        }
        int no = cartService.deleteCar(cid);
        if (no > 0) {
            session.setAttribute("result","删除成功");
        } else if(no == -1){
            session.setAttribute("result","无此商品");
        } else {
            session.setAttribute("result","删除失败");
        }
        return "forward:getShopCarServlet.do";
    }

    /**
     * 提交支付数据
     * @param request
     * @return
     */
    @RequestMapping("/submitOrderServlet")
    public String submitOrderServlet(HttpServletRequest request){
        String[] pid = request.getParameterValues("choice");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int uid = user.getUser_id();
        List<Double> su = new ArrayList<>();
        List<Carts> carts = new ArrayList<>();
        List<Plants> plants = new ArrayList<>();
        Map<String, Double> sMap = new HashMap<>();
        Map<String, Integer> cMap = new HashMap<>();
        double sumi = 0.0;
        for (String id: pid
        ) {
            Carts carts2 = cartService.getCartByMore(uid, Integer.parseInt(id));
            Plants plant = cartService.getUserPlant(carts2.getPlant_id());
            double sum = carts2.getCartNum() * plant.getPrice();
            int count = carts2.getCartNum();
            cMap.put(id, count);

            su.add(sum);
            sMap.put(id, sum);
            sumi += sum;

            plants.add(plant);
            carts.add(carts2);
            session.setAttribute("sumi", sum);
            session.setAttribute("sumall", sumi);
        }
        session.setAttribute("plantall", plants);
        session.setAttribute("shopcar",carts);
        session.setAttribute("countMap", cMap);
        session.setAttribute("sumMap", sMap);
        session.setAttribute("pids", pid);
        return "forward:getAddress.do";
    }

    /**
     * 具体支付操作
     * @param request
     * @return
     */
    @RequestMapping("/checkoutServlet")
    public String checkoutServlet(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int uid = user.getUser_id();
        Double sum = (Double) session.getAttribute("sumall");
        Map<String, Integer> countMap = (Map<String, Integer>) session.getAttribute("countMap");
        Map<String, Double> sumMap = (Map<String, Double>) session.getAttribute("sumMap");
        String[] ids = (String[]) session.getAttribute("pids");
        Address address = (Address) session.getAttribute("address");
        int aid = cartService.getAddressId(uid, address.getUserAddress());
        String card = request.getParameter("card");
        String year = request.getParameter("year");
        String moth = request.getParameter("moth");
        String day = request.getParameter("day");
        int y = 0,m = 0,d = 0;
        if (year != null && moth != null && day != null) {
            y = Integer.parseInt(year) - 1900;
            m = Integer.parseInt(moth) - 1;
            d = Integer.parseInt(day);
        }
        int cardId = cartService.getCardId(uid, card);
        Order order = new Order();
        order.setUserId(uid);
        order.setMoney(sum);
        order.setPaymentId(cardId);
        order.setAddressId(aid);
        Date date = new Date(y,m,d);
        order.setDeliveryTime(date);
        cartService.pay(countMap, sumMap, ids, order);
        return "success.jsp";
    }

    /**
     * 添加地址
     * @param request
     * @return
     */
    @RequestMapping("/addAddressServlet.do")
    public String addAddressServlet(HttpServletRequest request){
        String result = "";
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int uid = user.getUser_id();
        String name = request.getParameter("uname");
        String phone = request.getParameter("phone");
        int province = Integer.parseInt(request.getParameter("code1"));
        int city = Integer.parseInt(request.getParameter("code2"));
        int area = Integer.parseInt(request.getParameter("code3"));
        int street = Integer.parseInt(request.getParameter("code4"));
        int code = Integer.parseInt(request.getParameter("zipcode"));
        String add = request.getParameter("address");
        Address address = new Address();
        address.setUserId(uid);
        address.setUserName(name);
        address.setUserPhone(phone);
        address.setProvinceId(province);
        address.setCityId(city);
        address.setAreaId(area);
        address.setStreetId(street);
        address.setZipCode(code);
        address.setUserAddress(add);
        if (address != null){
            int aid = cartService.getAddressId(uid, add);
            if (aid > 0){
                result = "地址已存在，可直接使用";
            } else {
                cartService.addAddress(address);
                result = "地址添加成功";
            }
        }
        session.setAttribute("result1", result);
        session.setAttribute("address", address);
        return "checkout.jsp";
    }
}
