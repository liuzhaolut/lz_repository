package com.person.servlet.user;

import com.person.pojo.User;
import com.person.service.person.PersonService;
import com.person.service.user.UserService;
import com.person.serviceimpl.person.PersonServiceImpl;
import com.person.serviceimpl.user.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 逯博
 * 用户管理 - servlet
 */
@WebServlet(name = "user", urlPatterns = "/user/user")
public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if ("login".equals(type)) {
            this.login(request, response);
        }
        if ("regist".equals(type)) {
            this.regist(request, response);
        }
        if ("out".equals(type)) {
            this.out(request, response);
        }
    }

    /**
     * 用户退出
     * @param request
     * @param response
     */
    private void out(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("username");
        if (user != null){
            request.getSession().removeAttribute("username");
        }
        request.getRequestDispatcher("/user/login.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        User user = userService.login(userName, passWord);
        HttpSession session = request.getSession();
        if (userName.equals(user.getUserName()) && passWord.equals(user.getPassWord())) {
            session.setAttribute("username", user);
            response.sendRedirect("/PersonnelManagementSystem/index.jsp");
        } else {
            request.getRequestDispatcher("/user/login.jsp").forward(request, response);
        }
    }

    /**
     * 注册
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        String email = request.getParameter("email");

        User u = new User();
        u.setUserName(userName);
        u.setPassWord(passWord);
        u.setEmail(email);

        int state = userService.regist(u);

        if (state == 0) {
            request.getRequestDispatcher("/user/regist.jsp").forward(request, response);
        } else {
            System.out.println("注册成功");
            request.getRequestDispatcher("/user/login.jsp").forward(request, response);
        }
    }
}
