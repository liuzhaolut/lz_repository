<%--
  Created by IntelliJ IDEA.
  User: 刘昭
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>人力资源管理系统 | 考勤新增</title>

    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="../css/animate.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <script src="../ck/ckeditor.js" rel="stylesheet"></script>
    <style type="text/css">
        .move_li{
            line-height: 30px;
            padding-right: 40px;
            width: 150px;
        }
        .span2{
            font-weight: bolder;
            position: relative;
            top: -440px;
            left: 145px;
            font-size: 18px;
        }
        .move_li_last{
            position: relative;
            top: -493px;
            left: 350px;
        }

        .span1{
            font-weight: bolder;
            text-align: left;
            position: relative;
            top: -55px;
            left: -400px;
            font-size: 18px;
        }
        .input1{
            width: 200px;
            line-height: 30px;
            margin-left: 50px;
            display: inline-block;
            float: left;
            position: relative;
            top: -65px;
            left: -300px;
        }
        .move_ul{
            list-style: none;
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
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i
                            class="fa fa-bars"></i> </a>
                    <form role="search" class="navbar-form-custom" action="search_results.html">
                        <div class="form-group">
                            <input type="text" placeholder="请输入搜索内容" class="form-control" name="top-search"
                                   id="top-search">
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
                <h2>考勤新增</h2>
                <ol class="breadcrumb">
                    <li class="breadcrumb-item active">
                        <strong style="font-size: 16px">${flag}</strong>
                    </li>
                </ol>
            </div>
            <div class="col-sm-8">
                <div class="title-action">
                    <a href="" class="btn btn-primary">这是行动区</a>
                </div>
            </div>
        </div>

        <div class="wrapper wrapper-content">
            <div class="middle-box text-center animated fadeInRightBig">
                <form action="check_operation?operation=insert" method="post" >
                        <ul class="move_ul" >
                            <p>
                                <li class="move_li">
                                    <span class="span1">员工ID：</span>
                                     <input  class="input1"  type="number" name="empId" required />
                                </li>
                            </p>
                            <p>
                                <li class="move_li">
                                    <span class="span1">员工名称：</span>
                                    <input  class="input1" type="text" name="empName" required />
                             </li >
                            </p>
                            <p>
                                 <li class="move_li">
                                    <span class="span1">部门名称：</span>
                                    <input  class="input1" type="text" name="depName" required />
                                 </li>
                            </p>
                            <p>
                                <li class="move_li">
                                    <span class="span1">上班时间：</span>
                                    <input  class="input1" type="text" name="startDate" disabled />
                                </li>
                            </p>
                            <p>
                                <li class="move_li">
                                    <span class="span1">请假/正常：</span>
                                    <input  class="input1" type="text" placeholder="0/1" name="state" required />
                                 </li>
                            </p>

                            <p>
                                <li class="move_li">
                                    <span class="span2">请假原因：</span>
                                </li>
                                <li class="move_li_last">
                                    <textarea class="ckeditor" name="note" ></textarea>
                                </li>
                            </p>



                        </ul>
                        <br/>

                         <input style="display: inline;width: 130px;height: 60px;font-size:19px;position: relative;top:-434px;left:-100px;background-color: #1ab394;color: white;border-color: #1ab394;" type="reset" value="重置"/>
                        <input style="display: inline;width: 130px;height: 60px;font-size:19px;position: relative;top:-434px;left:150px;background-color: #1ab394;color: white;border-color: #1ab394;" type="submit" value="新增"/>
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

