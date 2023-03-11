package com.person.servlet.wage;

import com.alibaba.fastjson.JSON;
import com.person.daoimpl.wage.WageDaoImpl;
import com.person.pojo.Emp;
import com.person.pojo.Salary;
import com.person.service.wage.WageService;
import com.person.serviceimpl.wage.WageServiceImpl;

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
 * @author 吴洋洋
 * 工资管理 - servlet
 * @date 2022/6/22 11:32
 */
@WebServlet(name="WageServlet",urlPatterns = "/wage/WageServlet")
public class WageServlet extends HttpServlet {

    private WageService service = new WageServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String opt = request.getParameter("opt");

        //查询所有薪资
        if (opt.equals("select")) {
            this.selectSalaryAll(request, response);
        }
        //查询个人薪资
        if (opt.equals("selectId")) {
            this.selectId(request, response);
        }
//        //修改员工薪资
        if(opt.equals("update")){
            this.updateSaraly(request, response);
        }
        if(opt.equals("upSal")){
            System.out.println("----2");
            this.UpSaraly(request, response);
        }

        //删除员工薪资
        if(opt.equals("delete")){
            this.DeleteSalaryServlet(request, response);
        }
        //新增员工工资
        if(opt.equals("insert")){
            this.insert(request, response);
        }
        if (opt.equals("insertSalary")) {
            this.insertSaraly(request, response);
        }

    }

    /**
     * 删除工资信息
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void DeleteSalaryServlet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        int id= Integer.parseInt(request.getParameter("id"));
        WageService wageService=new WageServiceImpl();
        int result = wageService.deletSalary(id);
        if(result>0){
            this.selectSalaryAll(request, response);
        }
    }

    /**
     * 查询所有工资信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void selectSalaryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Salary> salaryList = service.selectSalaryAll();
        HttpSession session = request.getSession();
        if (salaryList != null){
            session.setAttribute("salaryList",salaryList);
            response.sendRedirect(request.getContextPath() + "/wage/payroll-view.jsp");
        }
    }

    /**
     * 根据员工id查询工资信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void selectId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        String eId = request.getParameter("eId");
        Salary salary = service.selsectId(Integer.parseInt(eId));
        String salaryJSON = JSON.toJSONString(salary);
        PrintWriter out = response.getWriter();
        if (salary != null) {
            out.print(salaryJSON);
        }

    }

    /**
     * 修改员工以及员工薪资
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private  void updateSaraly(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        WageDaoImpl  wageDao = new WageDaoImpl();
        HttpSession session = request.getSession();
        //根据隐藏input标签的name属性值获取id
        String id=request.getParameter("salid");
        Salary salary =wageDao.getSalyId(Integer.parseInt(id));
        session.setAttribute("saraly",salary);
        response.sendRedirect(request.getContextPath() + "/wage/payroll-update.jsp");
    }

    /**
     * 修改工资信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private  void UpSaraly(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WageDaoImpl  wageDao = new WageDaoImpl();
        //根据隐藏input标签的name属性值获取id
        int salids= Integer.valueOf(request.getParameter("id"));
        int empId = Integer.parseInt(request.getParameter("EmPid"));
        String empName = request.getParameter("empName");
        System.out.println(empId + "----" + empName);
        Double overtime = Double.valueOf(request.getParameter("overtime"));
        Double baseSal = Double.valueOf(request.getParameter("baseSal"));
        Double commission = Double.valueOf(request.getParameter("commission"));
        Double allSal = overtime + baseSal + commission;
        boolean salary1;
        if (salids != 0 || empId != 0 || empName != null ||overtime != null || baseSal != null || commission != null || allSal != null){
            Salary salary = new Salary(salids,empId,empName,overtime,baseSal,commission,allSal);
            salary1 = wageDao.UpSaraly(salary);
            if(salary1){
                response.sendRedirect("/PersonnelManagementSystem/wage/WageServlet?opt=select");
            }else {
                request.setAttribute("mes","修改不成功");
                request.getRequestDispatcher("payroll-update.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("mes","各数据不为空！");
            request.getRequestDispatcher("payroll-update.jsp").forward(request, response);
        }


    }


    /**
     * 插入工资信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void insertSaraly(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int empId = Integer.parseInt(request.getParameter("EmPid"));
        Double overtime = Double.valueOf(request.getParameter("overtime"));
        Double baseSal = Double.valueOf(request.getParameter("baseSal"));
        Double commission = Double.valueOf(request.getParameter("commission"));
        Double allSal = overtime + baseSal + commission;
        Salary salary = new Salary();
        salary.setEmpId(empId);
        salary.setOvertime(overtime);
        salary.setBaseSal(baseSal);
        salary.setCommission(commission);
        salary.setAllSal(allSal);
        int result = service.insertSaraly(salary);
        if (result > 0) {
            response.sendRedirect("/PersonnelManagementSystem/wage/WageServlet?opt=select");
        } else {
            request.setAttribute("flag", "新增失败,找不到该员工");
            request.getRequestDispatcher("payroll-insert.jsp").forward(request, response);
        }

    }

    /**
     * 调转到新增工资界面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("payroll-insert.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}