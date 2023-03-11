package com.etc.plant.controller;

import com.etc.plant.entity.*;
import com.etc.plant.service.AddressService;
import com.etc.plant.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 地址控制层
 * @author lz
 */
@Controller
public class RegionAction {
    @Autowired
    RegionService regionService;

    /**
     * 获取地址信息
     * @param request
     * @return
     */
    @RequestMapping("/getAddress")
    public String getCode(HttpServletRequest request){
        HttpSession session = request.getSession();
//    城市数据
        List<Region> citys = regionService.findByLevel(1);
        session.setAttribute("citys", citys);
        return "checkout.jsp";
    }

    /**
     * 级联获取地址信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getRegionByParentCode", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Msg getRegionByParentCode(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        List<Region> cnRegions = regionService.findByParentCode(code);
        Msg msg = new Msg(200, "", cnRegions);
        return msg;
    }
}
