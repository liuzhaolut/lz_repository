package com.person.servlet.checking;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.JSONSerializable;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.person.pojo.Checking;
import com.person.pojo.Emp;
import com.person.service.checking.CheckingService;
import com.person.serviceimpl.checking.CheckingServiceImpl;
import com.person.util.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.Format;
import java.util.Date;
import java.util.List;

/**
 * @author 刘昭
 * 考勤管理 - servlet
 */
@WebServlet(name = "CheckOperationServlet", urlPatterns = "/checking/check_operation")
public class CheckOperationServlet extends HttpServlet {
    private CheckingService service = new CheckingServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operation = request.getParameter("operation");
        if ("insert".equals(operation)){
            this.insertCheck(request,response);
        } else if ("delete".equals(operation)){
            this.deleteCheck(request,response);
        } else if ("update".equals(operation)){
            this.updateCheck(request,response);
        } else if ("select".equals(operation)){
            this.selectCheck(request,response);
        } else if ("selectOne".equals(operation)){
            this.selectOneCheck(request,response);
        } else if ("search".equals(operation)){
            this.searchCheck(request,response);
        } else if ("selectName".equals(operation)){
            this.selectNameEmp(request,response);
        }
    }

    /**
     * 搜索有无相关用户
     * @param request
     * @param response
     */
    private void selectNameEmp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String key1 = request.getParameter("search");
        String key = "%" + key1 + "%";
        PrintWriter out = response.getWriter();
        boolean emp = service.selectNameEmp(key);
        if (!emp){
            out.print("无此用户");
        } else {
            out.print("用户存在");
        }
    }

    /**
     * 搜索考勤信息
     * @param request
     * @param response
     */
    private void searchCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key1 = request.getParameter("search");
        String key = "%" + key1 + "%";
        PrintWriter out = response.getWriter();
        List<Checking> checkings = service.searchChecking(key);
        String jsonCheck = JSON.toJSONStringWithDateFormat(checkings,"yyyy-MM-dd hh:mm:ss", SerializerFeature.WriteDateUseDateFormat);
        if (checkings.size() > 0){
            out.print(jsonCheck);
        }
    }

    /**
     * 查询单个考勤
     * @param request
     * @param response
     */
    private void selectOneCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String cId = request.getParameter("cId");
        String id = (String) session.getAttribute("cId");
        Integer cid = null;
        if (cId != null){
            cid = Integer.parseInt(cId);
        }
        if (id != null){
            cid = Integer.parseInt(id);
        }
        Checking checking = service.selectOneChecking(cid);
        if (checking != null){
            session.setAttribute("checking",checking);
            session.setAttribute("cId",cId);
            request.setAttribute("tip","请修改");
        } else {
            request.setAttribute("tip","暂无此考勤记录！");
        }
        request.getRequestDispatcher("/checking/check_update.jsp").forward(request,response);
    }

    /**
     * 查看考勤
     * @param request
     * @param response
     */
    private void selectCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Checking> checkings = service.selectCheckingAll();
        if (checkings.size() > 0){
            session.setAttribute("checkings", checkings);
        } else {
            session.setAttribute("flagCheckAll","暂无数据！！");
        }
        response.sendRedirect("/PersonnelManagementSystem/checking/attendancecheck.jsp");
    }

    /**
     * 修改考勤
     * @param request
     * @param response
     */
    private void updateCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String cid = (String) session.getAttribute("cId");
        String depName = request.getParameter("depName");
        String startDate = request.getParameter("startDate");
        String state = request.getParameter("state");
        String note = request.getParameter("note");
        Checking checking = new Checking();
        checking.setCheckId(Integer.parseInt(cid));
        checking.setDepName(depName);
        checking.setStartDate(DateUtils.strToUtil(startDate));
        checking.setState(Integer.parseInt(state));
        checking.setNote(note);
        boolean result = service.UpdateChecking(checking);
        if (result){
            request.setAttribute("flag","修改成功！");
        }else {
            request.setAttribute("flag","修改失败！");
        }
        request.getRequestDispatcher("/checking/check_operation?operation=selectOne").forward(request,response);
    }

    /**
     * 删除考勤
     * @param request
     * @param response
     */
    private void deleteCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cId = request.getParameter("cId");
        boolean delete = service.deleteChecking(Integer.parseInt(cId));
        PrintWriter printWriter = response.getWriter();
        if (delete){
            printWriter.print(delete);
//            location.href = "check_operation?operation=select";
            response.sendRedirect("check_operation?operation=select");
        }

    }

    /**
     * 新增考勤
     * @param request
     * @param response
     */
    private void insertCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empId = request.getParameter("empId");
        String empName = request.getParameter("empName");
        Emp emp = service.selectEmpId(Integer.parseInt(empId),empName);
        System.out.println(emp);
        if (emp.getEmpId() == null){
            request.setAttribute("flag","员工号/姓名输入错误！");
        } else {
            String depName = request.getParameter("depName");
            String state = request.getParameter("state");
            String note = request.getParameter("note");
            Checking checking = new Checking(Integer.parseInt(empId), empName, depName, new Date(), Integer.parseInt(state), note);
            boolean result = service.insertChecking(checking);
            if (result) {
                request.setAttribute("flag", "新增成功！");
            } else {
                request.setAttribute("flag", "新增失败！");
            }
        }
        request.getRequestDispatcher("/checking/check_insert.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
