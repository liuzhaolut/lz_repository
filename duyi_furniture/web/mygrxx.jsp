<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/11/10
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/mygrxx.css"/>
</head>
<body><!------------------------------head------------------------------>
<jsp:include page="head.jsp"/>
<!------------------------------idea------------------------------>
<div class="address mt">
    <div class="wrapper clearfix"><a href="index.html" class="fl">首页</a><span>/</span><a href="mygxin.html" class="on">个人信息</a>
    </div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <jsp:include page="bott.jsp"/>
        <div class="you fl"><h2>个人信息</h2>
            <div class="gxin">
                <div class="tx"><a href="#"><img src="img/tx.png"/>
                    <p id="avatar">修改头像</p></a></div>
                <div class="xx"><h3 class="clearfix">
                    <strong class="fl">基础资料</strong>
                    <a href="#" class="fr" id="edit1">编辑</a>
                </h3>
                    <div>姓名：六六六</div>
                    <div>生日：1995-06-06</div>
                    <div>性别：女</div>
                    <h3>高级设置</h3><!--<div><span class="fl">银行卡</span><a href="#" class="fr">管理</a></div>-->
                    <div><span class="fl">账号地区：中国</span><a href="#" class="fr" id="edit2">修改</a></div>
                </div>
            </div>
        </div>
    </div>
</div><!--遮罩-->
<div class="mask"></div><!--编辑弹框-->
<div class="bj">
    <div class="clearfix">
        <a href="#" class="fr gb">
            <img src="img/icon4.png"/>
        </a>
    </div>
    <h3>编辑基础资料</h3>
    <form action="#" method="get"><p><label>姓名：</label><input type="text" value="六六六"/></p>
        <p><label>生日：</label><input type="text"/></p>
        <p><label>性别：</label><span><input type="radio"/>男</span><span><input type="radio"/>女</span></p>
        <div class="bc"><input type="button" value="保存"/><input type="button" value="取消"/></div>
    </form>
</div><!--高级设置修改-->
<div class="xg">
    <div class="clearfix"><a href="#" class="fr gb"><img src="img/icon4.png"/></a></div>
    <h3>切换账号地区</h3>
    <form action="#" method="get"><p><label>姓名：</label><input type="text" value="六六六"/></p>
        <div class="bc"><input type="button" value="保存"/><input type="button" value="取消"/></div>
    </form>
</div><!--修改头像-->
<div class="avatar">
    <div class="clearfix"><a href="#" class="fr gb"><img src="img/icon4.png"/></a></div>
    <h3>修改头像</h3>
    <form action="#" method="get"><h4>请上传图片</h4><input type="button" value="上传头像"/>
        <p>jpg或png，大小不超过2M</p><input type="submit" value="提交"/></form>
</div><!--返回顶部-->
<jsp:include page="right.jsp"/>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
