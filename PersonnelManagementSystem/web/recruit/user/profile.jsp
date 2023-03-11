<%@ page import="com.person.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: 刘昭
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>人事管理系统   | 资料页</title>

    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="../css/animate.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">

</head>

<body class="">
<div id="wrapper">
    <jsp:include page="../head.jsp"></jsp:include>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top white-bg" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                    <form role="search" class="navbar-form-custom" action="search_results.jsp">
                        <div class="form-group">
                            <input type="text" placeholder="请输入搜索内容" class="form-control" name="top-search" id="top-search">
                        </div>
                    </form>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <span class="m-r-sm text-muted welcome-message">欢迎来到人事管理系统后台</span>
                    </li>

                    <li>
                        <a href="/PersonnelManagementSystem/user/user?type=out">
                            <i class="fa fa-sign-out"></i> 注销
                        </a>
                    </li>

                </ul>

            </nav>
        </div>
        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-sm-4">
                <h2>管理员信息</h2>

            </div>

            <%
                HttpSession httpSession = request.getSession();
                User user = (User) httpSession.getAttribute("username");
                if (user == null) {
            %>
            <div class="col-sm-8">
                <div class="title-action">
                    <a href="/PersonnelManagementSystem/user/login.jsp" class="btn btn-primary">去登陆</a>
                </div>
            </div>
            <%
                }
            %>
        </div>

        <div class="table-responsive">
            <table class="table table-striped">

                <%
                    if (user != null) {
                %>
                <thead>
                <tr>
                    <th>用户id</th>
                    <th>用户名 </th>
                    <th>密码 </th>
                    <th>邮箱 </th>
<%--                    <th>工龄 </th>--%>
<%--                    <th>电话</th>--%>
<%--                    <th>地址</th>--%>
<%--                    <th>操作</th>--%>
<%--                    <th><a href="selectEmp?type=insertOne" style="text-decoration: none; color: #000;">新增员工</a></th>--%>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><%=user.getUserId()%>
                    </td>
                    <td><%=user.getUserName()%>
                    </td>
                    <td><%=user.getPassWord()%>
                    </td>
                    <td><%=user.getEmail()%>
                    </td>
                </tr>

                </tbody>

                <%
                }else {

                %>
                <h1 align="center" style="margin-top: 200px">管理员未登录，请先行<a href="login.jsp">登录</a>！</h1>
                <%
                    }
                %>
            </table>
        </div>

        <div class="footer">
            <div class="float-right">
                <strong>2.9.2 inspinia</strong>
            </div>
            <div>
                <strong>Copyright</strong> inspinia 2.9.2 &copy; 2014-2018
            </div>
        </div>

    </div>
</div>

<!-- Mainly scripts -->
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/popper.min.js"></script>
<script src="../js/bootstrap.js"></script>
<script src="../js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="../js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="../js/inspinia.js"></script>
<script src="../js/plugins/pace/pace.min.js"></script>


</body>

</html>
