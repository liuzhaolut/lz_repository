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

    <title>人力资源管理系统   | 新增</title>

    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="../css/animate.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <%--引入js文件--%>
    <script src="ckeditor/ckeditor.js" type="text/javascript" >
    </script>


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
                <h2>新增招聘发布</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="/PersonnelManagementSystem/index.html">新增页面</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>新增</strong>
                    </li>
                </ol>
            </div>
            <div class="col-sm-8">
                <div class="title-action">
                    <a href="" class="btn btn-primary">这是新增页面</a>
                </div>
            </div>
        </div>

        <div class="wrapper wrapper-content">
            <div class="middle-box text-center animated fadeInRightBig">

                <form action="/PersonnelManagementSystem/recruit/recruit?opt=insert" method="post">
                    <table  border="1" width="600px" style="margin-top: -160px;margin-left: -80px">
<%--                        <tr>--%>
<%--                            <td>招聘id:</td>--%>
<%--                            <td><input type="text" name="reId"></td>--%>
<%--                        </tr>--%>
                        <tr>
                            <td>招聘职位:</td>
                            <td><input type="text" name="reName" id="reName" required></td>
                        </tr>
                        <tr>
                            <td>招聘人数:</td>
                            <td><input type="text" name="reCount" id="reCount" required></td>
                        </tr>
                        <tr>
                            <td>招聘薪资:</td>
                            <td><input type="text" name="reSal" id="reSal" required></td>
                        </tr>
                        <tr>
                            <td>招聘要求:</td>
                            <td><textarea  class="ckeditor"  name="reRequirt" cols="30" rows="4"></textarea></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="submit" style="border: 0;width: 100px;height: 60px;background-color: #1ab394; color: white" value="发布招聘信息"/></td>
                        </tr>
                    </table>

                </form>
            </div>
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
