<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/20
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="assets/css/style.css">
    <script src="js/jquery.min.js"></script>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body class="inblog-page">
    <div class="panel admin-panel" >
        <div class="panel-head"><strong><span class="icon-key"></span> 修改密码</strong></div>
        <div class="body-content">
            <form method="post" class="form-x" action="updatePwdServlet.do">
                <div class="form-group">
                    <div class="label" >
                        <label >用户帐号：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input-text" id="mname" name="mname" size="50" placeholder="请输入用户名" data-validate="required:请输入用户名,length<=0:用户名不为空" style="font-size: 12px"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label" >
                        <label >新密码：</label>
                    </div>
                    <div class="field">
                        <input type="password" class="input-text" name="newpass" size="50" placeholder="请输入新密码" data-validate="required:请输入新密码,length#>=5:新密码不能小于5位" style="font-size: 12px"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label >确认新密码：</label>
                    </div>
                    <div class="field">
                        <input type="password" class="input-text" name="renewpass" size="50" placeholder="请再次输入新密码" data-validate="required:请再次输入新密码,repeat#newpass:两次输入的密码不一致" style="font-size: 12px"/>
                    </div>
                </div>
                <p class="form-group" style="margin-left: 350px">
                    <input type="submit" class="button-submit" value="修改">
                </p>
            </form>
        </div>
    </div>
<a href="#" class="backtotop">
    <i class="fa fa-angle-double-up"></i>
</a>
<script src="assets/js/jquery-1.12.4.min.js"></script>
<script src="assets/js/jquery.plugin-countdown.min.js"></script>
<script src="assets/js/jquery-countdown.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/owl.carousel.min.js"></script>
<script src="assets/js/magnific-popup.min.js"></script>
<script src="assets/js/isotope.min.js"></script>
<script src="assets/js/jquery.scrollbar.min.js"></script>
<script src="assets/js/jquery-ui.min.js"></script>
<script src="assets/js/mobile-menu.js"></script>
<script src="assets/js/chosen.min.js"></script>
<script src="assets/js/slick.js"></script>
<script src="assets/js/jquery.elevateZoom.min.js"></script>
<script src="assets/js/jquery.actual.min.js"></script>
<script src="assets/js/fancybox/source/jquery.fancybox.js"></script>
<script src="assets/js/lightbox.min.js"></script>
<script src="assets/js/owl.thumbs.min.js"></script>
<script src="assets/js/jquery.scrollbar.min.js"></script>
<script src='https://ditu.google.cn/maps/api/js?key=AIzaSyC3nDHy1dARR-Pa_2jjPCjvsOR4bcILYsM'></script>
<script src="assets/js/frontend-plugin.js"></script>
</body>
</html>
