<%--
  Created by IntelliJ IDEA.
  User: 刘昭
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>人力资源管理系统    |  工资查看</title>

    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../font-awesome/css/font-awesome.css" rel="stylesheet">

    <!-- Morris -->
    <link href="../css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">
    <link href="../css/animate.css" rel="stylesheet" type="text/css">
    <link href="../css/style.css" rel="stylesheet" type="text/css">

</head>

<body>
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
                        <span class="m-r-sm text-muted welcome-message">欢迎来到人力资源管理系统</span>
                    </li>

                    <li>
                        <a href="/PersonnelManagementSystem/user/user?type=out">
                            <i class="fa fa-sign-out"></i> 注销
                        </a>
                    </li>

                </ul>

            </nav>
        </div>
        <div class="wrapper wrapper-content">
            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox ">
                        <div class="ibox-title">
                            <h5>招聘信息 </h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="/PersonnelManagementSystem/recruit/recruit?opt=deleAll" class="dropdown-item">清空招聘信息</a>
                                    </li>
                                </ul>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div class="row">
                                <div class="col-sm-9 m-b-xs">
                                    <div data-toggle="buttons" class="btn-group btn-group-toggle">
                                        <label class="btn btn-sm btn-white"> <input type="radio" id="option1" name="options"> 天 </label>
                                        <label class="btn btn-sm btn-white active"> <input type="radio" id="option2" name="options"> 周 </label>
                                        <label class="btn btn-sm btn-white"> <input type="radio" id="option3" name="options"> 月 </label>
                                    </div>
                                </div>

                                <script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
                                <script type="text/javascript">
                                    function Search() {
                                        var reName = $("#reName").val();

                                        $.ajax({
                                            url: "/PersonnelManagementSystem/recruit/recruit?opt=dage&reName=" + reName,
                                            type:"get",
                                            dataType:"JSON",
                                            success:function (re) {
                                                var tdStr = "<tr>\n" +
                                                    "                        <td>"+re.reId+"</td>\n" +
                                                    "                        <td>"+re.reName+"</td>\n" +
                                                    "                        <td>"+re.reCount+"</td>\n" +
                                                    "                        <td>"+re.reSal+"</td>\n" +
                                                    "                        <td>"+re.reRequirt+"</td>\n" +
                                                    "\n" +
                                                    "                        <td><a href=\"/PersonnelManagementSystem/recruit/recruit?opt=dele&reId="+re.reId+"\"></i>删除</a></td>\n" +
                                                    "                        <td><a href=\"/PersonnelManagementSystem/recruit/recruit?opt=up&reId="+re.reId+"\"></i>信息修改</a></td>\n" +
                                                    "                    </tr>";
                                                $("tbody").html(tdStr);
                                            },error: function () {
                                                alert("err!!!");
                                            }
                                        });
                                    }
                                </script>

                                <div class="col-sm-3">
                                    <div class="input-group mb-3">
                                        <input type="text" id="reName" class="form-control form-control-sm" placeholder="输入搜索职位"/>
                                        <div class="input-group-append">
                                            <button class="btn btn-sm btn-primary" type="button" onclick="Search()" id="search">搜索!</button>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="table-responsive">

                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>招聘编号</th>
                                        <th>招聘职位</th>
                                        <th>招聘人数</th>
                                        <th>招聘薪资</th>
                                        <th>招聘要求</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${recruits}" var="u">
                                        <tr>
                                            <td>${u.reId}</td>
                                            <td>${u.reName}</td>
                                            <td>${u.reCount}</td>
                                            <td>${u.reSal}</td>
                                            <td>${u.reRequirt}</td>
                                            <td>
                                                <a style="padding: 0 10px;color: #ffffff;font-size: 12px;border: 2px solid dimgrey;background-color: #8f96a0" href="/PersonnelManagementSystem/recruit/recruit?opt=dele&reId=${u.reId}"/>删除信息</a>&nbsp;&nbsp;&nbsp;
                                              <a style="padding: 0 10px;color: #ffffff;font-size: 12px;border: 2px solid dimgrey;background-color: #8f96a0" href="xz.jsp"/>新增职位</a>&nbsp;&nbsp;
                                              <a style="padding: 0 10px;color: #ffffff;font-size: 12px;border: 2px solid dimgrey;background-color: #8f96a0;margin-left: 20px" href="/PersonnelManagementSystem/recruit/recruit?opt=up&reId=${u.reId}">信息修改</a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <%
                                    String tip = (String) request.getAttribute("tip");
                                    if (tip != null){
                                %>

                                <h3 align="center"> <%=tip%> </h3>

                                <%
                                    }
                                %>
                            </div>

                        </div>
                    </div>
                </div>

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
    <div id="right-sidebar">
        <div class="sidebar-container">

            <ul class="nav nav-tabs navs-3">
                <li>
                    <a class="nav-link active" data-toggle="tab" href="#tab-1"> 记录 </a>
                </li>
                <li>
                    <a class="nav-link" data-toggle="tab" href="#tab-2"> 项目 </a>
                </li>
                <li>
                    <a class="nav-link" data-toggle="tab" href="#tab-3"> <i class="fa fa-gear"></i> </a>
                </li>
            </ul>

            <div class="tab-content">


                <div id="tab-1" class="tab-pane active">

                    <div class="sidebar-title">
                        <h3> <i class="fa fa-comments-o"></i> 最新记录</h3>
                        <small><i class="fa fa-tim"></i> 你有10条新消息。</small>
                    </div>

                    <div>

                        <div class="sidebar-message">
                            <a href="#">
                                <div class="float-left text-center">
                                    <img alt="image" class="rounded-circle message-avatar" src="../img/a1.jpg">

                                    <div class="m-t-xs">
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                    </div>
                                </div>
                                <div class="media-body">

                                    Lorem Ipsum的通道有许多变化。
                                    <br>
                                    <small class="text-muted">今天 4:21 pm</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="float-left text-center">
                                    <img alt="image" class="rounded-circle message-avatar" src="../img/a2.jpg">
                                </div>
                                <div class="media-body">
                                    使用Lorem Ipsum的观点是它具有或多或少的正常。
                                    <br>
                                    <small class="text-muted">昨天 2:45 pm</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="float-left text-center">
                                    <img alt="image" class="rounded-circle message-avatar" src="../img/a3.jpg">

                                    <div class="m-t-xs">
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                    </div>
                                </div>
                                <div class="media-body">
                                    这些年来，有时是意外的，有时是有目的的（注入幽默等）。
                                    <br>
                                    <small class="text-muted">昨天 1:10 pm</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="float-left text-center">
                                    <img alt="image" class="rounded-circle message-avatar" src="../img/a4.jpg">
                                </div>

                                <div class="media-body">
                                    Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the
                                    <br>
                                    <small class="text-muted">星期一 8:37 pm</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="float-left text-center">
                                    <img alt="image" class="rounded-circle message-avatar" src="../img/a8.jpg">
                                </div>
                                <div class="media-body">

                                    互联网上的所有Lorem Ipsum发电机往往重复。
                                    <br>
                                    <small class="text-muted">今天 4:21 pm</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="float-left text-center">
                                    <img alt="image" class="rounded-circle message-avatar" src="../img/a7.jpg">
                                </div>
                                <div class="media-body">
                                    再生。 Lorem Ipsum的第一行“Lorem ipsum dolor sit amet ..”来自1.10.32节的一行。
                                    <br>
                                    <small class="text-muted">昨天 2:45 pm</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="float-left text-center">
                                    <img alt="image" class="rounded-circle message-avatar" src="../img/a3.jpg">

                                    <div class="m-t-xs">
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                        <i class="fa fa-star text-warning"></i>
                                    </div>
                                </div>
                                <div class="media-body">
                                    从1500年代以来使用的Lorem Ipsum的标准块转载如下。
                                    <br>
                                    <small class="text-muted">昨天 1:10 pm</small>
                                </div>
                            </a>
                        </div>
                        <div class="sidebar-message">
                            <a href="#">
                                <div class="float-left text-center">
                                    <img alt="image" class="rounded-circle message-avatar" src="../img/a4.jpg">
                                </div>
                                <div class="media-body">
                                    揭开许多网站仍处于起步阶段。 各种版本有。
                                    <br>
                                    <small class="text-muted">星期一 8:37 pm</small>
                                </div>
                            </a>
                        </div>
                    </div>

                </div>

                <div id="tab-2" class="tab-pane">

                    <div class="sidebar-title">
                        <h3> <i class="fa fa-cube"></i> 最新项目</h3>
                        <small><i class="fa fa-tim"></i> 你有14个项目。 10没有完成</small>
                    </div>

                    <ul class="sidebar-list">
                        <li>
                            <a href="#">
                                <div class="small float-right m-t-xs">9小时前</div>
                                <h4>业务估值</h4>
                                一个长期以来的事实是，读者会分心。

                                <div class="small">完成度: 22%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 22%;" class="progress-bar progress-bar-warning"></div>
                                </div>
                                <div class="small text-muted m-t-xs">时间: 4:00 pm - 12.06.2014</div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small float-right m-t-xs">9小时前</div>
                                <h4>与公司签订合同 </h4>
                                许多桌面出版包和网页编辑器。

                                <div class="small">完成度: 48%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 48%;" class="progress-bar"></div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small float-right m-t-xs">9小时前</div>
                                <h4>会议</h4>
                                通过查看其布局时页面的可读内容。

                                <div class="small">完成度: 14%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 14%;" class="progress-bar progress-bar-info"></div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="label label-primary float-right">NEW</span>
                                <h4>生成的</h4>
                                Lorem Ipsum的通道有许多变化。
                                <div class="small">完成度: 22%</div>
                                <div class="small text-muted m-t-xs">时间: 4:00 pm - 12.06.2014</div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small float-right m-t-xs">9小时前</div>
                                <h4>业务估值</h4>
                                一个长期以来的事实是，读者会分心。

                                <div class="small">完成度: 22%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 22%;" class="progress-bar progress-bar-warning"></div>
                                </div>
                                <div class="small text-muted m-t-xs">时间: 4:00 pm - 12.06.2014</div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small float-right m-t-xs">9小时前</div>
                                <h4>与公司签订合同 </h4>
                                许多桌面出版包和网页编辑器。

                                <div class="small">完成度: 48%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 48%;" class="progress-bar"></div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <div class="small float-right m-t-xs">9小时前</div>
                                <h4>会议</h4>
                                通过查看其布局时页面的可读内容。

                                <div class="small">完成度: 14%</div>
                                <div class="progress progress-mini">
                                    <div style="width: 14%;" class="progress-bar progress-bar-info"></div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <span class="label label-primary float-right">NEW</span>
                                <h4>生成的</h4>
                                <!--<div class="small float-right m-t-xs">9小时前</div>-->
                                Lorem Ipsum的通道有许多变化。
                                <div class="small">完成度: 22%</div>
                                <div class="small text-muted m-t-xs">时间: 4:00 pm - 12.06.2014</div>
                            </a>
                        </li>

                    </ul>

                </div>

                <div id="tab-3" class="tab-pane">

                    <div class="sidebar-title">
                        <h3><i class="fa fa-gears"></i> 设置</h3>
                        <small><i class="fa fa-tim"></i> 你有14个项目。 10没有完成</small>
                    </div>

                    <div class="setings-item">
                    <span>
                        显示通知
                    </span>
                        <div class="switch">
                            <div class="onoffswitch">
                                <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="example">
                                <label class="onoffswitch-label" for="example">
                                    <span class="onoffswitch-inner"></span>
                                    <span class="onoffswitch-switch"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="setings-item">
                    <span>
                        停用聊天
                    </span>
                        <div class="switch">
                            <div class="onoffswitch">
                                <input type="checkbox" name="collapsemenu" checked class="onoffswitch-checkbox" id="example2">
                                <label class="onoffswitch-label" for="example2">
                                    <span class="onoffswitch-inner"></span>
                                    <span class="onoffswitch-switch"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="setings-item">
                    <span>
                        启用历史记录
                    </span>
                        <div class="switch">
                            <div class="onoffswitch">
                                <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="example3">
                                <label class="onoffswitch-label" for="example3">
                                    <span class="onoffswitch-inner"></span>
                                    <span class="onoffswitch-switch"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="setings-item">
                    <span>
                        显示图表
                    </span>
                        <div class="switch">
                            <div class="onoffswitch">
                                <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="example4">
                                <label class="onoffswitch-label" for="example4">
                                    <span class="onoffswitch-inner"></span>
                                    <span class="onoffswitch-switch"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="setings-item">
                    <span>
                        离线用户
                    </span>
                        <div class="switch">
                            <div class="onoffswitch">
                                <input type="checkbox" checked name="collapsemenu" class="onoffswitch-checkbox" id="example5">
                                <label class="onoffswitch-label" for="example5">
                                    <span class="onoffswitch-inner"></span>
                                    <span class="onoffswitch-switch"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="setings-item">
                    <span>
                        全球搜索
                    </span>
                        <div class="switch">
                            <div class="onoffswitch">
                                <input type="checkbox" checked name="collapsemenu" class="onoffswitch-checkbox" id="example6">
                                <label class="onoffswitch-label" for="example6">
                                    <span class="onoffswitch-inner"></span>
                                    <span class="onoffswitch-switch"></span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="setings-item">
                    <span>
                        每天更新
                    </span>
                        <div class="switch">
                            <div class="onoffswitch">
                                <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="example7">
                                <label class="onoffswitch-label" for="example7">
                                    <span class="onoffswitch-inner"></span>
                                    <span class="onoffswitch-switch"></span>
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="sidebar-content">
                        <h4>设置</h4>
                        <div class="small">
                            我相信那个 Lorem Ipsum只是印刷和排版行业的虚拟文字。
                            排版行业。 Lorem Ipsum自15世纪15年代以来一直是行业的标准虚拟文本。
                            多年来，有时偶然地，有时是目的（注入幽默等）。
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

<!-- Flot -->
<script src="../js/plugins/flot/jquery.flot.js"></script>
<script src="../js/plugins/flot/jquery.flot.tooltip.min.js"></script>
<script src="../js/plugins/flot/jquery.flot.spline.js"></script>
<script src="../js/plugins/flot/jquery.flot.resize.js"></script>
<script src="../js/plugins/flot/jquery.flot.pie.js"></script>
<script src="../js/plugins/flot/jquery.flot.symbol.js"></script>
<script src="../js/plugins/flot/curvedLines.js"></script>

<!-- Peity -->
<script src="../js/plugins/peity/jquery.peity.min.js"></script>
<script src="../js/demo/peity-demo.js"></script>

<!-- Custom and plugin javascript -->
<script src="../js/inspinia.js"></script>
<script src="../js/plugins/pace/pace.min.js"></script>

<!-- jQuery UI -->
<script src="../js/plugins/jquery-ui/jquery-ui.min.js"></script>

<!-- Jvectormap -->
<script src="../js/plugins/jvectormap/jquery-jvectormap-2.0.2.min.js"></script>
<script src="../js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>

<!-- Sparkline -->
<script src="../js/plugins/sparkline/jquery.sparkline.min.js"></script>

<!-- Sparkline demo data  -->
<script src="../js/demo/sparkline-demo.js"></script>

<!-- ChartJS-->
<script src="../js/plugins/chartJs/Chart.min.js"></script>

<script>
    $(document).ready(function() {


        var d1 = [[1262304000000, 6], [1264982400000, 3057], [1267401600000, 20434], [1270080000000, 31982], [1272672000000, 26602], [1275350400000, 27826], [1277942400000, 24302], [1280620800000, 24237], [1283299200000, 21004], [1285891200000, 12144], [1288569600000, 10577], [1291161600000, 10295]];
        var d2 = [[1262304000000, 5], [1264982400000, 200], [1267401600000, 1605], [1270080000000, 6129], [1272672000000, 11643], [1275350400000, 19055], [1277942400000, 30062], [1280620800000, 39197], [1283299200000, 37000], [1285891200000, 27000], [1288569600000, 21000], [1291161600000, 17000]];

        var data1 = [
            { label: "Data 1", data: d1, color: '#17a084'},
            { label: "Data 2", data: d2, color: '#127e68' }
        ];
        $.plot($("#flot-chart1"), data1, {
            xaxis: {
                tickDecimals: 0
            },
            series: {
                lines: {
                    show: true,
                    fill: true,
                    fillColor: {
                        colors: [{
                            opacity: 1
                        }, {
                            opacity: 1
                        }]
                    },
                },
                points: {
                    width: 0.1,
                    show: false
                },
            },
            grid: {
                show: false,
                borderWidth: 0
            },
            legend: {
                show: false,
            }
        });

        var lineData = {
            labels: ["一月", "二月", "三月", "四月", "五月", "六月", "七月"],
            datasets: [
                {
                    label: "示例数据集1",
                    backgroundColor: "rgba(26,179,148,0.5)",
                    borderColor: "rgba(26,179,148,0.7)",
                    pointBackgroundColor: "rgba(26,179,148,1)",
                    pointBorderColor: "#fff",
                    data: [48, 48, 60, 39, 56, 37, 30]
                },
                {
                    label: "示例数据集2",
                    backgroundColor: "rgba(220,220,220,0.5)",
                    borderColor: "rgba(220,220,220,1)",
                    pointBackgroundColor: "rgba(220,220,220,1)",
                    pointBorderColor: "#fff",
                    data: [65, 59, 40, 51, 36, 25, 40]
                }
            ]
        };

        var lineOptions = {
            responsive: true
        };


        var ctx = document.getElementById("lineChart").getContext("2d");
        new Chart(ctx, {type: 'line', data: lineData, options:lineOptions});


    });
</script>
</body>
</html>

