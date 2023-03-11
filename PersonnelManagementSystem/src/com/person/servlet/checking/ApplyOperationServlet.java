package com.person.servlet.checking;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.person.pojo.Apply;
import com.person.service.checking.ApplyService;
import com.person.serviceimpl.checking.ApplyServiceImpl;
import com.person.util.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author 刘昭
 */
@WebServlet(name = "ApplyOperationServlet", urlPatterns = "/checking/apply_operation")
public class ApplyOperationServlet extends HttpServlet {
    private ApplyService service = new ApplyServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("operation");
        if ("insert".equals(operation)){
            this.insertApply(request,response);
        } else if ("delete".equals(operation)){
            this.deleteApply(request,response);
        } else if ("select".equals(operation)){
            this.selectApply(request,response);
        } else if ("search".equals(operation)){
            this.selectOneApply(request,response);
        }
    }

    /**
     * 查询单个请假单信息
     * @param request
     * @param response
     * @throws IOException
     */
    private void selectOneApply(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String key1 = request.getParameter("search");
        int key = Integer.parseInt(key1);
        PrintWriter out = response.getWriter();
        Apply apply = service.searchApply(key);
        String jsonCheck = JSON.toJSONStringWithDateFormat(apply,"yyyy-MM-dd hh:mm:ss", SerializerFeature.WriteDateUseDateFormat);
        if (apply != null){
            out.print(jsonCheck);
        }
    }

    /**
     * 查询所有请假单信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void selectApply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Apply> applies = service.getApplyAll();
        HttpSession session = request.getSession();
        if (applies != null){
            session.setAttribute("applies",applies);
        } else {
            session.setAttribute("flagCheckAll","当前无请假信息！！");
        }
        request.getRequestDispatcher("/checking/apply_select.jsp").forward(request,response);
    }


    /**
     * 删除请假单
     * @param request
     * @param response
     * @throws IOException
     */
    private void deleteApply(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String aId = request.getParameter("aId");
        boolean delete = service.deleteApply(Integer.parseInt(aId));
        PrintWriter printWriter = response.getWriter();
        if (delete){
            printWriter.print("delete");
            response.sendRedirect("check_operation?operation=select");
        }
    }

    /**
     * 插入请假信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void insertApply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nowDate = request.getParameter("nowDate");
        String depName = request.getParameter("depName");
        String empName = request.getParameter("empName");
        String comment_c = request.getParameter("comment_c");
        String comment_d = request.getParameter("comment_d");
        String comment_z = request.getParameter("comment_z");
        String count = request.getParameter("count");
        String begin = request.getParameter("begin");
        String end = request.getParameter("end");
        Integer cId = 0;
        HttpSession session = request.getSession();
        if (depName != null && empName != null){
            cId = service.getCheckId(depName,empName);
            session.setAttribute("cid",cId);
        }
        Apply apply = new Apply(null, DateUtils.strToUtil(nowDate), cId, comment_c,comment_z,comment_d,DateUtils.strToUtil(begin),DateUtils.strToUtil(end),Integer.parseInt(count));
        if (apply != null){
            boolean insert = service.addApply(apply);
            if (insert){
                request.getRequestDispatcher("/checking/apply_operation?operation=select").forward(request,response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
