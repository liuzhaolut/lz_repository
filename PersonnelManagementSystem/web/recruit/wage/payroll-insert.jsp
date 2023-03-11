<%--
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

    <title>人力资源管理系统   | 资料页</title>

    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="../css/animate.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <style type="text/css">
        #ui ul li{
            margin-top: 30px;
        }
        .inp{
            position: relative;
            top: 50px;
            left: 250px;

        }
        .lab{
            position: relative;
            top: 50px;
            left: 130px;
            font-size: 20px;
        }
    </style>
</head>

<body class="">
<div id="wrapper">
    <jsp:include page="../head.jsp"></jsp:include>
    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top white-bg" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                    <form role="search" class="navbar-form-custom" action="search_results.html">
                        <div class="form-group">
                            <input type="text" placeholder="请输入搜索内容" class="form-control" name="top-search" id="top-search">
                        </div>
                    </form>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <span class="m-r-sm text-muted welcome-message">欢迎来到人力资源管理系统系统</span>
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
                <h2>薪资新增</h2>
            </div>
            <div class="col-sm-8">
                <div class="title-action">
                    <a href="" class="btn btn-primary">这是行动区</a>
                </div>
            </div>
        </div>

        <div class="wrapper wrapper-content">
            <div id="ui" style="border: 3px solid #1ab394;width: 700px;height: 500px; margin: 0 auto;margin-top: 50px">
                <form method="post" action="/PersonnelManagementSystem/wage/WageServlet?opt=insertSalary">
                    <input type="hidden" name="id" value="${u.salId}">
                    <ul style="list-style: none;line-height: 20px" >
                        <li>
                            <label class="lab">员工id&nbsp;</label>
                            <input class="inp" value="${u.empId}" type="text" name="EmPid" id="id">
                        </li>
                        <li>
                            <label class="lab">加班费</label>
                            <input class="inp" value="${u.overtime}" type="text" name="overtime" id="over_time">
                        </li>
                        <li>
                            <label class="lab">底&nbsp;&nbsp;&nbsp;薪&nbsp;</label>
                            <input class="inp" value="${u.baseSal}" type="text" name="baseSal" id="base_Sal">
                        </li>
                        <li>
                            <label class="lab">提&nbsp;&nbsp;&nbsp;成&nbsp;</label>
                            <input class="inp" value="${u.commission}" type="text" name="commission" id="commission">
                        </li>
                        <li class="reg_sub">
                            <input style="width: 120px;height: 60px;background-color:#1ab394;color: white;position: relative;top: 130px;left: 250px;border: 0 " type="submit" value="录入工资" name="">
                        </li>
                    </ul>
                </form>
            </div>
            <h3 style="color: red">${flag}</h3>
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
