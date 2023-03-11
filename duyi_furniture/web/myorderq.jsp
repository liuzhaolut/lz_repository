<%@ page import="com.dy.service.OrderService" %>
<%@ page import="com.dy.serviceimpl.OrderServiceImpl" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.dy.service.AddressService" %>
<%@ page import="com.dy.serviceimpl.AddressServiceImpl" %>
<%@ page import="com.dy.service.PaymentsService" %>
<%@ page import="com.dy.serviceimpl.PaymentsServiceImpl" %>
<%@ page import="com.dy.bean.*" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/11/9
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>渡一</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/myorder.css"/>
</head>
<body><!------------------------------head------------------------------>
<%@include file="head.jsp"%>
<%
    OrderService orderService = new OrderServiceImpl();
    // 用户订单集合
    List<Order> orders = orderService.findByUserId(user.getId());

    // 用户商品集合
%>
<!------------------------------idea------------------------------>
<div class="address mt">
    <div class="wrapper clearfix"><a href="#" class="fl">首页</a><span>/</span><a
            href="mygxin.jsp">个人中心</a><span>/</span><a href="myorderq.jsp" class="on">我的订单</a></div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <jsp:include page="bott.jsp"/>
        <div class="you fl">
            <div class="my clearfix"><h2 class="fl">我的订单</h2><a href="#" class="fl">请谨防钓鱼链接或诈骗电话，了解更多&gt;</a></div>
            <div class="dlist clearfix">
                <ul class="fl clearfix" id="wa">
                    <li class="on"><a href="#2">全部有效订单</a></li>
                    <li><a href="#2">待支付</a></li>
                    <li><a href="#2l">待收货</a></li>
                    <li><a href="#2">已关闭</a></li>
                </ul>
                <form action="#" method="get" class="fr clearfix">
                    <input type="text" name="" value="" placeholder="请输入商品名称、订单号"/>
                    <input type="button" name="" id="" value=""/>
                </form>
            </div>
            <%
                AddressService addressService = new AddressServiceImpl();
                PaymentsService paymentsService = new PaymentsServiceImpl();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                for (Order o:orders
                     ) {
                    Address address = addressService.findById(o.getAddressId());
                    Payments payments = paymentsService.findById(o.getPaymentId());
                    List<OrderGoods> orderGoods = orderService.findByOrderId(o.getId());
            %>
                <div class="dkuang"><p class="one"><%=o.getStatus() == 0?"配送中":"已收货"%></p>
                    <div class="word clearfix">
                        <ul class="fl clearfix">
                            <li><%=simpleDateFormat.format(o.getCreateTime())%></li>
                            <li><%=address.getUserName()%></li>
                            <li>订单号:578946<%=o.getId()%></li>
                            <li><%=payments.getName()%></li>
                        </ul>
                        <p class="fr">订单金额：<span><%=o.getMoney()%></span>元</p></div>
                    <%
                        for (int i = 0; i < orderGoods.size(); i++) {
                            OrderGoods og = orderGoods.get(i);
                    %>
                        <div class="shohou clearfix">
                            <a href="findGoods.do?gooodsId=<%=og.getGoodsId()%>" class="fl">
                                <img src="img/small/<%=og.getGoodsImg()%>"/>
                            </a>
                            <p class="fl">
                                <a href="findGoods.do?gooodsId=<%=og.getGoodsId()%>"><%=og.getGoodsName()%></a>
                                <a href="#">¥<%=og.getGoodsPrice()%>×<%=og.getGoodsNum()%></a>
                            </p>
                            <%
                                if (i == orderGoods.size()-1){
                            %>
                            <p class="fr">
                                <%
                                    if (o.getStatus() == 1 ){
                                        if (o.getIsAppraise() == 0){
                                %>
                                     <a href="myprod.jsp">待评价</a>
                                <%
                                         } else {
                                %>
                                     <a href="javascript:void(0)">已评价</a>
                                <%
                                         }
                                    }
                                %>

                                <a href="orderxq.jsp?orderId=<%=og.getId()%>">订单详情</a>
                            </p>
                            <%
                                }
                            %>
                            </div>
                    <%
                        }
                    %>
                </div>
            <%
                }
            %>
            <div class="fenye clearfix"><a href="#"><img src="img/zuo.jpg"/></a><a href="#">1</a><a href="#"><img
                    src="img/you.jpg"/></a></div>
        </div>
    </div>
</div><!--返回顶部-->
<jsp:include page="right.jsp"/>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>

