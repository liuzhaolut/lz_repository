package com.dy.filter;

import com.dy.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author DELL
 */
@WebFilter({"/mygxin.jsp","/order.jsp","/myorderq.jsp","/myprod.jsp","/remima.jsp"})
public class UserFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null){
            String url = request.getRequestURL().toString();
            String para = request.getQueryString();
            if (para != null) {
                url += "?" + para;
            }
            session.setAttribute("loginUrl", url);
            response.sendRedirect("login.jsp");
        } else {
            chain.doFilter(req, resp);
        }

    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
