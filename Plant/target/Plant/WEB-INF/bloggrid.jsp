<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/19
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Teamo-GridBlog</title>
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
<body class="inblog-page">
<jsp:include page="head.jsp"/>
<div class="header-device-mobile">
    <div class="wapper">
        <div class="item mobile-logo">
            <div class="logo">
                <a href="#">
                    <img src="assets/images/logo.png" alt="img">
                </a>
            </div>
        </div>
        <div class="item item mobile-search-box has-sub">
            <a href="#">
						<span class="icon">
							<i class="fa fa-search" aria-hidden="true"></i>
						</span>
            </a>
            <div class="block-sub">
                <a href="#" class="close">
                    <i class="fa fa-times" aria-hidden="true"></i>
                </a>
                <div class="header-searchform-box">
                    <form class="header-searchform">
                        <div class="searchform-wrap">
                            <input type="text" class="search-input" placeholder="Enter keywords to search...">
                            <input type="submit" class="submit button" value="Search">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="item mobile-settings-box has-sub">
            <a href="#">
						<span class="icon">
							<i class="fa fa-cog" aria-hidden="true"></i>
						</span>
            </a>
            <div class="block-sub">
                <a href="#" class="close">
                    <i class="fa fa-times" aria-hidden="true"></i>
                </a>
                <div class="block-sub-item">
                    <h5 class="block-item-title">Currency</h5>
                    <form class="currency-form teamo-language">
                        <ul class="teamo-language-wrap">
                            <li class="active">
                                <a href="#">
											<span>
												English (USD)
											</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
											<span>
												French (EUR)
											</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
											<span>
												Japanese (JPY)
											</span>
                                </a>
                            </li>
                        </ul>
                    </form>
                </div>
            </div>
        </div>
        <div class="item menu-bar">
            <a class=" mobile-navigation  menu-toggle" href="#">
                <span></span>
                <span></span>
                <span></span>
            </a>
        </div>
    </div>
</div>
<div class="main-content main-content-blog grid no-sidebar">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb-trail breadcrumbs">
                    <ul class="trail-items breadcrumb">
                        <li class="trail-item trail-begin">
                            <a href="index.html">Home</a>
                        </li>
                        <li class="trail-item trail-end active">
                            Our blog
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="content-area content-blog col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="site-main">
                    <h3 class="custom_blog_title capi">
                        Our Blog
                    </h3>
                    <div class="blog-list grid-style">
                        <div class="row">
                            <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
                                <div class="blog-item">
                                    <div class="post-format">
                                        <a href="#">
                                            <img src="assets/images/blog2.jpg" alt="img">
                                        </a>
                                    </div>
                                    <div class="post-info">
                                        <div class="category-blog">
                                            <a href="#">LIFE STYLE</a>
                                        </div>
                                        <h3 class="post-title">
                                            <a href="#">Open The Gates For Lorem </a>
                                        </h3>
                                        <div class="main-info-post">
                                            <p class="des">
                                                Phasellus condimentum nulla a arcu lacinia, a venenatis ex congue.
                                                Mauris nec ante magna.
                                            </p>
                                        </div>
                                        <div class="author-view">
                                            <div class="author">
                                                <div class="avt">
                                                    <img src="assets/images/avt-blog1.png" alt="img">
                                                </div>
                                                <h3 class="name">
                                                    Adam Smith
                                                </h3>
                                            </div>
                                            <div class="review">
                                                <div class="view">
														<span class="icon-view">
															<i class="fa fa-eye" aria-hidden="true"></i>
														</span>
                                                    <span class="count">
															631
														</span>
                                                </div>
                                                <div class="s-comments">
														<span class="icon-cmt">
															<i class="fa fa-commenting" aria-hidden="true"></i>
														</span>
                                                    <span class="count">
															82
														</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
                                <div class="blog-item">
                                    <div class="post-format">
                                        <a href="#">
                                            <img src="assets/images/blog3.jpg" alt="img">
                                        </a>
                                    </div>
                                    <div class="post-info">
                                        <div class="category-blog">
                                            <a href="#">LIFE STYLE</a>
                                        </div>
                                        <h3 class="post-title">
                                            <a href="#">Fast-Track Your lorem ipsum </a>
                                        </h3>
                                        <div class="main-info-post">
                                            <p class="des">
                                                Phasellus condimentum nulla a arcu lacinia, a venenatis ex congue.
                                                Mauris nec ante magna.
                                            </p>
                                        </div>
                                        <div class="author-view">
                                            <div class="author">
                                                <div class="avt">
                                                    <img src="assets/images/avt-blog1.png" alt="img">
                                                </div>
                                                <h3 class="name">
                                                    Adam Smith
                                                </h3>
                                            </div>
                                            <div class="review">
                                                <div class="view">
														<span class="icon-view">
															<i class="fa fa-eye" aria-hidden="true"></i>
														</span>
                                                    <span class="count">
															631
														</span>
                                                </div>
                                                <div class="s-comments">
														<span class="icon-cmt">
															<i class="fa fa-commenting" aria-hidden="true"></i>
														</span>
                                                    <span class="count">
															82
														</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
                                <div class="blog-item">
                                    <div class="post-format">
                                        <a href="#">
                                            <img src="assets/images/blog-grid-1.jpg" alt="img">
                                        </a>
                                    </div>
                                    <div class="post-info">
                                        <div class="category-blog">
                                            <a href="#">ACCESSORIES</a>
                                        </div>
                                        <h3 class="post-title">
                                            <a href="#">How to Build Your Perfect Ferns</a>
                                        </h3>
                                        <div class="main-info-post">
                                            <p class="des">
                                                Phasellus condimentum nulla a arcu lacinia, a venenatis ex congue.
                                                Mauris nec ante magna.
                                            </p>
                                        </div>
                                        <div class="author-view">
                                            <div class="author">
                                                <div class="avt">
                                                    <img src="assets/images/avt-blog1.png" alt="img">
                                                </div>
                                                <h3 class="name">
                                                    Adam Smith
                                                </h3>
                                            </div>
                                            <div class="review">
                                                <div class="view">
														<span class="icon-view">
															<i class="fa fa-eye" aria-hidden="true"></i>
														</span>
                                                    <span class="count">
															631
														</span>
                                                </div>
                                                <div class="s-comments">
														<span class="icon-cmt">
															<i class="fa fa-commenting" aria-hidden="true"></i>
														</span>
                                                    <span class="count">
															82
														</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
                                <div class="blog-item">
                                    <div class="post-format">
                                        <a href="#">
                                            <img src="assets/images/blog-grid-2.jpg" alt="img">
                                        </a>
                                    </div>
                                    <div class="post-info">
                                        <div class="category-blog">
                                            <a href="#">LIFE STYLE</a>
                                        </div>
                                        <h3 class="post-title">
                                            <a href="#">We design functional Cars</a>
                                        </h3>
                                        <div class="main-info-post">
                                            <p class="des">
                                                Phasellus condimentum nulla a arcu lacinia, a venenatis ex congue.
                                                Mauris nec ante magna.
                                            </p>
                                        </div>
                                        <div class="author-view">
                                            <div class="author">
                                                <div class="avt">
                                                    <img src="assets/images/avt-blog1.png" alt="img">
                                                </div>
                                                <h3 class="name">
                                                    Adam Smith
                                                </h3>
                                            </div>
                                            <div class="review">
                                                <div class="view">
														<span class="icon-view">
															<i class="fa fa-eye" aria-hidden="true"></i>
														</span>
                                                    <span class="count">
															631
														</span>
                                                </div>
                                                <div class="s-comments">
														<span class="icon-cmt">
															<i class="fa fa-commenting" aria-hidden="true"></i>
														</span>
                                                    <span class="count">
															82
														</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
                                <div class="blog-item">
                                    <div class="post-format">
                                        <a href="#">
                                            <img src="assets/images/blog-grid-3.jpg" alt="img">
                                        </a>
                                    </div>
                                    <div class="post-info">
                                        <div class="category-blog">
                                            <a href="#">HAND BAGS</a>
                                        </div>
                                        <h3 class="post-title">
                                            <a href="#">Top 10 Tips To Grow </a>
                                        </h3>
                                        <div class="main-info-post">
                                            <p class="des">
                                                Egg whites, turkey sausage, wheat toast, water. Of course they don’t want us to eat[...]
                                            </p>
                                        </div>
                                        <div class="author-view">
                                            <div class="author">
                                                <div class="avt">
                                                    <img src="assets/images/avt-blog1.png" alt="img">
                                                </div>
                                                <h3 class="name">
                                                    Adam Smith
                                                </h3>
                                            </div>
                                            <div class="review">
                                                <div class="view">
														<span class="icon-view">
															<i class="fa fa-eye" aria-hidden="true"></i>
														</span>
                                                    <span class="count">
															631
														</span>
                                                </div>
                                                <div class="s-comments">
														<span class="icon-cmt">
															<i class="fa fa-commenting" aria-hidden="true"></i>
														</span>
                                                    <span class="count">
															82
														</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-12 col-sm-12 col-xs-12">
                                <div class="blog-item">
                                    <div class="post-format">
                                        <a href="#">
                                            <img src="assets/images/blog-grid-4.jpg" alt="img">
                                        </a>
                                    </div>
                                    <div class="post-info">
                                        <div class="category-blog">
                                            <a href="#">BACKPACK</a>
                                        </div>
                                        <h3 class="post-title">
                                            <a href="#">Ipsum Dolor Ame Ctetur </a>
                                        </h3>
                                        <div class="main-info-post">
                                            <p class="des">
                                                Phasellus condimentum nulla a arcu lacinia, a venenatis ex congue.
                                                Mauris nec ante magna.
                                            </p>
                                        </div>
                                        <div class="author-view">
                                            <div class="author">
                                                <div class="avt">
                                                    <img src="assets/images/avt-blog1.png" alt="img">
                                                </div>
                                                <h3 class="name">
                                                    Adam Smith
                                                </h3>
                                            </div>
                                            <div class="review">
                                                <div class="view">
														<span class="icon-view">
															<i class="fa fa-eye" aria-hidden="true"></i>
														</span>
                                                    <span class="count">
															631
														</span>
                                                </div>
                                                <div class="s-comments">
														<span class="icon-cmt">
															<i class="fa fa-commenting" aria-hidden="true"></i>
														</span>
                                                    <span class="count">
															82
														</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="pagination clearfix style2 grid">
                        <div class="nav-link">
                            <a href="#" class="page-numbers"><i class="icon fa fa-angle-left" aria-hidden="true"></i></a>
                            <a href="#" class="page-numbers">1</a>
                            <a href="#" class="page-numbers">2</a>
                            <a href="#" class="page-numbers current">3</a>
                            <a href="#" class="page-numbers"><i class="icon fa fa-angle-right" aria-hidden="true"></i></a>
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
