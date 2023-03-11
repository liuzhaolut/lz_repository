package com.dy.servlet.address;

import com.dy.bean.CnRegion;
import com.dy.bean.Message;
import com.dy.service.RegionService;
import com.dy.serviceimpl.RegionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author DELL
 */
@WebServlet("/getRegionByParentCode.do")
public class getRegionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        RegionService service = new RegionServiceImpl();
        List<CnRegion> cnRegions = service.findByParentCode(code);
        Message msg = new Message(200,"", cnRegions);
        response.getWriter().append(msg.toJson());
    }
}
