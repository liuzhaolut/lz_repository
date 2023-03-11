<%@ page import="java.util.List" %>
<%@ page import="com.etc.plant.entity.Plants" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/14
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Teamo - Products Grid</title>
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
</head>
<body class="productsgrid-page">
<jsp:include page="head.jsp"/>
<%--主要内容--%>
<div class="main-content main-content-product no-sidebar">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb-trail breadcrumbs">
                    <ul class="trail-items breadcrumb">
                        <li class="trail-item trail-begin">
                            <a href="go.do=?go=index.jsp">主页</a>
                        </li>
                        <li class="trail-item trail-end active">
                            网格产品
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="content-area shop-grid-content full-width col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="site-main">
                    <h3 class="custom_blog_title">
                        网格产品
                    </h3>
                    <script type="text/javascript">
                        function product1() {
                            var myfrom = document.getElementById("myform");
                            myfrom.action = "getPagePlantsServlet.do";
                            myfrom.method = "get";
                            myfrom.submit();
                        }
                        function product2() {
                            var myfrom = document.getElementById("twoform");
                            myfrom.action = "getPagePlantsServlet.do";
                            myfrom.method = "get";
                            myfrom.submit();
                        }
                    </script>
                    <div class="shop-top-control">
                        <form class="select-item select-form" id="myform">
                            <span class="title">分页</span>
                            <select title="sort" data-placeholder="9 Products/Page" id="product" name="p" class="chosen-select" onchange="product1()">
                                <option value="null">请选择</option>
                                <option value="12">12 Products/Page</option>
                                <option value="4">4 Products/Page</option>
                                <option value="5">5 Products/Page</option>
                                <option value="6">6 Products/Page</option>
                                <option value="8">8 Products/Page</option>

                            </select>
                        </form>
                        <form class="filter-choice select-form" id="twoform">
                            <span class="title">排序</span>
                            <select title="sort-by" data-placeholder="Price: Low to High" name="s" class="chosen-select" onchange="product2()">
                                <option value="null">请选择</option>
                                <option value="全部">全部</option>
                                <option value="畅销">畅销</option>
                                <option value="最受好评">最受好评</option>
                                <option value="新品">新品</option>
                                <option value="今日特价">今日特价</option>
                            </select>
                        </form>
                        <div class="grid-view-mode">
                            <div class="inner">
                                <a href="listproducts.html" class="modes-mode mode-list">
                                    <span></span>
                                    <span></span>
                                </a>
                                <a href="gridproducts.html" class="modes-mode mode-grid  active">
                                    <span></span>
                                    <span></span>
                                    <span></span>
                                    <span></span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <ul class="row list-products auto-clear equal-container product-grid">
                    <%
                        List<Plants> plants = (List<Plants>) request.getAttribute("plant");
                        int page1 = (int) request.getAttribute("page");
                        int up = (int) request.getAttribute("up");
                        int down = (int) request.getAttribute("down");
                        int allPage = (int) request.getAttribute("allPage");
                        for (Plants p: plants
                        ) {
                     %>

                        <li class="product-item  col-lg-3 col-md-4 col-sm-6 col-xs-6 col-ts-12 style-1">
                            <div class="product-inner equal-element">
                                <div class="product-top">
                                    <div class="flash">
                                            <span class="onnew">
                                                <span class="text">
                                                    new
                                                </span>
                                            </span>
                                    </div>
                                </div>
                                <div class="product-thumb">
                                    <div class="thumb-inner">
                                        <a href="getPlantDetailServlet.do?pid=<%=p.getPlant_id()%>">
                                            <img src="<%=p.getPic()%>" alt="img">
                                        </a>
                                        <div class="thumb-group">
                                            <div class="yith-wcwl-add-to-wishlist">
                                                <div class="yith-wcwl-add-button">
                                                    <a href="getPlantDetailServlet.do?pid=<%=p.getPlant_id()%>">添加到收藏</a>
                                                </div>
                                            </div>
                                            <div class="loop-form-add-to-cart">
                                                <a class="single_add_to_cart_button button" href="getPlantDetailServlet.do?pid=<%=p.getPlant_id()%>" methods="post">添加到购物车</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="product-info">
                                    <h5 class="product-name product_title">
                                        <a href="getPlantDetailServlet.do?pid=<%=p.getPlant_id()%>"><%=p.getPlant_name()%></a>
                                    </h5>
                                    <div class="group-info">
                                        <div class="stars-rating">
                                            <div class="star-rating">
                                                <span class="star-3"></span>
                                            </div>
                                            <div class="count-star">
                                                (3)
                                            </div>
                                        </div>
                                        <div class="price">
                                            <del>
                                                $65
                                            </del>
                                            <ins>
                                                $&nbsp;<%=p.getPrice()%>
                                            </ins>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </li>
                             <%
                                }
                            %>

                    </ul>
                    <br/>
                    <div class="nav-link" style="margin-left: 500px">
                        <a href="getPagePlantsServlet.do?page=<%=up%>" class="page-numbers"><i class="icon fa fa-angle-left" aria-hidden="true"></i></a>
                               <%
                                   if (page1 > 1){
                               %>
                                <a href="getPagePlantsServlet.do?page=<%=up%>" style="margin-left:20px">上一页</a>
                                <%
                                   } else if (page1 < allPage){
                               %>
                                <a href="getPagePlantsServlet.do?page=<%=down%>" style="margin-left:20px;margin-right: 20px">下一页</a>
                                <%
                                    }
                                %>
                        <a href="getPagePlantsServlet.do?page=<%=down%>" class="page-numbers"><i class="icon fa fa-angle-right" aria-hidden="true"></i></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="sidebar col-lg-3 col-md-3 col-sm-12 col-xs-12">
            <div class="wrapper-sidebar shop-sidebar">
                <div class="widget woof_Widget">
                    <div class="widget widget-categories">
                        <h3 class="widgettitle">Categories</h3>
                        <ul class="list-categories">
                            <li>
                                <input type="checkbox" id="cb1">
                                <label for="cb1" class="label-text">
                                    New Arrivals
                                </label>
                            </li>
                            <li>
                                <input type="checkbox" id="cb2">
                                <label for="cb2" class="label-text">
                                    Ferns
                                </label>
                            </li>
                            <li>
                                <input type="checkbox" id="cb3">
                                <label for="cb3" class="label-text">
                                    Succulents
                                </label>
                            </li>
                            <li>
                                <input type="checkbox" id="cb4">
                                <label for="cb4" class="label-text">
                                    Cacti
                                </label>
                            </li>
                            <li>
                                <input type="checkbox" id="cb5">
                                <label for="cb5" class="label-text">
                                    Accessories
                                </label>
                            </li>
                            <li>
                                <input type="checkbox" id="cb6">
                                <label for="cb6" class="label-text">
                                    Palms
                                </label>
                            </li>
                        </ul>
                    </div>
                    <div class="widget widget_filter_price">
                        <h4 class="widgettitle">
                            Price
                        </h4>
                        <div class="price-slider-wrapper">
                            <div data-label-reasult="Range:" data-min="0" data-max="3000" data-unit="$" class="slider-range-price " data-value-min="0" data-value-max="1000">
                            </div>
                            <div class="price-slider-amount">
                                <span class="from">$45</span>
                                <span class="to">$215</span>
                            </div>
                        </div>
                    </div>
                    <div class="widget widget-brand">
                        <h3 class="widgettitle">Brand</h3>
                        <ul class="list-brand">
                            <li>
                                <input id="cb7" type="checkbox">
                                <label for="cb7" class="label-text">New Arrivals</label>
                            </li>
                            <li>
                                <input id="cb8" type="checkbox">
                                <label for="cb8" class="label-text">Ferns</label>
                            </li>
                            <li>
                                <input id="cb9" type="checkbox">
                                <label for="cb9" class="label-text">Succulents</label>
                            </li>
                            <li>
                                <input id="cb10" type="checkbox">
                                <label for="cb10" class="label-text">Cacti</label>
                            </li>
                            <li>
                                <input id="cb11" type="checkbox">
                                <label for="cb11" class="label-text">Accessories</label>
                            </li>
                            <li>
                                <input id="cb12" type="checkbox">
                                <label for="cb12" class="label-text">Palms</label>
                            </li>
                        </ul>
                    </div>
                    <div class="widget widget_filter_size">
                        <h4 class="widgettitle">Size</h4>
                        <ul class="list-brand">
                            <li>
                                <input id="cb13" type="checkbox">
                                <label for="cb13" class="label-text">Tiny / 0-15cm</label>
                            </li>
                            <li>
                                <input id="cb14" type="checkbox">
                                <label for="cb14" class="label-text">Small / 15-50cm</label>
                            </li>
                            <li>
                                <input id="cb15" type="checkbox">
                                <label for="cb15" class="label-text">Medium / 50cm-1m</label>
                            </li>
                            <li>
                                <input id="cb16" type="checkbox">
                                <label for="cb16" class="label-text">Tall / 1m-2.8m</label>
                            </li>
                            <li>
                                <input id="cb17" type="checkbox">
                                <label for="cb17" class="label-text">Accessories</label>
                            </li>
                            <li>
                                <input id="cb18" type="checkbox">
                                <label for="cb18" class="label-text">Tiny / 0-15cm</label>
                            </li>
                        </ul>
                    </div>
                    <div class="widget widget-color">
                        <h4 class="widgettitle">
                            Color
                        </h4>
                        <div class="list-color">
                            <a href="#" class="color1"></a>
                            <a href="#" class="color2 "></a>
                            <a href="#" class="color3 active"></a>
                            <a href="#" class="color4"></a>
                            <a href="#" class="color5"></a>
                            <a href="#" class="color6"></a>
                            <a href="#" class="color7"></a>
                        </div>
                    </div>
                    <div class="widget widget-tags">
                        <h3 class="widgettitle">
                            Popular Tags
                        </h3>
                        <ul class="tagcloud">
                            <li class="tag-cloud-link">
                                <a href="#">Variegated</a>
                            </li>
                            <li class="tag-cloud-link">
                                <a href="#">Cacti</a>
                            </li>
                            <li class="tag-cloud-link">
                                <a href="#">Flowering</a>
                            </li>
                            <li class="tag-cloud-link active">
                                <a href="#">Accessories</a>
                            </li>
                            <li class="tag-cloud-link">
                                <a href="#">Hot</a>
                            </li>
                            <li class="tag-cloud-link">
                                <a href="#">Palms</a>
                            </li>
                            <li class="tag-cloud-link">
                                <a href="#">Ferns</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="widget newsletter-widget">
                    <div class="newsletter-form-wrap ">
                        <h3 class="title">Subscribe to Our Newsletter</h3>
                        <div class="subtitle">
                            More special Deals, Events & Promotions
                        </div>
                        <input type="email" class="email" placeholder="Your email letter">
                        <button type="submit" class="button submit-newsletter">Subscribe</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
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