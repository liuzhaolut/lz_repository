<%--

  Created by IntelliJ IDEA.

  User: DELL

  Date: 2020/10/29

  Time: 10:07

  To change this template use File | Settings | File Templates.

--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>

<body><!-------------------login-------------------------->

<div class="login">

    <form action="#" onsubmit="login();return false;" method="post">
        <h1><a href="index.jsp"><img src="img/temp/logo.png"></a></h1>
        <p></p>
        <div class="msg-warn hide"><b></b>公共场所不建议自动登录，以防账号丢失</div>
        <p>
            <input type="text" id="userphone" name="" value="" placeholder="昵称/邮箱/手机号">
        </p>
        <p>
            <input type="password" id="password" style=" border: 1px solid #dbdbdb;font-size: 20px;padding-left: 10px;" name="" value="" placeholder="密码">
        </p>
        <p><input type="submit" name="" value="登  录"></p>
        <p class="txt"><a class="" href="reg.jsp">免费注册</a><a href="forget.jsp">忘记密码？</a></p></form>

</div>
<script>
    function login() {
        layer.load();
        $.post("login.do", "userPhone=" + userphone.value + "&pwd=" + password.value, function (data) {
            layer.closeAll();
            layer.msg(data.msg);
            if (data.status == 200){
                window.location.href = "index.jsp";
            } else if  (data.status == 201){
                window.location.href = data.data;
            }

        });

    }

</script>

<script src="js/jquery-1.12.4.min.js"></script>
<script src="js/layer/layer.js"></script>

</body>

</html>


