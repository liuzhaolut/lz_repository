package com.etc.plant.controller;

import com.etc.plant.entity.Comment;
import com.etc.plant.entity.Plants;
import com.etc.plant.entity.User;
import com.etc.plant.service.CartService;
import com.etc.plant.service.CommentService;
import com.etc.plant.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 商品控制层
 * @author lz
 */
@Controller
public class PlantAction {
    @Autowired
    PlantService plantService;

    /**
     * 获取植物细节信息
     * @param request
     * @return
     */
    @RequestMapping("/getPlantDetailServlet")
    public String getPlantDetailServlet(HttpServletRequest request){
        HttpSession session = request.getSession();
        String id = request.getParameter("pid");
        int pid = 0;
        if (id != null) {
            pid = Integer.parseInt(id);
        }
        List<Plants> plants = plantService.getPlantDetail(pid);
        if (plants != null) {
            session.setAttribute("pl", plants);
            return "productdetails.jsp";
        }
        return "404page.jsp";
    }

    /**
     * 分页获取植物
     * @param request
     * @return
     */
    @RequestMapping("/getPagePlantsServlet")
    public String getPagePlantsServlet(HttpServletRequest request) {
        HttpSession session = request.getSession();
//        分页显示
        String p = request.getParameter("page");
        String i = request.getParameter("p");
        String s = request.getParameter("s");
        int pro = 0;
        if (i == null && s == null && p == null) {
            pro = 12;
            session.setAttribute("pro", pro);
            session.setAttribute("s", null);
        } else if (i != null) {
            pro = Integer.parseInt(i);
            session.setAttribute("pro", pro);
        } else  if (s != null){
            session.setAttribute("s", s);
            if ("全部".equals(s)){
                session.setAttribute("s", null);
            }
        }
        s = (String) session.getAttribute("s");
        pro = (int) session.getAttribute("pro");
        p = p == null ? "1" : p;
        int page = Integer.parseInt(p);
        int up = page - 1;
        int down = page + 1;
        int allPage = 0;
        allPage = plantService.getPage(pro);
        request.setAttribute("page",page);
        request.setAttribute("up",up);
        request.setAttribute("down",down);
        request.setAttribute("allPage",allPage);
        List<Plants> plants = plantService.getPlant(s,page,pro);
        request.setAttribute("plant", plants);
        return "gridproducts.jsp";
    }
}
