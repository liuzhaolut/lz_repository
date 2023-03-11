<%@ page import="java.util.List" %>
<%@ page import="com.etc.plant.entity.Plants" %>
<%@ page import="com.etc.plant.entity.Order" %>
<%@ page import="com.etc.plant.entity.User" %>
<%@ page import="com.etc.plant.service.CommentService" %>
<%@ page import="com.etc.plant.service.impl.CommentServiceImpl" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="com.etc.plant.entity.Comment" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/15
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Teamo - Details Right Sidebar</title>
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
    <script src="assets/js/jquery-1.12.4.min.js"></script>
    <script src="assets/js/layer/layer.js"></script>

</head>
<body class="details-page">
<%@include file="head.jsp"%>
<%--主要内容--%>
<div class="main-content main-content-details single right-sidebar">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb-trail breadcrumbs">
                    <ul class="trail-items breadcrumb">
                        <li class="trail-item trail-begin">
                            <a href="index.jsp">主页</a>
                        </li>
                        <li class="trail-item">
                            <a href="#">仙人掌</a>
                        </li>
                        <li class="trail-item trail-end active">
                            槟榔树
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="content-area content-details col-lg-9 col-md-8 col-sm-12 col-xs-12">
                <div class="site-main">
                    <%
                        List<Plants> plants = (List<Plants>) session.getAttribute("pl");
                        for (Plants p:plants
                             ) {
                            %>
                    <div class="details-product">
                        <form action="addShopCarServlet.do?plant_id=<%=p.getPlant_id()%>" method="post" id="collfrom">
                            <div class="details-thumd">
                                <div class="image-preview-container image-thick-box image_preview_container">
                                    <img id="img_zoom" data-zoom-image="<%=p.getPic()%>" src="<%=p.getPic()%>" alt="img">
                                    <a href="#" class="btn-zoom open_qv"><i class="fa fa-search" aria-hidden="true"></i></a>
                                </div>
                                <br/>
                                <br/>
                                <div class="product-preview image-small product_preview">
                                    <div id="thumbnails" class="thumbnails_carousel owl-carousel" data-nav="true" data-autoplay="false" data-dots="false" data-loop="false" data-margin="10" data-responsive='{"0":{"items":3},"480":{"items":3},"600":{"items":3},"1000":{"items":3}}'>
                                        <a href="#" data-image="<%=p.getPic()%>" data-zoom-image="<%=p.getPic()%>" class="active">
                                            <img src="<%=p.getPic()%>" data-large-image="<%=p.getPic()%>" alt="img">
                                        </a>
                                        <a href="#" data-image="<%=p.getPic()%>" data-zoom-image="<%=p.getPic()%>">
                                            <img src="<%=p.getPic()%>" data-large-image="<%=p.getPic()%>" alt="img">
                                        </a>
                                        <a href="#" data-image="<%=p.getPic()%>" data-zoom-image="<%=p.getPic()%>">
                                            <img src="<%=p.getPic()%>" data-large-image="<%=p.getPic()%>" alt="img">
                                        </a>
                                        <a href="#" data-image="<%=p.getPic()%>" data-zoom-image="<%=p.getPic()%>">
                                            <img src="<%=p.getPic()%>" data-large-image="<%=p.getPic()%>" alt="img">
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <div class="details-infor">
                                <h1 class="product-title">
                                    <%=p.getPlant_name()%>
                                </h1>
                                <div class="stars-rating">
                                    <div class="star-rating">
                                        <span class="star-5"></span>
                                    </div>
                                    <div class="count-star">
                                        (7)
                                    </div>
                                </div>
                                <div class="availability">
                                    availability:
                                    <a href="#">in Stock</a>
                                </div>
                                <div class="price">
                                    <span>$&nbsp;<%=p.getPrice()%></span>
                                </div>
                                <div class="product-details-description">
                                    <ul>
                                        <li>Vestibulum tortor quam</li>
                                        <li>Imported</li>
                                        <li>Art.No. 06-7680</li>
                                    </ul>
                                </div>

                                <div class="variations">
                                    <div class="attribute attribute_color">
                                        <div class="color-text text-attribute">
                                            颜色:
                                        </div>
                                        <div class="list-color list-item list-size" id="colour">
                                            <a href="javascript:;" class="color1 active" style="width: 40px;height: 30px;color: white">白色</a>
                                            <a href="javascript:;"  class="color2" style="width: 40px;height: 30px;color: black">黑色</a>
                                            <a href="javascript:;" class="color3" style="width: 40px;height: 30px;color: #4a5365">藏蓝</a>
                                            <a href="javascript:;" class="color4" style="width: 40px;height: 30px;color: #84664d">咖色</a>
                                            <input id="color" name="color" type="hidden" value="白色">
                                        </div>
                                    </div>
                                    <div class="attribute attribute_size">
                                        <div class="size-text text-attribute">
                                            尺码:
                                        </div>
                                        <div class="list-size list-item" id="sizes">
                                            <a href="javascript:;"  class="active">XS</a>
                                            <a href="javascript:;"  class="">S</a>
                                            <a href="javascript:;"  class="">M</a>
                                            <a href="javascript:;"  class="">L</a>
                                            <a href="javascript:;"  class="">XL</a>
                                            <a href="javascript:;"  class="">XXL</a>
                                            <input id="size" name="size" type="hidden" value="xs">
                                        </div>
                                    </div>
                                </div>
                                <div class="group-button">
                                    <div class="yith-wcwl-add-to-wishlist">
                                        <div class="yith-wcwl-add-button">
                                            <a href="javascript:addColl();" methods="post">添加到收藏</a>
                                        </div>
                                    </div>
                                    <div class="size-chart-wrapp">
                                        <div class="btn-size-chart">
                                            <a id="size_chart" href="assets/images/size-chart.jpg" class="fancybox">View Size Chart</a>
                                        </div>
                                    </div>
                                    <div class="quantity-add-to-cart">
                                        <div class="quantity">
                                            <div class="control">
                                                <a class="btn-number qtyminus quantity-minus" href="#">-</a>
                                                <input type="text" data-step="1" data-min="0" value="1" title="Qty" class="input-qty qty" size="4">
                                                <a href="#" class="btn-number qtyplus quantity-plus">+</a>
                                            </div>
                                        </div>
                                        <input type="submit" class="single_add_to_cart_button button" value="添加到购物车">
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <script>
                        function addColl() {
                            var collfrom = document.getElementById("collfrom");
                            collfrom.action = "addCollectionServlet.do?plant_id=<%=p.getPlant_id()%>";
                            collfrom.method = "post";
                            collfrom.submit();
                        }
                    </script>
                    <div class="tab-details-product">
                        <ul class="tab-link">
                            <li class="active">
                                <a data-toggle="tab" aria-expanded="true" href="#product-descriptions">商品详情</a>
                            </li>
                            <li class="">
                                <a data-toggle="tab" aria-expanded="true" href="#information">尺码信息</a>
                            </li>
                            <li class="">
                                <a data-toggle="tab" aria-expanded="true" href="#reviews">客户评论</a>
                            </li>
                        </ul>
                        <div class="tab-container">
                            <div id="product-descriptions" class="tab-panel active">
                                <p>
                                    <%=p.getComment()%>
                                </p>
                            </div>
                            <div id="information" class="tab-panel">
                                <table class="table table-bordered">
                                    <tr>
                                        <td>尺寸</td>
                                        <td> XS / S / M / L </td>
                                    </tr>
                                    <tr>
                                        <td>颜色</td>
                                        <td>白色/ 黑色/ 绿色/ 棕色</td>
                                    </tr>
                                    <tr>
                                        <td>属性</td>
                                        <td>五颜六色</td>
                                    </tr>
                                </table>
                            </div>
                            <script>
                                function start(x) {
                                    document.getElementById("start").value = x;
                                }

                                function judgeComment(pid) {
                                    $.ajax({
                                        type:"POST",
                                        url:"judgeComment.do",
                                        data:"pid=" + pid,
                                        success:function(msg) {
                                            var usernameSpan = document.getElementById("commentSpan");
                                            if (msg == "1") {
                                                usernameSpan.innerHTML = "可评论";
                                            }else if (msg == "0") {
                                                usernameSpan.innerHTML = "您未购买此商品";
                                            } else {
                                                usernameSpan.innerHTML = "网络出现异常";
                                            }
                                        }
                                    });
                                }

                            </script>
                            <div id="reviews" class="tab-panel">
                                <div class="reviews-tab">
                                    <div class="comments">
                                        <h2 class="reviews-title">
                                            关于
                                            <span> <%=p.getPlant_name()%></span>
                                            的评论
                                        </h2>
                                        <%
                                            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                                            CommentService commentService = (CommentServiceImpl) context.getBean("commentServiceImpl");
                                            List<Comment> comments = commentService.getComment(p.getPlant_id());
                                            if (comments == null || "".equals(comments)){
                                        %>
                                            <h3 class="reviews-title">暂无评论</h3>
                                        <%
                                            } else {
                                                for (int i = 0; i < comments.size(); i++) {
                                                    Comment comment = comments.get(i);
                                                    User user1 = commentService.getUser(comment.getUser_id());
                                        %>
                                            <ol class="commentlist">
                                                <li class="conment">
                                                    <div class="conment-container">
                                                        <a href="#" class="avatar">
                                                            <img src="assets/images/avartar.jpeg.jpg" alt="img">
                                                        </a>
                                                        <div class="comment-text">
                                                            <div class="stars-rating">
                                                                <div id="st" class="star-rating">
                                                                    <a></a>
                                                                </div>
                                                                (<div class="count-star" id="count"><%=comment.getComment_pic()%></div>)
                                                            </div>
                                                            <p class="meta">
                                                                <strong class="author"><%=user1.getUser_name()%></strong>
                                                                <span>-</span>
                                                                <span class="time"><%=user1.getUser_email()%></span>
                                                            </p>
                                                            <div class="description">
                                                                <p><%=comment.getComment()%></p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </li>
                                            </ol>
                                        <%
                                                }
                                            }
                                        %>

                                    </div>
                                    <script type="text/javascript">
                                        window.onload = function () {
                                            var link = document.getElementById("colour").getElementsByTagName("a");
                                            for (var i = 0; i < link.length; i++) {
                                                link[i].onclick = function() {
                                                    for (var i = 0; i < link.length; i++) {
                                                        if (this == link[i]) {
                                                            document.getElementById("color").value = link[i].innerHTML;
                                                            this.classList.add("active");
                                                        } else {
                                                            link[i].classList.remove("active");
                                                        }
                                                    }

                                                }

                                            }


                                            var links = document.getElementById("sizes").getElementsByTagName("a");
                                            for (var i = 0; i < links.length; i++) {
                                                links[i].onclick = function() {
                                                    for (var i = 0; i < links.length; i++) {
                                                        if (this == links[i]) {
                                                            document.getElementById("size").value = links[i].innerHTML;
                                                            this.classList.add("active");
                                                        } else {
                                                            links[i].classList.remove("active");
                                                        }
                                                    }
                                                }

                                            }
                                            // var show = document.getElementById("st").getElementsByTagName("a");
                                            // var start = document.getElementById("count").innerHTML;
                                            // alert(start)
                                            // switch (start) {
                                            //     case 1:
                                            //         // show.addClass('star-1')
                                            //         show.classList.add("star-1")
                                            //         break;
                                            //     case 2:
                                            //         // show.addClass('star-2')
                                            //         show.classList.add("star-2")
                                            //         break;
                                            //     case 3:
                                            //         // show.addClass('star-3')
                                            //         show.classList.add("star-3")
                                            //         break;
                                            //     case 4:
                                            //         // show.addClass('star-4')
                                            //         alert(11)
                                            //         show.classList.add("star-4")
                                            //         break;
                                            //     case 5:
                                            //         // show.addClass('star-5')
                                            //         show.classList.add("star-5")
                                            //         break;
                                            //     default:
                                            //         show.className = "";
                                            // }

                                            var lin = document.getElementById("star").getElementsByTagName("a");
                                            for (var i = 0; i < lin.length; i++) {
                                                lin[i].onclick = function () {
                                                    for (var i = 0; i < lin.length; i++) {
                                                        if (this == lin[i]) {
                                                            document.getElementById("star").value = lin[i].innerHTML;
                                                            this.classList.add("star-rating");
                                                        } else {
                                                            lin[i].classList.remove("star-rating");
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    </script>
                                    <div class="review_form_wrapper">
                                        <div class="review_form">
                                            <div class="comment-respond">
                                                <span class="comment-reply-title">添加一个评论 </span>
                                                <form class="comment-form-review" >
                                                    <p class="comment-notes">
                                                        <span class="email-notes">您的电子邮件地址将不会被公布。</span>
                                                        必填字段被标记
                                                        <span class="required">*</span>
                                                    </p>
                                                    <input name="pid" type="hidden" value="<%=p.getPlant_id()%>">

                                                    <div class="comment-form-rating">
                                                        <label>您的评价</label>
                                                        <p class="stars">
                                                            <span id="star">
                                                                <a class="star-1" href="javascript:start(1);" ></a>
                                                                <a class="star-2" href="javascript:start(2);"></a>
                                                                <a class="star-3" href="javascript:start(3);"></a>
                                                                <a class="star-4" href="javascript:start(4);"></a>
                                                                <a class="star-5" href="javascript:start(5);" ></a>
                                                            </span>
                                                            <input id="start" name="start" type="hidden" value="">
                                                        </p>
                                                    </div>
                                                    <p class="comment-form-comment">
                                                        <label>
                                                            您的评论
                                                            <span class="required">*</span>
                                                        </label>
                                                        <textarea title="review" id="comment" name="comment" cols="45" rows="8" onblur="judgeComment(<%=p.getPlant_id()%>)"></textarea>
                                                        <div id="commentSpan" style="font-size: 15px;color: red"></div>
                                                    </p>
                                                    <p class="form-submit">
                                                        <button onclick="addComment(<%=p.getPlant_id()%>)" style="color: white">发表</button>
                                                    </p>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                 </div>
                            </div>
                        </div>
                    </div>
                    <%
                        }
                    %>
                <div style="clear: left;"></div>
                <div class="related products product-grid">
                    <h2 class="product-grid-title">猜你喜欢</h2>
                    <div class="owl-products owl-slick equal-container nav-center"  data-slick ='{"autoplay":false, "autoplaySpeed":1000, "arrows":true, "dots":false, "infinite":true, "speed":800, "rows":1}' data-responsive='[{"breakpoint":"2000","settings":{"slidesToShow":3}},{"breakpoint":"1200","settings":{"slidesToShow":2}},{"breakpoint":"992","settings":{"slidesToShow":2}},{"breakpoint":"480","settings":{"slidesToShow":1}}]'>
                        <%
                            List<Plants> toprated = (List<Plants>) session.getAttribute("toprated");
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
                                        <a href="#">
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
                                        <a href="#"><%=p.getPlant_name()%></a>
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
                    </div>
                </div>
            </div>
        </div>
            <div class="sidebar sidebar-details col-lg-3 col-md-4 col-sm-12 col-xs-12">
                <div class="wrapper-sidebar">
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
                    <div class="widget widget-related-products">
                        <h3 class="widgettitle">Related Products</h3>
                        <div class="slider-related-products owl-slick nav-top-right equal-container"  data-slick ='{"autoplay":false, "autoplaySpeed":1000, "arrows":true, "dots":false, "infinite":true, "speed":800, "rows":1}' data-responsive='[{"breakpoint":"2000","settings":{"slidesToShow":1 }},{"breakpoint":"992","settings":{"slidesToShow":2}}]'>
                            <div class="product-item style-1">
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
                                            <a href="#">
                                                <img src="assets/images/product-item-1.jpg" alt="img">
                                            </a>
                                            <div class="thumb-group">
                                                <div class="yith-wcwl-add-to-wishlist">
                                                    <div class="yith-wcwl-add-button">
                                                        <a href="#">Add to Wishlist</a>
                                                    </div>
                                                </div>
                                                <a href="#" class="button quick-wiew-button">Quick View</a>
                                                <div class="loop-form-add-to-cart">
                                                    <button class="single_add_to_cart_button button">Add to cart
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="product-info">
                                        <h5 class="product-name product_title">
                                            <a href="#">Areca palm</a>
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
                                                    $45
                                                </ins>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="product-item style-1">
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
                                            <a href="#">
                                                <img src="assets/images/product-item-2.jpg" alt="img">
                                            </a>
                                            <div class="thumb-group">
                                                <div class="yith-wcwl-add-to-wishlist">
                                                    <div class="yith-wcwl-add-button">
                                                        <a href="#">Add to Wishlist</a>
                                                    </div>
                                                </div>
                                                <a href="#" class="button quick-wiew-button">Quick View</a>
                                                <div class="loop-form-add-to-cart">
                                                    <button class="single_add_to_cart_button button">Add to cart
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="product-info">
                                        <h5 class="product-name product_title">
                                            <a href="#">European Pan Palm</a>
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
                                                    $45
                                                </ins>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="widget widget-banner">
                        <a href="#">
                            <img src="assets/images/widget-banner.jpg" alt="img">
                        </a>
                    </div>
                    <div class="widget widget-testimonials">
                        <h3 class="widgettitle">Testimonials</h3>
                        <div class="slider-related-products owl-slick nav-top-right"  data-slick ='{"autoplay":false, "autoplaySpeed":1000, "arrows":true, "dots":false, "infinite":true, "speed":800, "rows":1}' data-responsive='[{"breakpoint":"991","settings":{"slidesToShow":1 }}]'>
                            <div class="testimonials-item">
                                <div class="Testimonial-inner">
                                    <div class="comment">
                                        Donec ligula mauris, posuere sed tincidunt a, facilisis id enim. Class aptent taciti sociosqu ad litora torquent per conubia.
                                    </div>
                                    <div class="author">
                                        <div class="avt">
                                            <img src="assets/images/member1.png" alt="img">
                                        </div>
                                        <h3 class="name">
                                            Adam Smith
                                            <span class="position">
													CEO/Founder Apple
												</span>
                                        </h3>

                                    </div>
                                </div>
                            </div>
                        <div class="testimonials-item">
                            <div class="Testimonial-inner">
                                <div class="comment">
                                    Donec ligula mauris, posuere sed tincidunt a, facilisis id enim. Class aptent taciti sociosqu ad litora torquent per conubia.
                                </div>
                                <div class="author">
                                    <div class="avt">
                                        <img src="assets/images/member2.png" alt="img">
                                    </div>
                                    <h3 class="name">
                                        Tom Milikin
                                        <span class="position">
                                                CEO/Founder Apple
                                            </span>
                                    </h3>

                                </div>
                            </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"/>
<div class="footer-device-mobile">
    <div class="wapper">
        <div class="footer-device-mobile-item device-home">
            <a href="index.html">
					<span class="icon">
						<i class="fa fa-home" aria-hidden="true"></i>
					</span>
                Home
            </a>
        </div>
        <div class="footer-device-mobile-item device-home device-wishlist">
            <a href="#">
					<span class="icon">
						<i class="fa fa-heart" aria-hidden="true"></i>
					</span>
                Wishlist
            </a>
        </div>
        <div class="footer-device-mobile-item device-home device-cart">
            <a href="#">
					<span class="icon">
						<i class="fa fa-shopping-basket" aria-hidden="true"></i>
						<span class="count-icon">
							0
						</span>
					</span>
                <span class="text">Cart</span>
            </a>
        </div>
        <div class="footer-device-mobile-item device-home device-user">
            <a href="#">
					<span class="icon">
						<i class="fa fa-user" aria-hidden="true"></i>
					</span>
                Account
            </a>
        </div>
    </div>
</div>
<a href="#" class="backtotop">
    <i class="fa fa-angle-double-up"></i>
</a>
<script >
    function addComment(pid) {
        var start = document.getElementById("start").value;
        var comment = document.getElementById("comment").value;
        layer.load();
        $.ajax({
            type:"POST",
            url:"addComment.do",
            async:false,
            data:"start=" + start + "&comment=" + comment + "&pid=" + pid,
            success:function(msg) {
                layer.closeAll();
                if (msg === "1") {
                    // layer.msg("评论成功");
                    alert("评论成功");
                }else if (msg === "-1") {
                    // layer.msg("已评论");
                    alert("已评论");
                } else if (msg === "0"){
                    // layer.msg("评论失败");
                    alert("评论失败");
                } else {
                    // layer.msg("网络出现异常");
                    alert("网络出现异常");
                }
            }
        });
    }
</script>
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
