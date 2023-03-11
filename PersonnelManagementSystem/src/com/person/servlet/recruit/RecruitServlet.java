package com.person.servlet.recruit;
import com.alibaba.fastjson.JSON;
import com.person.daoimpl.recruit.RecruitDaoImpl;
import com.person.pojo.Recruit;
import com.person.service.recruit.RecruitService;
import com.person.serviceimpl.recruit.RecruitServiceImpl;
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
 * @author 高丽芳
 * 招聘管理 - servlet
 */
@WebServlet(name = "RecruitServlet",urlPatterns = "/recruit/recruit")
public class RecruitServlet extends HttpServlet {
    private RecruitService service = new RecruitServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String opt= req.getParameter("opt");
        //查询所有
        if (opt.equals("select")){
            this.selectRecruitAll(req,resp);
        }
        //删除
        if (opt.equals("dele")){
            this.deleRecruit(req,resp);
        // 插入
        }
        if (opt.equals("insert")){
            this.insertRecruit(req,resp);
        }
         // 单个查询
        if (opt.equals("dage")){
            this.selectRecruit(req,resp);
        }
        // 修改
        if (opt.equals("up")){
            this.updateRecruit(req,resp);
        }else if (opt.equals("upr")) {
            this.upRecruit(req,resp);
        }

        // 删除全部
        if (opt.equals("deleAll")){
            this.deleteAllRecruit(req,resp);
        }
    }

    /**
     * 清空招聘信息
     * @param req
     * @param resp
     */
    private void deleteAllRecruit(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RecruitService dao = new RecruitServiceImpl();
        boolean b = dao.deleteAllRecruit();
        if (b){
            req.setAttribute("tip","已清空");
        }
        this.selectRecruitAll(req,resp);
    }


    /**
     * 修改
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void updateRecruit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecruitDaoImpl dao = new  RecruitDaoImpl();
        HttpSession session=req.getSession();
        String reId=req.getParameter("reId");
        Recruit recruit=dao.getRecruitById(Integer.parseInt(reId));
        session.setAttribute("recruit",recruit);
        req.getRequestDispatcher("update.jsp").forward(req,resp);
    }
    private void upRecruit(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RecruitDaoImpl dao=new  RecruitDaoImpl();
        String reId=req.getParameter("reId");
        String reName=req.getParameter("reName");
        String reCount=req.getParameter("reCount");
        String reSal=req.getParameter("reSal");
        String reRequirt=req.getParameter("reRequirt");
        Recruit recruit=new Recruit(Integer.parseInt(reId),reName,Integer.parseInt(reCount),Double.valueOf(reSal),reRequirt);
        boolean b=dao.upRecruit(recruit);
        if (b){
            resp.sendRedirect(req.getContextPath() + "/recruit/recruit?opt=select");
        }else {
            req.setAttribute("mes","修改失败");
            req.getRequestDispatcher("update.jsp").forward(req,resp);

        }
    }

    /**
     * 单个查询
     * @param req
     * @param resp
     * @throws IOException
     */
    private void selectRecruit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String reName = req.getParameter("reName");
        Recruit recruit = service.findRecruit(reName);
        String recruitJSON= JSON.toJSONString(recruit);
        PrintWriter out=resp.getWriter();
        if (recruit != null){
          out.println(recruitJSON);
        }
    }

    /**
     * 插入
     * @param request
     * @param response
     * @throws IOException
     */
    private void insertRecruit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String reName=request.getParameter("reName");
        String reCount=request.getParameter("reCount");
        String reSal=request.getParameter("reSal");
        String reRequirt=request.getParameter("reRequirt");
        Recruit recruit = new Recruit(null,reName,Integer.parseInt(reCount),Double.valueOf(reSal),reRequirt);
        int result = service.insertRecruit(recruit);
        if (result>0){
            response.sendRedirect("/PersonnelManagementSystem/recruit/recruit?opt=select");
        }
    }

    /**
     * 删除
     * @param req
     * @param resp
     * @throws IOException
     */
    private void deleRecruit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        RecruitDaoImpl dao=new RecruitDaoImpl();
        String uid=req.getParameter("reId");
        boolean b = dao.delRecurit(Integer.parseInt(uid));
        PrintWriter out= resp.getWriter();
        out.println(b);
        resp.sendRedirect("/PersonnelManagementSystem/recruit/recruit?opt=select");
    }


    /**
     * 查询所有
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void selectRecruitAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Recruit> recruits = service.getAllRecruit();
        if (recruits != null){
            req.setAttribute("recruits",recruits);
            String tip = (String) req.getAttribute("tip");
            req.setAttribute("tip",tip);
            req.getRequestDispatcher("/recruit/recruit.jsp").forward(req,resp);
        }
    }
}
