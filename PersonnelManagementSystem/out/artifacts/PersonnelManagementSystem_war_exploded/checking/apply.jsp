<%@ page import="java.util.Date" %>
<%@ page import="com.person.util.DateUtils" %><%--
  Created by IntelliJ IDEA.
  User: 刘昭
  Date: 2022/6/22
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<title>人事管理系统 | 请假申请</title>

	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<link href="../font-awesome/css/font-awesome.css" rel="stylesheet">

	<link href="../css/plugins/dataTables/datatables.min.css" rel="stylesheet">

	<link href="../css/animate.css" rel="stylesheet">
	<link href="../css/style.css" rel="stylesheet">
	<script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript">
		function delCheck(id){
			alert(id);
			$.ajax({
				url: "check_operation?operation=delete",
				data: "cId=" + id,
				dataType: "text",
				type: "post",
				async: true,
				success: function (data) {
					if (data) {
						alert("记录已删除！!");
						location.href = "check_operation?operation=select";
						window.location.reload();//刷新页面
					}
				}, error: function () {

				}
			});
		}
	</script>
</head>

<body>
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
		<div class="wrapper wrapper-content">
			<div class="row">
				<div class="col-lg-12">
					<div class="ibox ">
						<div class="ibox-title">
							<h5>考勤 </h5>
							<div class="ibox-tools">
								<a class="collapse-link">
									<i class="fa fa-chevron-up"></i>
								</a>
								<a class="dropdown-toggle" data-toggle="dropdown" href="#">
									<i class="fa fa-wrench"></i>
								</a>
								<ul class="dropdown-menu dropdown-user">
									<li><a href="#" class="dropdown-item">Config option 1</a>
									</li>
									<li><a href="#" class="dropdown-item">Config option 2</a>
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
								<div class="col-sm-3">
									<div class="input-group mb-3">
										<input type="text" class="form-control form-control-sm" placeholder="搜索">
										<div class="input-group-append">
											<button class="btn btn-sm btn-primary" type="button">搜索!</button>
										</div>
									</div>
								</div>
							</div>
							<div style="position: relative;top: 20px;left: 400px;margin-bottom: 100px">
								<form action="/PersonnelManagementSystem/checking/apply_operation?operation=insert" method="post">
									<h1 style="width: 550px;text-align: center;margin-bottom: 50px">休假申请单</h1>
									<%
										Date date = new Date();

									%>
									<p>申请日期：<input type="text" name="nowDate" style="border: 0;background-color: #ffffff" value="<%=DateUtils.utilToStr(date)%>" readonly ></p>
									<table border="2" width="700" style="border-collapse:collapse;color: #1ab394;position: relative;top: 20px;left: -60px">
										<tr style="text-align: center">
											<td width="150px">所属部门</td>
											<td><input style="width: 150px;text-align: center;border: 0;background-color: #ffffff" type="text" name="depName"></td>
											<td width="50px">名字</td>
											<td><input style="width: 150px;text-align: center;border: 0;background-color: #ffffff" type="text" name="empName"></td>
											<td width="50px">厂长</td>
											<td colspan="2" height="50px"><input style="width: 150px;text-align: center;border: 0;background-color: #ffffff" type="text" placeholder="同意/不同意" name="comment_c" /></td>
										</tr>
										<tr style="text-align: center">
											<td width="150px" rowspan="2">期间</td>
											<td colspan="3"><input style="width: 150px;text-align: center;border: 0;background-color: #ffffff" type="date" name="begin"> </td>
											<td rowspan="2" colspan="2">天数</td>
											<td rowspan="2" colspan="2"><input style="width: 150px;text-align: center;border: 0;background-color: #ffffff" type="text" name="count"></td>
										</tr>
										<tr style="text-align: center">
											<td colspan="3"><input style="width: 150px;text-align: center;border: 0;background-color: #ffffff" type="date" name="end"></td>
										</tr>
										<tr style="text-align: center">
											<td width="100px" colspan="2">职务代理人</td>
											<td colspan="5" height="50px"><input style="width: 150px;text-align: center;border: 0;background-color: #ffffff" type="text" placeholder="同意/不同意" name="comment_d"></td>
										</tr>
										<tr style="text-align: center">
											<td width="100px" colspan="2">审核意见</td>
											<td width="100px" colspan="2" >组长</td>
											<td rowspan="2" colspan="3"><input style="width: 150px;text-align: center;border: 0;background-color: #ffffff" type="text" placeholder="同意/不同意" name="comment_z"></td>
										</tr>
									</table>
									<input type="submit" value="申请" style="position: relative;top: 80px ;left:250px ;width: 120px;height: 50px;background-color: #1ab394;border: 0;color: #FFFFFF">
								</form>

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
</div>



<!-- Mainly scripts -->
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/popper.min.js"></script>
<script src="../js/bootstrap.js"></script>
<script src="../js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="../js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<script src="../js/plugins/dataTables/datatables.min.js"></script>
<script src="../js/plugins/dataTables/dataTables.bootstrap4.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="../js/inspinia.js"></script>
<script src="../js/plugins/pace/pace.min.js"></script>

<!-- Page-Level Scripts -->
<script>
	$(document).ready(function() {
		$('.dataTables-example').DataTable({
			pageLength: 25,
			responsive: true,
			dom: '<"html5buttons"B>lTfgitp',
			buttons: [{
				extend: 'copy'
			},
				{
					extend: 'csv'
				},
				{
					extend: 'excel',
					title: 'ExampleFile'
				},
				{
					extend: 'pdf',
					title: 'ExampleFile'
				},

				{
					extend: 'print',
					customize: function(win) {
						$(win.document.body).addClass('white-bg');
						$(win.document.body).css('font-size', '10px');

						$(win.document.body).find('table')
								.addClass('compact')
								.css('font-size', 'inherit');
					}
				}
			]

		});

	});
</script>

</body>

</html>
