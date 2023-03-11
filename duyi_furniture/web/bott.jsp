<%@ page import="com.dy.bean.User" %><%--

  Created by IntelliJ IDEA.

  User: DELL

  Date: 2020/11/10

  Time: 11:12

  To change this template use File | Settings | File Templates.

--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="zuo fl">

    <%
        User user = (User) session.getAttribute("user");
        String urlText = request.getRequestURI().toString();
    %>

    <h3>
        <a href="#">
            <img src="img/tx.png"/>
        </a>
        <p class="clearfix">
            <span class="fl">[<%=user.getNickName() == null?user.getUserPhone():user.getNickName()%>]</span>
            <span class="fr">[退出登录]</span>
        </p>
    </h3>
    <div>
        <h4>我的交易</h4>
        <ul>


            <%
                if (urlText.contains("cart.jsp")) {
            %>
            <li class="on"><a href="javascript:void(0)">我的购物车</a></li>
            <%
            } else {
            %>
            <li><a href="cart.jsp">我的购物车</a></li>
            <%
                }
            %>

            <%
                if (urlText.contains("myorderq.jsp")) {
            %>
            <li class="on"><a href="javascript:void(0)">我的订单</a></li>
            <%
            } else {
            %>
            <li><a href="myorderq.jsp">我的订单</a></li>
            <%
                }
            %>

            <%
                if (urlText.contains("myprod.jsp")) {
            %>
            <li class="on"><a href="javascript:void(0)">评价晒单</a></li>
            <%
            } else {
            %>
            <li><a href="myprod.jsp">评价晒单</a></li>
            <%
                }
            %>

        </ul>
        <h4>个人中心</h4>
        <ul>
            <%
                if (urlText.contains("mygxin.jsp")) {
            %>
            <li class="on"><a href="javascript:void(0)">我的中心</a></li>
            <%
            } else {
            %>
            <li><a href="mygxin.jsp">我的中心</a></li>
            <%
                }
            %>

            <%
                if (urlText.contains("address.jsp")) {
            %>
            <li class="on"><a href="javascript:void(0)">地址管理</a></li>
            <%
            } else {
            %>
            <li><a href="address.jsp">地址管理</a></li>
            <%
                }
            %>

        </ul>
        <h4>账户管理</h4>
        <ul>
            <%
                if (urlText.contains("mygrxx.jsp")) {
            %>
            <li class="on"><a href="javascript:void(0)">个人信息</a></li>
            <%
            } else {
            %>
            <li><a href="mygrxx.jsp">个人信息</a></li>
            <%
                }
            %>

            <%
                if (urlText.contains("remima.jsp")) {
            %>
            <li class="on"><a href="javascript:void(0)">修改密码</a></li>
            <%
            } else {
            %>
            <li><a href="remima.jsp">修改密码</a></li>
            <%
                }
            %>
        </ul>
    </div>
</div>


