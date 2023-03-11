<%@ page import="java.util.List" %>
<%@ page import="com.etc.plant.entity.Collection" %>
<%@ page import="com.etc.plant.entity.Plants" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/15
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Teamo -收藏夹</title>
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
        function addCar(){
            //    获取组件
            var choose = document.getElementsByName("choose");
            var str = [];
            for (var i = 0; i < choose.length; i++) {
                if (choose[i].checked){
                    str += choose[i].value;
                }
            }
            if (str == null || str == ""){
                alert("请选择加入商品...");
                return;
            }
        }


        //全选
        function checkAll() {
            var all = document.getElementById("all");
            var choice = document.getElementsByName("choose");
            for (var i = 0; i < choice.length; i++) {
                choice[i].checked = all.checked;
            }
        }
    </script>
</head>
<body class="inblog-page">

<jsp:include page="head.jsp"/>

<%--主要内容--%>
<div class="site-content">
    <main class="site-main  main-container no-sidebar">
        <div class="container">
            <div class="breadcrumb-trail breadcrumbs">
                <ul class="trail-items breadcrumb">
                    <li class="trail-item trail-begin">
                        <a href="go.do?go=index.jsp">
								<span>
									主页
								</span>
                        </a>
                    </li>
                    <li class="trail-item trail-end active">
							<span>
								收藏夹
							</span>
                    </li>
                </ul>
            </div>
            <div class="row">
                <div class="main-content-cart main-content col-sm-12">
                    <h3 class="custom_blog_title">
                        收藏夹
                    </h3>
                    <%
                        String result = (String) session.getAttribute("result");
                    %>
                    <h6><%=result%></h6>
                    <div class="page-main-content">
                        <div class="shoppingcart-content">
                            <form action="addCarServlet.do" class="cart-form" id="myform">
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
                                           List<Collection> collections = (List<Collection>) session.getAttribute("coll");
                                           List<Plants> plants = (List<Plants>) session.getAttribute("cp");
                                           for (int i = 0; i < collections.size(); i++) {


                                       %>

                                               <tr class="cart_item">
                                                   <td>
                                                       <input type="checkbox" name="choose" value="<%=collections.get(i).getCollection_id()%>"/>
                                                   </td>
                                                   <td class="product-remove">
                                                       <a href="deleteCollServlet.do?cid=<%=collections.get(i).getCollection_id()%>" class="remove"></a>
                                                   </td>
                                                   <td class="product-thumbnail">
                                                       <a href="getPlantDetailServlet.do?pid=<%=plants.get(i).getPlant_id()%>">
                                                           <img src="<%=plants.get(i).getPic()%>" alt="img"
                                                                class="attachment-shop_thumbnail size-shop_thumbnail wp-post-image">
                                                       </a>
                                                   </td>
                                                   <td class="product-name" data-title="Product">
                                                       <a href="getPlantDetailServlet.do?pid=<%=plants.get(i).getPlant_id()%>" class="title"><%=plants.get(i).getPlant_name()%></a>
                                                       <span class="attributes-select attributes-color" name="color"><%=collections.get(i).getColour()%>,</span>
                                                       <span class="attributes-select attributes-size" name="size"><%=collections.get(i).getSize()%></span>
                                                   </td>
                                                   <td class="product-quantity" data-title="Quantity">
                                                       <div class="quantity">
                                                           <div class="control">
                                                               <a class="btn-number qtyminus quantity-minus" href="#">-</a>
                                                               <input type="text" data-step="1" data-min="0" value="1" id="count<%=plants.get(i).getPlant_id()%>" title="Qty"
                                                                      class="input-qty qty" size="4">
                                                               <a href="#" class="btn-number qtyplus quantity-plus">+</a>
                                                           </div>
                                                       </div>
                                                   </td>
                                                   <td class="product-price" data-title="Price">
                                                            <span class="woocommerce-Price-amount amount">
                                                                <span class="woocommerce-Price-currencySymbol">
                                                                    $
                                                                </span>
                                                                <%=plants.get(i).getPrice()%>
                                                            </span>
                                                   </td>
                                               </tr>
                                       <%
                                           }
                                       %>
                                    </tbody>
                                </table>
                                <div class="control-cart">
                                    <button class="button btn-continue-shopping">
                                        <a href="getPagePlantsServlet.do">继续购物</a>
                                    </button>
                                    <button class="button btn-continue-shopping">
                                        <input type="checkbox" id="all" onclick="checkAll()"/>全选
                                    </button>
                                    <button class="button btn-cart-to-checkout">
                                        <input type="submit"onclick="addCar()" value="加入购物车" />
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
