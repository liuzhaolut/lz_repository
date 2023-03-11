<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/10
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Teamo - Login</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png"/>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,300i,400,400i,700,700i&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
    <link rel="stylesheet" href="assets/css/animate.min.css">
    <link rel="stylesheet" href="assets/css/jquery-ui.css">
    <link rel="stylesheet" href="assets/css/slick.css">
    <link rel="stylesheet" href="assets/css/chosen.min.css">
    <link rel="stylesheet" href="assets/css/pe-icon-7-stroke.css">
    <link rel="stylesheet" href="assets/css/magnific-popup.min.css">
    <link rel="stylesheet" href="assets/css/lightbox.min.css">
    <link rel="stylesheet" href="assets/js/fancybox/source/jquery.fancybox.css">
    <link rel="stylesheet" href="assets/css/jquery.scrollbar.min.css">
    <link rel="stylesheet" href="assets/css/mobile-menu.css">
    <link rel="stylesheet" href="assets/fonts/flaticon/flaticon.css">
    <link rel="stylesheet" href="assets/css/style.css">
<%--    <script src="js/jquery.min.js"></script>--%>
    <script type="text/javascript">
        var flag = false;
        var flag2 = false;
        window.onload= function () {
            <%
            String name = "";
            String password = "";
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for(int i=0; i<cookies.length; i++){
                    if(cookies[i].getName().equals("remember")){
                        String value =  cookies[i].getValue();
                        if(value != null && !"".equals(value)){
                            name = cookies[i].getValue().split("#")[0];
                            if(cookies[i].getValue().split("#")[1] != null && !cookies[i].getValue().split("#")[1].equals("null")){
                                password = cookies[i].getValue().split("#")[1];
                            }
                        }
                    }
                    request.setAttribute("name",name);
                    request.setAttribute("passward",password);
                }
            }
            %>
        }
        function uname() {
            var uname = document.getElementById("username").value;
            if (uname == null || uname ==""){
                alert("用户名不能为空...")
            } else {
                return;
            }
        }
        function password() {
            var pwd = document.getElementById("password").value;
            if (pwd == null || pwd == ""){
                alert("密码不能为空...")
            } else {
                return;
            }
        }

        function judgeName1(){
            var name = document.getElementById("nm").value;
            $.ajax({
                type:"POST",
                url:"judgeNameServlet.do",
                data:"username=" + name,
                success:function(msg) {
                    var usernameSpan = document.getElementById("unameSpan");
                    if (msg == "1") {
                        usernameSpan.innerHTML = "用户名已存在";
                    }else if (msg == "0") {
                        usernameSpan.innerHTML = "用户名合格";
                    } else {
                        usernameSpan.innerHTML = "网络出现异常";
                    }
                }
            });
        }
    </script>
</head>
<body class="inblog-page">
<jsp:include page="head.jsp"/>
<%--    主要内容--%>
<div class="main-content main-content-login">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb-trail breadcrumbs">
                    <ul class="trail-items breadcrumb">
                        <li class="trail-item trail-begin">
                            <a href="index.jsp">主页</a>
                        </li>
                        <li class="trail-item trail-end active">
                            身份验证
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="content-area col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="site-main">
                    <h3 class="custom_blog_title">
                        身份验证
                    </h3>
                    <div class="customer_login">
                        <div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-12">
                                <div class="login-item">
                                    <h5 class="title-login">登录</h5>
                                    <form class="login" action="loginServlet.do?type=${type}" method="post">
                                        <div class="social-account">
                                            <h6 class="title-social">使用社交账号登录</h6>
                                            <a href="#" class="mxh-item facebook">
                                                <i class="icon fa fa-facebook-square" aria-hidden="true"></i>
                                                <span class="text">脸书</span>
                                            </a>
                                            <a href="#" class="mxh-item twitter">
                                                <i class="icon fa fa-twitter" aria-hidden="true"></i>
                                                <span class="text">推特</span>
                                            </a>
                                        </div>
                                        <p class="form-row form-row-wide">
                                            <label class="text">用户名</label>
                                            <input title="username" type="text" name="username" id="username" class="input-text" onblur="uname()" value="<%=name%>">
                                        </p>
                                        <p class="form-row form-row-wide">
                                            <label class="text">密码</label>
                                            <input title="password" type="password" id="password" name="password" class="input-text" onblur="password()" value="<%=password%>" >
                                        </p>
                                        <p class="lost_password">
												<span class="inline">
													<input type="checkbox" id="cb1" name="remember">
													<label for="cb1" class="label-text">记住密码</label>
												</span>
                                            <a href="go.do?go=qpass.jsp" class="forgot-pw">忘记密码 ?</a>
                                        </p>
                                        <p class="form-row">
                                            <input type="submit" class="button-submit" value="登录">
                                        </p>
                                    </form>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-12">
                                <div class="login-item">
                                    <h5 class="title-login">注册</h5>
                                    <form action="" onsubmit="reg();return false;" method="post" class="register">
                                        <p class="form-row form-row-wide">
                                            <label class="text">邮箱</label>
                                            <input title="email" name="email" type="email" class="input-text" id="email1" >
                                        </p>
                                        <p class="form-row form-row-wide">
                                            <label class="text">用户名</label>

                                            <input title="name" id="nm" type="text" class="input-text" onblur="judgeName1()">
                                            <div style="color:red;font-size:10px;" id="unameSpan"></div>
                                        </p>
                                        <p class="form-row form-row-wide">
                                            <label class="text">手机号</label>
                                            <input title="phone" id="userPhone" type="text" class="input-text" >
                                        </p>
                                        <p class="form-row form-row-wide">
                                            <label class="text">密码</label>
                                            <input title="pass" name="pwd" type="password" id="pass1" class="input-text" >
                                        </p>
                                        <p class="form-row form-row-wide">
                                            <input id="smsCode" class="code" type="text" name=""  placeholder="验证码" style="width: 150px">
                                            <span style="display: inline-block; padding: 0px 20px;border: 1px solid #999;border-radius: 5px;height: 40px;
                                                line-height: 40px;margin-left: 10px;cursor: pointer;vertical-align: top;" onclick="sendSms(this)" title="">获取验证码</span>
                                        </p>
                                        <p class="form-row">
                                            <span class="inline">
                                                <input type="checkbox" id="cb2" name="cb2">
                                                <label for="cb2" class="label-text">我同意 <span>Terms & Conditions</span></label>
                                            </span>
                                        </p>
                                        <div class="">
                                            <input type="submit" style="min-width: 64px; height:42px;margin-left: 5px; background-color: #65a15a; color: #ffffff; vertical-align: top; font-size: 14px;border: 0" class="button-submit" value="注册">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    var smsButtonfig = true;
    function sendSms(span) {
        if (smsButtonfig){
            var pohoneRe = /^1(3[0-9]|47[]|5[0123456789]|66[]|7[0-9]|8[0-9]|89[])[0-9]{8}$/g;
            if (!pohoneRe.test(userPhone.value)){
                layer.msg("手机号码有误， 请检查");
                return;
            }
            smsButtonfig = false;
            span.style.color = "#999";
            span.title = "请等待倒计时结束，再次获取";
            var s = 60;
            var iv = setInterval(function () {
                s--;
                span.innerHTML = s + "s";
                if (s == 0){
                    smsButtonfig = true;
                    clearInterval(iv);
                    span.style.color = "";
                    span.title = "点击获取验证码";
                    span.innerHTML = "获取验证码";
                }
            }, 1000)
            //    发送短信
            layer.load();
            $.post("sms.do", "status=1&userPhone=" + userPhone.value,function (data) {
                layer.closeAll();
                layer.msg(data.msg);
            });
        }
    }


    function reg() {
        var choose = document.getElementById("cb2");
        var str = "";//存储选择的value值
        if (choose.checked){
            str = choose.value;
        }
        if (str == null || str == "") {
            alert("请勾选");
            return;
        } else {
            var userphone = document.getElementById("userPhone").value;
            var p1 = document.getElementById("pass1").value;
            var name = document.getElementById("nm").value;
            var email = document.getElementById("email1").value
            var code = document.getElementById("smsCode").value;

            layer.load();
            $.post("regist.do", "userPhone=" + userphone + "&password=" + p1  + "&name=" + name  + "&email=" + email  + "&smsCode=" + code,function (data) {
                layer.closeAll();
                layer.msg(data.msg)
                if (data.status == 200){
                    layer.msg("页面即将跳转到登录");
                    setTimeout(function () {
                        window.location.href = "go.do?go=login.jsp";
                    },1000);
                }
            });
        }

    }

</script>

<script src="assets/js/jquery-1.12.4.min.js"></script>

<script src="assets/js/layer/layer.js"></script>
<jsp:include page="footer.jsp"/>
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