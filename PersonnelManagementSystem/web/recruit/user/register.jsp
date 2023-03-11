﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>人力资源管理系统   | 注册</title>

    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="../css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="../css/animate.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <script src="../js/jquery-3.1.1.min.js"></script>

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen   animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">IN+</h1>

            </div>
            <h3>注册平台账户</h3>
            <p>创建账户以查看更多功能</p>
            <form class="m-t" id="userForm" role="form" method="post" action="user?type=regist">
                <div class="form-group">
                    <input type="text" class="form-control" name="username" placeholder="用户名" required>
                </div>
                <div class="form-group">
                    <input type="email" class="form-control" name="email" placeholder="电子邮件" required>
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="password" placeholder="密码" required>
                </div>
                <div class="form-group">
                        <div class="checkbox i-checks"><label> <input type="checkbox" name="trim"><i></i> 同意条款和政策 </label></div>
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">注册</button>

                <p class="text-muted text-center"><small>已经有一个帐户?</small></p>
                <a class="btn btn-sm btn-white btn-block" href="/user/login.jsp">登录</a>
            </form>
            <p class="m-t"> <small>Copyright</strong> &copy; 2017-2018</small> </p>
        </div>
    </div>

    <!-- Mainly scripts -->

    <script src="../js/popper.min.js"></script>
    <script src="../js/bootstrap.js"></script>

    <!-- iCheck -->
    <script src="../js/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(document).ready(function(){
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>
</body>

</html>
