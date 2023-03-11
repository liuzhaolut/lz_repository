<%@ page import="com.dy.bean.*" %>
<%@ page import="com.dy.serviceimpl.*" %>
<%@ page import="com.dy.service.*" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/11/10
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>个人信息</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/myorder.css"/>
</head>
<body><!------------------------------head------------------------------>
<jsp:include page="head.jsp"/>
<%
    String orderId = request.getParameter("orderId");
    OrderService orderService = new OrderServiceImpl();
    AddressService addressService = new AddressServiceImpl();
    PaymentsService paymentsService = new PaymentsServiceImpl();
    RegionService regionService = new RegionServiceImpl();
    Order o = orderService.findById(Integer.parseInt(orderId));
    List<OrderGoods> ogs = orderService.findByOrderId(o.getId());
    Address address = addressService.findById(o.getAddressId());
    Payments pay = paymentsService.findById(o.getPaymentId());

%>
<!------------------------------idea------------------------------>
<div class="address mt">
    <div class="wrapper clearfix"><a href="index.jsp" class="fl">首页</a><span>/</span>
        <a href="myorderq.jsp" class="on">我的订单</a><span>/</span>
        <a href="#" class="on">订单详情</a>
    </div>
</div>
<!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <jsp:include page="bott.jsp"/>
        <div class="you fl">
            <div class="my clearfix"><h2>订单详情<a href="#">请谨防钓鱼链接或诈骗电话，了解更多&gt;</a></h2>
                <h3>订单号：<span>578946<%=o.getId()%></span></h3></div>
            <div class="orderList">
                <div class="orderList1"><h3><%=o.getStatus() == 0?"待收货":"已收货"%></h3>
                    <%
                        for (OrderGoods og:ogs
                             ) {
                    %>
                        <div class="clearfix" style="margin-top: 5px">
                            <a href="findGoods.do?goodsId=<%=og.getGoodsId()%>" class="fl">
                                <img  style="width: 87px;height: 87px" src="img/small/<%=og.getGoodsImg()%>"/>
                            </a>
                            <p class="fl">
                                <a href="findGoods.do?goodsId=<%=og.getGoodsId()%>"><%=og.getGoodsName()%></a>
                                <a href="#">¥<%=og.getGoodsPrice()%>×<%=og.getGoodsNum()%></a>
                            </p>
                        </div>
                    <%
                        }
                    %>

                </div>
                <div class="orderList1"><h3>收货信息</h3>
                    <p>姓 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<span><%=address.getUserName()%></span></p>
                    <p>联系电话：<span><%=address.getUserPhone()%></span></p>
                    <p>收货地址：
                        <span>
                            <%=regionService.findByCode(address.getProvinceId() + "").getName()%>&nbsp;
                            <%=regionService.findByCode(address.getCityId() + "").getName()%>&nbsp;
                            <%=regionService.findByCode(address.getAreaId() + "").getName()%>&nbsp;
                            <%=regionService.findByCode(address.getStreetId() + "").getName()%>
                        </span>
                    </p>
                </div>
                <div class="orderList1"><h3>支付方式及送货时间</h3>
                    <p>支付方式：<span><%=pay.getName()%></span></p>
                    <p>送货时间：<span>不限送货时间</span></p></div>
                <div class="orderList1 hei"><h3><strong>商品总价：</strong><span>¥<%=o.getMoney()%></span></h3>
                    <p><strong>运费：</strong><span>¥0</span></p>
                    <p><strong>订单金额：</strong><span>¥<%=o.getMoney()%></span></p>
                    <p><strong>实付金额：</strong><span>¥<%=o.getMoney()%></span></p></div>
            </div>
        </div>
    </div>
</div>
<<!--返回顶部-->
<jsp:include page="right.jsp"/>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>

