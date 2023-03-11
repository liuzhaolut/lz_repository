
<%--
  Created by IntelliJ IDEA.
  User: 刘昭
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

	<head>

		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<title>人力资源管理系统 | 考勤信息</title>

		<link href="../css/bootstrap.min.css" rel="stylesheet">
		<link href="../font-awesome/css/font-awesome.css" rel="stylesheet">

		<link href="../css/plugins/dataTables/datatables.min.css" rel="stylesheet">

		<link href="../css/animate.css" rel="stylesheet">
		<link href="../css/style.css" rel="stylesheet">
		<script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript">
			function selectApply() {
				var search = document.getElementById("search").value;
				$.ajax({
					url: "apply_operation?operation=search",
					data: "search=" + search,
					type: "post",
					dataType: "JSON",
					async: true,
					success: function (c) {
						var check="<tr>\n" +
								"\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>"+ c.aId +"</td>\n" +
								"\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>"+ c.nowDate +"</td>\n" +
								"\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>"+ c.checkId +"</td>\n" +
								"\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>"+ c.beginDate +"</td>\n" +
								"\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>"+c.endDate+"</td>\n" +
								"\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>"+c.count+"</td>\n" +
								"\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>"+c.commentC+"</td>\n" +
								"\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>"+c.commentZ+"</td>\n" +
								"\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>"+c.commentD+"</td>\n" +
								"\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
								"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"button\" onclick=\"delApply("+c.aId+")\" style=\"padding: 0 10px;border: 1px solid #C9C9C9;margin-right: 15px;color: black;background-color: #F0F0F0;width: 50px;height: 20px;text-align: center\" value=\"销假\" />\n" +
								"\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
								"\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>";
						$("tbody").html(check);
					}, error: function () {

					}
				});
			}

			function delApply(id){
					$.ajax({
						url: "apply_operation?operation=delete",
						data: "aId=" + id,
						dataType: "text",
						type: "post",
						async: true,
						success: function (data) {
							if (data) {
								alert("记录已删除！!");
								location.href = "apply_operation?operation=select";
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
												<input type="text" id="search" class="form-control form-control-sm" placeholder="请输入请假单号">
												<div class="input-group-append">
													<button class="btn btn-sm btn-primary" type="button" onclick="selectApply()">搜索!</button>
												</div>
											</div>
										</div>
									</div>
									<div class="table-responsive">
										<table class="table table-striped">
											<thead>
											<tr>
												<th>请假单ID</th>
												<th>申请时间</th>
												<th>考勤ID</th>
												<th>开始时间 </th>
												<th>结束时间 </th>
												<th>请假天数 </th>
												<th>厂长意见 </th>
												<th>组长意见 </th>
												<th>代理人意见 </th>
												<th>操作</th>
											</tr>
											</thead>
											<tbody>
											<c:if test="${applies != null}">
												<c:forEach var="c" items="${applies}">
													<tr>
														<td>${c.aId}</td>
														<td>${c.nowDate}</td>
														<td>${c.checkId}</td>
														<td>${c.beginDate}</td>
														<td>${c.endDate}</td>
														<td>${c.count}</td>
														<td>${c.commentC}</td>
														<td>${c.commentZ}</td>
														<td>${c.commentD}</td>
														<td>
															<input type="button" onclick="delApply(${c.aId})" style="padding: 0 10px;border: 1px solid #C9C9C9;margin-right: 15px;color: black;background-color: #F0F0F0;width: 50px;height: 20px;text-align: center" value="销假" />
														</td>
													</tr>
												</c:forEach>
											</c:if>

											<c:if test="${applies == null}">
												<h2>${flagCheckAll}</h2>
											</c:if>
											</tbody>
										</table>
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
