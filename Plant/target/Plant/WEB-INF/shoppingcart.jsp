<%@ page import="java.util.List" %>
<%@ page import="com.etc.plant.entity.Carts" %>
<%@ page import="com.etc.plant.entity.Plants" %>
<%@ page import="com.google.gson.Gson" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/15
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Teamo - Shopping Cart</title>
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
    <script type="text/javascript">
        // // 总和
        function getSum(){
            var sum = 0.0;
            var choice = document.getElementsByName("choice");
            for (var i = 0; i < choice.length; i++) {
                if (choice[i].checked){
                    var id = choice[i].value;
                    var count = document.getElementById("num" + id).innerHTML;
                    var price = document.getElementById("price" + id).innerHTML;
                    sum += parseFloat(Number(count) * Number(price));
                }
            }
            document.getElementById("sumall").innerHTML = sum;
        }

        function getPlantSum(){
            var sum = 0.0;
            var choice = document.getElementsByName("choice");
            for (var i = 0; i < choice.length; i++) {
                if (choice[i].checked){
                    var id = choice[i].value;
                    var count = document.getElementById("num" + id).innerHTML;
                    var price = document.getElementById("price" + id).innerHTML;
                    sum = parseFloat(Number(count) * Number(price));
                    document.getElementById("pall" + id).innerHTML = sum;
                }
            }
        }

        //加减功能
        function cartNumUpdate(type, pid){
            var count = document.getElementById("num" + pid).innerHTML;
            if(count.value >= 50){
                count = 50;
            } else  if(count == 1 && type == -1){
                count = 1;
            } else {
                count = (parseInt(count)) + type;
            }
            //把操作发送给服务器
            $.get("cartNumUpdate.do", "pid=" + pid + "&num=" + type, function (data) {
            })
            document.getElementById("num" + pid).innerHTML = count;
            getSum()
            getPlantSum()
        }

        function chuanzhi() {
            //    获取组件
            var choose = document.getElementsByName("choice");
            var str = "";//存储选择的value值
            for (var i = 0; i < choose.length; i++) {
                if (choose[i].checked){
                    str += choose[i].value;
                }
            }
            if (str == null || str == ""){
                alert("请选择购买的植物...")
                return;
            } else {
                var myfrom = document.getElementById("myform");
                myfrom.action = "submitOrderServlet.do";
                myfrom.method = "POST";
                myfrom.submit();
            }
        }
        
        //全选
        function checkAll() {
            var all = document.getElementById("all");
            var choice = document.getElementsByName("choice");
            for (var i = 0; i < choice.length; i++) {
                choice[i].checked = all.checked;
            }
            getPlantSum()
            getSum()

        }
    </script>
</head>
<body class="inblog-page">
<jsp:include page="head.jsp"/>
<%--只要内容--%>
<div class="site-content">
    <main class="site-main  main-container no-sidebar">
        <div class="container">
            <div class="breadcrumb-trail breadcrumbs">
                <ul class="trail-items breadcrumb">
                    <li class="trail-item trail-begin">
                        <a href="">
								<span>
									主页
								</span>
                        </a>
                    </li>
                    <li class="trail-item trail-end active">
							<span>
								购物车
							</span>
                    </li>
                </ul>
            </div>
            <div class="row">
                <div class="main-content-cart main-content col-sm-12">
                    <h3 class="custom_blog_title">
                        购物车
                    </h3>
                    <%
                        String result = (String) session.getAttribute("result");
                    %>
                    <h6><%=result%></h6>
                    <div class="page-main-content">
                        <div class="shoppingcart-content">
                            <form class="cart-form" id="myform">
                                <table class="shop_table">
                                    <thead>
                                    <tr>
                                        <th class="product-remove"></th>
                                        <th class="product-thumbnail"></th>
                                        <th class="product-name"></th>
                                        <th class="product-price"></th>
                                        <th class="product-quantity"></th>
                                        <th class="product-subtotal"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                        List<Carts> carts = (List<Carts>) session.getAttribute("carts");
                                        List<Plants> plants = (List<Plants>) session.getAttribute("pt");
                                        for (int i = carts.size() - 1; i >= 0 ; i--) {
                                            Carts cart = carts.get(i);
                                            Plants plants1 = plants.get(i);

                                    %>

                                    <thead>
                                    <tr>
                                        <th class="product-remove"></th>
                                        <th class="product-thumbnail"></th>
                                        <th class="product-name"></th>
                                        <th class="product-price"></th>
                                        <th class="product-quantity"></th>
                                        <th class="product-subtotal"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr class="cart_item">
                                        <td>
                                            <input type="checkbox" name="choice" value="<%=plants1.getPlant_id()%>" onclick="getSum()"/>
                                        </td>
                                        <td class="product-remove">
                                            <a href="deleteCarServlet.do?cid=<%=carts.get(i).getCart_id()%>" class="remove"></a>
                                        </td>
                                        <td class="product-thumbnail">
                                            <a href="getPlantDetailServlet.do?pid=<%=plants.get(i).getPlant_id()%>">
                                                <img src="<%=plants1.getPic()%>" alt="img" class="attachment-shop_thumbnail size-shop_thumbnail wp-post-image">
                                            </a>
                                        </td>
                                        <td class="product-name" data-title="Product">
                                            <a href="getPlantDetailServlet.do?pid=<%=plants.get(i).getPlant_id()%>" class="title"><%=plants1.getPlant_name()%></a>
                                            <span class="attributes-select attributes-color" ><%=cart.getColour()%>,</span>
                                            <span class="attributes-select attributes-size" ><%=cart.getSize()%></span>
                                        </td>
                                        <td class="product-quantity" data-title="Quantity">
                                            <div class="quantity">
                                                <div class="control">
                                                    <div class="btn-number qtyminus "  onclick="cartNumUpdate(-1, <%=plants1.getPlant_id()%>,this)">-</div>
                                                    <span title="Qty" class="input-qty qty " id="num<%=plants1.getPlant_id()%>" size="4"><%=cart.getCartNum()%></span>
                                                    <div class="btn-number qtyplus " onclick="cartNumUpdate(1, <%=plants1.getPlant_id()%>,this) ">+</div>
                                                </div>
                                            </div>
                                        </td>
                                        <td class="product-price" data-title="Price">
                                                    <span class="woocommerce-Price-amount amount">
                                                        <span class="woocommerce-Price-currencySymbol">
                                                            ￥
                                                        </span>
                                                        <span id="price<%=plants1.getPlant_id()%>"><%=plants1.getPrice()%></span>
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <span class="woocommerce-Price-currencySymbol">
                                                            ￥
                                                        </span>
                                                        <span id="pall<%=plants1.getPlant_id()%>"><%=cart.getCartNum() * plants1.getPrice()%></span>
                                                    </span>
                                        </td>
                                    </tr>
                                    </tbody>
                                    <%
                                        }
                                    %>
                                    </tbody>
                                </table>
                                <div class="control-cart">
                                    <div class="btn-continue-shopping" style="font-size: 15px;color: black">
                                        总计： ￥<span type="text" id="sumall" name="sumall">0.0</span>
                                    </div>
                                    <br>
                                    <button class="btn-continue-shopping">
                                        <input type="checkbox" id="all" onclick="checkAll()"/>全选
                                    </button>
                                    <button class="btn-continue-shopping">
                                        <a href="getPagePlantsServlet.do">继续购物</a>
                                    </button>
                                    <button class="btn-cart-to-checkout">
                                        <a href="javascript:;" onclick="chuanzhi()">支付</a>
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>
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