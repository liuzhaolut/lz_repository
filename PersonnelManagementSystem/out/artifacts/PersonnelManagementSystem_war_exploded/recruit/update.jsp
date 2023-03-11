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

    <title>人力资源管理系统   | 修改页面</title>

    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="../css/animate.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/main1.css" rel="stylesheet" type="text/css">
    <link href="../css/reset.css" rel="stylesheet" type="text/css">

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
                <h2>修改页面</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                        <a href="/PersonnelManagementSystem/index.html">主页面</a>
                    </li>
                    <li class="breadcrumb-item active">
                        <strong>修改信息</strong>
                    </li>
                </ol>
            </div>
            <div class="col-sm-8">
                <div class="title-action">
                    <a href="" class="btn btn-primary">这是修改页面</a>
                </div>
            </div>
        </div>

        <div class="wrapper wrapper-content">
            <div class="middle-box text-center animated fadeInRightBig">

                <div class="r_con fr">
                    <div class="reg_title clearfix">
                        <h2 style="color: #0b2e13">招聘信息修改</h2>
                    </div>
                    <div class="reg_form clearfix">
                        <form action="/PersonnelManagementSystem/recruit/recruit?opt=upr" method="post">
                            <input type="hidden" name="reId" value="${recruit.reId}">
                            <ul >
                                <li>
                                    <label style="color: #0a568c">招聘职位:</label>
                                    <input value="${recruit.reName}" type="text" name="reName" id="user_name">
                                    <span class="error_tip">提示信息</span>
                                </li>
                                <li>
                                    <label style="color: #0a568c">招聘人数:</label>
                                    <input value="${recruit.reCount}" type="text" name="reCount" id="pwd">
                                    <span class="error_tip">提示信息</span>
                                </li>
                                <li>
                                    <label style="color: #0a568c">招聘薪资:</label>
                                    <input value="${recruit.reSal}" type="text" name="reSal" id="phone">
                                    <span class="error_tip">提示信息</span>
                                </li>
                                <li>
                                    <label style="color: #0a568c">招聘要求:</label>
                                    <input value="${recruit.reRequirt}" type="text" name="reRequirt" id="">
                                    <span class="error_tip">提示信息</span>
                                </li>
                                <li class="reg_sub">
                                    <input type="submit" value="提交" name="">
                                </li>
                            </ul>
                            <h3 style="color: red">${mes}</h3>
                        </form>
                    </div>

                </div>

            </div>

            </div>



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
