<%@ page import="com.person.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: 17162
  Date: 2022/6/22
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<script type="text/javascript">--%>
<%--    window.onload = function(){--%>
<%--        if (${username == null}){--%>
<%--            alert("您还未登陆，请先登录哦！！");--%>
<%--            location.href = "/PersonnelManagementSystem/user/login.jsp";--%>
<%--        }--%>

<%--    };--%>
<%--</script>--%>
<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav metismenu" id="side-menu">
            <li class="nav-header">
                <div class="dropdown profile-element">
                    <img alt="image" class="rounded-circle" src="/PersonnelManagementSystem/img/profile_small.jpg" />
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <%
                            User username = (User) session.getAttribute("username");
                            request.getSession().setAttribute("username",username);
                            String u = "未登录";
                            if (username != null) {
                                u = username.getUserName();
                            }
                        %>
                        <span class="block m-t-xs font-bold"><%=u%></span>
                        <span class="text-muted text-xs block">管理员 <b class="caret"></b></span>
                    </a>
                    <ul class="dropdown-menu animated fadeInRight m-t-xs">
                        <li>
                            <a class="dropdown-item" href="/PersonnelManagementSystem/user/profile.jsp">个人信息</a>
                        </li>

                        <li class="dropdown-divider"></li>

                        <li>
                            <a class="dropdown-item" href="/PersonnelManagementSystem/user/user?type=out">登出</a>
                        </li>
                    </ul>
                </div>

            </li>
            <li class="active">
                <a href="/PersonnelManagementSystem/index.jsp"><i class="fa fa-diamond"></i> <span class="nav-label">主页</span></a>
            </li>

            <li>
                <a href="#"><i class="fa fa-th-large"></i> <span class="nav-label">招聘管理</span> <span
                        class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="/PersonnelManagementSystem/recruit/recruit?opt=select">招聘信息发布</a>
                    </li>

                </ul>
            </li>

            <li>
                <a href="#"><i class="fa fa-envelope"></i> <span class="nav-label">员工管理 </span><span
                        class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li>
                        <a href="/PersonnelManagementSystem/person/selectEmp?type=selectAll">人事档案管理</a>
                    </li>
                    <li>
                        <a href="/PersonnelManagementSystem/person/selectEmp?type=insertOne">新员工入职</a>
                    </li>
                </ul>
            </li>

            <li>
                <a href="#"><i class="fa fa-flask"></i> <span class="nav-label">考勤管理</span><span
                        class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="/PersonnelManagementSystem/checking/check_operation?operation=select">考勤信息</a>
                    </li>
                    <li>
                        <a href="/PersonnelManagementSystem/checking/check_insert.jsp">考勤新增</a>
                    </li>
                    <li>
                        <a href="/PersonnelManagementSystem/checking/apply.jsp">请假申请</a>
                    </li>
                    <li>
                        <a href="/PersonnelManagementSystem/checking/apply_operation?operation=select">请假详情</a>
                    </li>
                </ul>
            </li>

            <li>
                <a href="#"><i class="fa fa-globe"></i> <span class="nav-label">工资管理</span><span
                        class="fa arrow"></span></a>
                <ul class="nav nav-second-level collapse">
                    <li>
                        <a href="/PersonnelManagementSystem/wage/WageServlet?opt=select">工资查看</a>
                    </li>
<%--                    <li>--%>
<%--                        <a href="/PersonnelManagementSystem/wage/payroll-view.jsp">工资修改</a>--%>
<%--                    </li>--%>
                </ul>
            </li>
        </ul>
    </div>
</nav>
