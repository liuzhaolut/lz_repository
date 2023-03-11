<%@ page import="com.etc.plant.service.PlantService" %>
<%@ page import="com.etc.plant.service.impl.PlantServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.etc.plant.entity.Plants" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/10
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Teamo - Home</title>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png"/>
  <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i&display=swap"
        rel="stylesheet">
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

  </script>
</head>
<body class="home">
<%
  ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
  PlantService plantService = (PlantServiceImpl) context.getBean("plantServiceImpl");
  List<Plants> plants = plantService.getTodayPlant();
  List<Plants> bestgoods = plantService.getGoodPlant();
  List<Plants> newgoods = plantService.getNewPlant();
  List<Plants> toprated = plantService.getTopPlant();
  session.setAttribute("toprated", toprated);
%>
<%@include file="head.jsp"%>
<%--主要内容--%>
<div>
  <div class="fullwidth-template">
    <div class="home-slider-banner">
      <div class="container">
        <div class="row10">
          <div class="col-lg-8 silider-wrapp">
            <div class="home-slider">
              <div class="slider-owl owl-slick equal-container nav-center"
                   data-slick='{"autoplay":true, "autoplaySpeed":9000, "arrows":false, "dots":true, "infinite":true, "speed":1000, "rows":1}'
                   data-responsive='[{"breakpoint":"2000","settings":{"slidesToShow":1}}]'>
                <div class="slider-item style7">
                  <div class="slider-inner equal-element">
                    <div class="slider-infor">
                      <h5 class="title-small">
                        四&nbsp;折&nbsp;优&nbsp;惠&nbsp;!
                      </h5>
                      <h3 class="title-big">
                        植物的健康
                      </h3>
                      <div class="price">
                        价格:
                        <span class="number-price">
                            $270.00
                        </span>
                      </div>
                      <a href="#" class="button btn-shop-the-look bgroud-style">立即购买</a>
                    </div>
                  </div>
                </div>
                <div class="slider-item style8">
                  <div class="slider-inner equal-element">
                    <div class="slider-infor">
                      <h5 class="title-small">
                        此种植物
                      </h5>
                      <h3 class="title-big">
                        现在下订单可以打八折
                      </h3>
                      <div class="price">
                        价格:
                        <span class="number-price">
                            $170.00
                        </span>
                      </div>
                      <a href="#" class="button btn-shop-product">立即购买</a>
                    </div>
                  </div>
                </div>
                <div class="slider-item style9">
                  <div class="slider-inner equal-element">
                    <div class="slider-infor">
                      <h5 class="title-small">
                        最佳收藏
                      </h5>
                      <h3 class="title-big">
                       灵感的植物
                      </h3>
                      <div class="price">
                        价格:
                        <span class="number-price">
                            $250.00
                        </span>
                      </div>
                      <a href="#" class="button btn-chekout">立即购买</a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-4 banner-wrapp">
            <div class="banner">
              <div class="item-banner style7">
                <div class="inner">
                  <div class="banner-content">
                    <h3 class="title">悬挂的 <br/>植物</h3>
                    <div class="description">
                      Adipiscing elit curabitur senectus sem
                    </div>
                    <a href="#" class="button btn-lets-do-it">立即购买</a>
                  </div>
                </div>
              </div>
            </div>
            <div class="banner">
              <div class="item-banner style8">
                <div class="inner">
                  <div class="banner-content">
                    <h3 class="title">生长的 <br/> 兰花</h3>
                    <div class="description">
                      Cras pulvinar lorem ipsum dolor conse
                    </div>
                    <span class="price">$379.00</span>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="teamo-product produc-featured rows-space-65">
    <div class="container">
      <h3 class="custommenu-title-blog">
        今日特价
      </h3>
      <div class="owl-products owl-slick equal-container nav-center"
           data-slick='{"autoplay":false, "autoplaySpeed":1000, "arrows":false, "dots":true, "infinite":false, "speed":800, "rows":1}'
           data-responsive='[{"breakpoint":"2000","settings":{"slidesToShow":4}},{"breakpoint":"1200","settings":{"slidesToShow":3}},{"breakpoint":"992","settings":{"slidesToShow":2}},{"breakpoint":"480","settings":{"slidesToShow":1}}]'>
       <%
         for (Plants p: plants
              ) {
       %>
        <div class="product-item style-5">
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
                      <a href="getPlantDetailServlet.do?pid=<%=p.getPlant_id()%>" methods="post">添加到收藏</a>
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
        </div>
      <%
         }
       %>

      </div>
    </div>
  </div>

  <div class="banner-wrapp">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 col-md-6 col-sm-12">
          <div class="banner">
            <div class="item-banner style4">
              <div class="inner">
                <div class="banner-content">
                  <h4 class="teamo-subtitle">顶级员工的选择</h4>
                  <h3 class="title">商店的仙人掌</h3>
                  <div class="description">
                    这是一项必然的选择
                  </div>
                  <a href="#" class="button btn-shop-now">立即购买</a>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-lg-6 col-md-6 col-sm-12">
          <div class="banner">
            <div class="item-banner style5">
              <div class="inner">
                <div class="banner-content">
                  <h3 class="title">室内生活的<br/>植物</h3>
                  <span class="code">
                      使用代码:
                      <span>
                          TEAMO
                      </span>
                      所有的商品都可以打八五折!
                  </span>
                  <a href="#" class="button btn-shop-now">立即购买</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="banner-wrapp rows-space-65">
    <div class="container">
      <div class="banner">
        <div class="item-banner style17">
          <div class="inner">
            <div class="banner-content">
              <h3 class="title">生物生长</h3>
              <div class="description">
               你还没有添加到购物车 & 你准备一起成长吗? <br/> 来和我们一起购物吧
              </div>
              <div class="banner-price">
                价格:
                <span class="number-price">$45.00</span>
              </div>
              <a href="#" class="button btn-shop-now">立即购买</a>
              <a href="#" class="button btn-view-collection">查看更多</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="teamo-tabs  default rows-space-40">
    <div class="container">
      <div class="tab-head">
        <ul class="tab-link">
          <li class="active">
            <a data-toggle="tab" aria-expanded="true" href="#bestseller">畅销</a>
          </li>
          <li class="">
            <a data-toggle="tab" aria-expanded="true" href="#new_arrivals">新品 </a>
          </li>
          <li class="">
            <a data-toggle="tab" aria-expanded="true" href="#top-rated">最受好评</a>
          </li>
        </ul>
      </div>
      <div class="tab-container">
          <div id="bestseller" class="tab-panel active">
            <div class="teamo-product">
              <ul class="row list-products auto-clear equal-container product-grid">
                <%
                  for (Plants p: bestgoods
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
                              <a href="getPlantDetailServlet.do?pid=<%=p.getPlant_id()%>" methods="post">添加到收藏</a>
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
          </div>
        </div>

        <div id="new_arrivals" class="tab-panel">
          <div class="teamo-product">
            <ul class="row list-products auto-clear equal-container product-grid">
              <%
                for (Plants p: newgoods
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
                            <a href="getPlantDetailServlet.do?pid=<%=p.getPlant_id()%>" methods="post">添加到收藏</a>
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
          </div>
        </div>

        <div id="top-rated" class="tab-panel">
          <div class="teamo-product">
            <ul class="row list-products auto-clear equal-container product-grid">
              <%
                for (Plants p: toprated
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
                            <a href="getPlantDetailServlet.do?pid=<%=p.getPlant_id()%>" methods="post">添加到收藏</a>
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
          </div>
        </div>
      </div>
    </div>
  </div>

  <div class="teamo-iconbox-wrapp default">
    <div class="container">
      <div class="row">
        <div class="col-sm-12 col-xs-12">
          <div class="teamo-iconbox default">
            <div class="iconbox-inner">
              <div class="icon">
                <span class="flaticon-delivery-truck"></span>
              </div>
              <div class="content">
                <h4 class="title">
                  订购超过90美元，免费送货
                </h4>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="teamo-blog-wraap default">
    <div class="container">
      <h3 class="custommenu-title-blog">
        我们的最新消息
      </h3>
      <div class="teamo-blog default">
        <div class="owl-slick equal-container nav-center"
             data-slick='{"autoplay":false, "autoplaySpeed":1000, "arrows":false, "dots":true, "infinite":true, "speed":800, "rows":1}'
             data-responsive='[{"breakpoint":"2000","settings":{"slidesToShow":3}},{"breakpoint":"1200","settings":{"slidesToShow":3}},{"breakpoint":"992","settings":{"slidesToShow":2}},{"breakpoint":"768","settings":{"slidesToShow":2}},{"breakpoint":"481","settings":{"slidesToShow":1}}]'>
          <div class="teamo-blog-item equal-element layout1">
            <div class="post-thumb">
              <a href="#">
                <img src="assets/images/slider-blog-thumb-1.jpg" alt="img">
              </a>
              <div class="category-blog">
                <ul class="list-category">
                  <li class="category-item">
                    <a href="#">Skincare</a>
                  </li>
                </ul>
              </div>
              <div class="post-item-share">
                <a href="#" class="icon">
                  <i class="fa fa-share-alt" aria-hidden="true"></i>
                </a>
                <div class="box-content">
                  <a href="#">
                    <i class="fa fa-facebook"></i>
                  </a>
                  <a href="#">
                    <i class="fa fa-twitter"></i>
                  </a>
                  <a href="#">
                    <i class="fa fa-google-plus"></i>
                  </a>
                  <a href="#">
                    <i class="fa fa-pinterest"></i>
                  </a>
                  <a href="#">
                    <i class="fa fa-linkedin"></i>
                  </a>
                </div>
              </div>
            </div>
            <div class="blog-info">
              <div class="blog-meta">
                <div class="post-date">
                  Agust 17, 09:14 am
                </div>
                <span class="view">
                                          <i class="icon fa fa-eye" aria-hidden="true"></i>
                                          631
                                      </span>
                <span class="comment">
                                          <i class="icon fa fa-commenting" aria-hidden="true"></i>
                                          84
                                      </span>
              </div>
              <h2 class="blog-title">
                <a href="#">We bring you the best </a>
              </h2>
              <div class="main-info-post">
                <p class="des">
                  Phasellus condimentum nulla a arcu lacinia, a venenatis ex congue.
                  Mauris nec ante magna.
                </p>
                <a class="readmore" href="#">Read more</a>
              </div>
            </div>
          </div>
          <div class="teamo-blog-item equal-element layout1">
            <div class="post-thumb">
              <a href="#">
                <img src="assets/images/slider-blog-thumb-2.jpg" alt="img">
              </a>
              <div class="category-blog">
                <ul class="list-category">
                  <li class="category-item">
                    <a href="#">HOW TO</a>
                  </li>
                </ul>
              </div>
              <div class="post-item-share">
                <a href="#" class="icon">
                  <i class="fa fa-share-alt" aria-hidden="true"></i>
                </a>
                <div class="box-content">
                  <a href="#">
                    <i class="fa fa-facebook"></i>
                  </a>
                  <a href="#">
                    <i class="fa fa-twitter"></i>
                  </a>
                  <a href="#">
                    <i class="fa fa-google-plus"></i>
                  </a>
                  <a href="#">
                    <i class="fa fa-pinterest"></i>
                  </a>
                  <a href="#">
                    <i class="fa fa-linkedin"></i>
                  </a>
                </div>
              </div>
            </div>
            <div class="blog-info">
              <div class="blog-meta">
                <div class="post-date">
                  Agust 17, 09:14 am
                </div>
                <span class="view">
                                          <i class="icon fa fa-eye" aria-hidden="true"></i>
                                          631
                                      </span>
                <span class="comment">
                                          <i class="icon fa fa-commenting" aria-hidden="true"></i>
                                          84
                                      </span>
              </div>
              <h2 class="blog-title">
                <a href="#">We know that buying Cars</a>
              </h2>
              <div class="main-info-post">
                <p class="des">
                  Using Lorem Ipsum allows designers to put together layouts
                  and the form content
                </p>
                <a class="readmore" href="#">Read more</a>
              </div>
            </div>
          </div>
          <div class="teamo-blog-item equal-element layout1">
            <div class="post-thumb">
              <div class="video-teamo-blog">
                <figure>
                  <img src="assets/images/slider-blog-thumb-3.jpg" alt="img" width="370"
                       height="280">
                </figure>
                <a class="quick-install" href="#" data-videosite="vimeo"
                   data-videoid="134060140"></a>
              </div>
              <div class="category-blog">
                <ul class="list-category">
                  <li class="category-item">
                    <a href="#">VIDEO</a>
                  </li>
                </ul>
              </div>
              <div class="post-item-share">
                <a href="#" class="icon">
                  <i class="fa fa-share-alt" aria-hidden="true"></i>
                </a>
                <div class="box-content">
                  <a href="#">
                    <i class="fa fa-facebook"></i>
                  </a>
                  <a href="#">
                    <i class="fa fa-twitter"></i>
                  </a>
                  <a href="#">
                    <i class="fa fa-google-plus"></i>
                  </a>
                  <a href="#">
                    <i class="fa fa-pinterest"></i>
                  </a>
                  <a href="#">
                    <i class="fa fa-linkedin"></i>
                  </a>
                </div>
              </div>
            </div>
            <div class="blog-info">
              <div class="blog-meta">
                <div class="post-date">
                  Agust 17, 09:14 am
                </div>
                <span class="view">
                      <i class="icon fa fa-eye" aria-hidden="true"></i>
                          631
                </span>
                <span class="comment">
                                          <i class="icon fa fa-commenting" aria-hidden="true"></i>
                                          84
                                      </span>
              </div>
              <h2 class="blog-title">
                <a href="#">We design functional Cars</a>
              </h2>
              <div class="main-info-post">
                <p class="des">
                  Risus non porta suscipit lobortis habitasse felis, aptent
                  interdum pretium ut.
                </p>
                <a class="readmore" href="#">Read more</a>
              </div>
            </div>
          </div>
          <div class="teamo-blog-item equal-element layout1">
            <div class="post-thumb">
              <a href="#">
                <img src="assets/images/slider-blog-thumb-4.jpg" alt="img">
              </a>
              <div class="category-blog">
                <ul class="list-category">
                  <li class="category-item">
                    <a href="#">Skincare</a>
                  </li>
                </ul>
              </div>
              <div class="post-item-share">
                <a href="#" class="icon">
                  <i class="fa fa-share-alt" aria-hidden="true"></i>
                </a>
                <div class="box-content">
                  <a href="#">
                    <i class="fa fa-facebook"></i>
                  </a>
                  <a href="#">
                    <i class="fa fa-twitter"></i>
                  </a>
                  <a href="#">
                    <i class="fa fa-google-plus"></i>
                  </a>
                  <a href="#">
                    <i class="fa fa-pinterest"></i>
                  </a>
                  <a href="#">
                    <i class="fa fa-linkedin"></i>
                  </a>
                </div>
              </div>
            </div>
            <div class="blog-info">
              <div class="blog-meta">
                <div class="post-date">
                  Agust 17, 09:14 am
                </div>
                <span class="view">
                                          <i class="icon fa fa-eye" aria-hidden="true"></i>
                                          631
                                      </span>
                <span class="comment">
                                          <i class="icon fa fa-commenting" aria-hidden="true"></i>
                                          84
                                      </span>
              </div>
              <h2 class="blog-title">
                <a href="#">We know that buying Cars</a>
              </h2>
              <div class="main-info-post">
                <p class="des">
                  Class integer tellus praesent at torquent cras, potenti erat fames
                  volutpat etiam.
                </p>
                <a class="readmore" href="#">Read more</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</div>
<div class="instagram-wrapp">
  <div>
    <h3 class="custommenu-title-blog">
      <i class="flaticon-instagram" aria-hidden="true"></i>
      美图展示
    </h3>
    <div class="teamo-instagram">
      <div class="instagram owl-slick equal-container"
           data-slick='{"autoplay":false, "autoplaySpeed":1000, "arrows":false, "dots":false, "infinite":true, "speed":800, "rows":1}'
           data-responsive='[{"breakpoint":"2000","settings":{"slidesToShow":5}},{"breakpoint":"1200","settings":{"slidesToShow":4}},{"breakpoint":"992","settings":{"slidesToShow":3}},{"breakpoint":"768","settings":{"slidesToShow":2}},{"breakpoint":"481","settings":{"slidesToShow":2}}]'>
        <div class="item-instagram">
          <a href="#">
            <img src="assets/images/item-instagram-1.jpg" alt="img">
          </a>
          <span class="text">
                        <i class="icon flaticon-instagram" aria-hidden="true"></i>
			        </span>
        </div>
        <div class="item-instagram">
          <a href="#">
            <img src="assets/images/item-instagram-2.jpg" alt="img">
          </a>
          <span class="text">
                        <i class="icon flaticon-instagram" aria-hidden="true"></i>
			        </span>
        </div>
        <div class="item-instagram">
          <a href="#">
            <img src="assets/images/item-instagram-3.jpg" alt="img">
          </a>
          <span class="text">
                        <i class="icon flaticon-instagram" aria-hidden="true"></i>
			        </span>
        </div>
        <div class="item-instagram">
          <a href="#">
            <img src="assets/images/item-instagram-4.jpg" alt="img">
          </a>
          <span class="text">
                        <i class="icon flaticon-instagram" aria-hidden="true"></i>
			        </span>
        </div>
        <div class="item-instagram">
          <a href="#">
            <img src="assets/images/item-instagram-5.jpg" alt="img">
          </a>
          <span class="text">
                        <i class="icon flaticon-instagram" aria-hidden="true"></i>
			        </span>
        </div>
      </div>
    </div>
  </div>
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
