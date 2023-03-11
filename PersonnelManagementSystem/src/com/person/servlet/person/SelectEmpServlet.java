package com.person.servlet.person;

import com.person.pojo.Emp;
import com.person.service.person.PersonService;
import com.person.serviceimpl.person.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author 张天旭
 * 员工管理 - servlet
 * @date 2022/6/22 11:32
 */
@WebServlet(name = "selectEmp", urlPatterns = "/person/selectEmp")
public class SelectEmpServlet extends HttpServlet {
    private PersonService personService = new PersonServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String type = request.getParameter("type");
        if ("selectOne".equals(type)) {
            this.selectOne(request, response);
        }
        if ("selectAll".equals(type)) {
            this.selectAll(request, response);
        }
        if ("selectUpdate".equals(type)) {
            this.selectUpdate(request, response);
        }
        if ("deleteOne".equals(type)) {
            this.deleteOne(request, response);
        }
        if ("update".equals(type)) {
            this.update(request, response);
        }
        if ("insertOne".equals(type)) {
            this.insertOne(request, response);
        }
        if ("insert".equals(type)) {
            this.insert(request, response);
        }
        if ("deleteAll".equals(type)) {
            this.deleteAll(request, response);
        }

    }

    /**
     * 删除所有员工信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void deleteAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int state = personService.deleteAll();
        if (state == 0) {
            System.out.println("删除失败！");
        } else {
            System.out.println("删除成功");
        }
        selectAll(request, response);
    }

    /**
     * 查询单个员工信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("empId");
        int empId = Integer.parseInt(id);

        Emp emp = personService.selectEmpOneService(empId);
        HttpSession session = request.getSession();
        session.setAttribute("empOne", emp);
        session.removeAttribute("empList");
        request.getRequestDispatcher("/person/record.jsp").forward(request, response);
    }

    /**
     * 查询所有员工信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Emp> empList = personService.selectEmpAllService();

        HttpSession session = request.getSession();
        session.setAttribute("empList", empList);
        session.removeAttribute("empOne");
        request.getRequestDispatcher("/person/record.jsp").forward(request, response);

    }

    /**
     * 通过员工号找到被修改员工并回显
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("empId");
        int empId = Integer.parseInt(id);
        Emp emp = personService.selectEmpOneService(empId);
        HttpSession session = request.getSession();
        session.setAttribute("empUpdate", emp);
        session.setAttribute("state", "update");
        request.getRequestDispatcher("/person/check_insert.jsp").forward(request, response);
    }

    /**
     * 根据员工号删除员工信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("empId");
        int empId = Integer.parseInt(id);
        int state = personService.deleteOne(empId);
        if (state == 0) {
            System.out.println("删除失败！");
        } else {
            System.out.println("删除成功");
        }
        selectAll(request, response);
    }

    /**
     * 从回显页面获取修改后的数据，进行修改
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("empId");
        int empId = Integer.parseInt(id);
        String empName = request.getParameter("empName");
        String empSex = request.getParameter("empSex");
        String age = request.getParameter("empAge");
        int empAge = Integer.parseInt(age);
        String year = request.getParameter("work_year");
        int workYear = Integer.parseInt(year);
        String telephone = request.getParameter("telephone");
        String address = request.getParameter("address");

        Emp emp = new Emp();
        emp.setEmpId(empId);
        emp.setEmpName(empName);
        emp.setEmpsex(empSex);
        emp.setEmpage(empAge);
        emp.setWork_year(workYear);
        emp.setTelephone(telephone);
        emp.setAddress(address);

        int state = personService.update(emp, empId);

        if (state == 0) {
            System.out.println("修改失败！");
        } else {
            System.out.println("修改成功");
        }
        selectAll(request, response);
    }

    /**
     * 新增一个用户
     *
     * @param request
     * @param response
     * @return 1代表新增成功 0代表新增失败
     * @throws ServletException
     * @throws IOException
     */
    public void insertOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("empUpdate");
        session.setAttribute("state", "insert");
        request.getRequestDispatcher("/person/check_insert.jsp").forward(request, response);
    }

    /**
     * 执行新增操作
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empName = request.getParameter("empName");
        String empSex = request.getParameter("empSex");
        String age = request.getParameter("empAge");
        int empAge = Integer.parseInt(age);
        String year = request.getParameter("work_year");
        int workYear = Integer.parseInt(year);
        String telephone = request.getParameter("telephone");
        String address = request.getParameter("address");

        Emp emp = new Emp();
        emp.setEmpName(empName);
        emp.setEmpsex(empSex);
        emp.setEmpage(empAge);
        emp.setWork_year(workYear);
        emp.setTelephone(telephone);
        emp.setAddress(address);
        int state = personService.insert(emp);
        if (state == 0) {
            System.out.println("新增失败！");
        } else {
            System.out.println("新增成功");
        }
        selectAll(request, response);
    }
}
