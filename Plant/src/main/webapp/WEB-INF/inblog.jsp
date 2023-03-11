<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/19
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Teamo - InBlog Left Sidebar</title>
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
<div class="main-content main-content-blog single left-sidebar">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb-trail breadcrumbs">
                    <ul class="trail-items breadcrumb">
                        <li class="trail-item trail-begin">
                            <a href="index.jsp">Home</a>
                        </li>
                        <li class="trail-item">
                            <a href="#">我们的博客</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="content-area content-blog col-lg-9 col-md-8 col-sm-12 col-xs-12">
                <div class="site-main">
                    <div class="post-item">
                        <div class="post-format">
                            <a href="#">
                                <img src="assets/images/blog1.jpg" alt="img">
                            </a>
                        </div>
                        <div class="post-infor">
                            <div class="category-blog">
                                <a href="#">LIFE STYLE</a>
                            </div>
                            <h3 class="post-title">
                                <a href="#">New Designer Outdoor Cars</a>
                            </h3>
                            <div class="main-info-post">
                                <p>
                                    Duis quis porta enim.
                                    Nunc molestie porta elit, sit amet mattis lectus mollis et.
                                    Phasellus condimentum nulla a arcu lacinia, a
                                    venenatis ex congue. Mauris nec ante magna.
                                    Duis lacus massa, consequat at mollis gravida, ornare vel mi.
                                    Nam dignissim sagittis quam nec consequat.
                                    Maecenas vel nulla eleifend, euismod magna sed, tristique velit.
                                    Nam sed eleifend dui, eu eleifend leo.
                                </p>
                                <p>
                                    Mauris ornare eros quis placerat mollis.
                                    Duis ornare euismod risus at dictum.
                                    Proin at porttitor metus. Nunc luctus nisl suscipit,
                                    hendrerit ligula non, mattis dolor.
                                    In sit amet enim in odio viverra maximus luctus vitae orci.
                                    Nunc faucibus ipsum vel massa
                                    venenatis pretium. Suspendisse volutpat ac nisi at commodo.
                                </p>
                                <blockquote>
                                    <p>
                                        Maecenas vel nulla eleifend, euismod magna sed, tristique velit.
                                        Nam sed eleifend dui, eu eleifend leo.
                                        Mauris ornare eros quis placerat mollis.
                                        Duis ornare euismod risus at dictum.
                                        Proin at porttitor metus.
                                        Nunc luctus nisl suscipit, hendrerit ligula non, mattis dolor.
                                    </p>
                                    <div class="author">
											<span class="name">
												Koan Conella
											</span>
                                        <span class="desc">
												创意文案
											</span>
                                    </div>
                                </blockquote>
                            </div>
                        </div>
                    </div>
                    <div class="blog-articles related-articles">
                        <h3 class="custom_blog_title">
                            相关文章
                        </h3>
                        <div class="blog-slider style-1 owl-slick"
                             data-slick='{"variableWidth":true, "autoplay":false, "autoplaySpeed":1000, "arrows":true, "dots":false, "infinite":true, "speed":800, "rows":1}'
                             data-responsive='[{"breakpoint":"1200","settings":{"slidesToShow":1,"variableWidth":false }}]'>
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
                                        <a href="#">New Designer Outdoor Cars <span>[...]</span></a>
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
                            <div class="blog-item ">
                                <div class="post-format ">
                                    <a href="#">
                                        <img src="assets/images/blog3.jpg" alt="img">
                                    </a>
                                </div>
                                <div class="post-info ">
                                    <div class="category-blog">
                                        <a href="#">LIFE STYLE</a>
                                    </div>
                                    <h3 class="post-title">
                                        <a href="#">New Designer Outdoor Cars <span>[...]</span></a>
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
                        <div class="main-info-post">
                            <p class="des">
                                Nam sed eleifend dui, eu eleifend leo.Mauris ornare eros quis placerat mollis. Duis
                                ornare euismod risus at dictum. Proin at porttitor metus. Nunc luctus nisl suscipit,
                                hendrerit ligula non, mattis dolor. In sit amet enim in odio viverra maximus luctus
                                vitae orci. Nunc faucibus ipsum vel massa venenatis pretium. Suspendisse volutpat ac
                                nisi at commodo.
                            </p>
                            <p class="des">
                                Mauris tempor eros vel velit condimentum venenatis. Aliquam ut viverra sapien. Sed
                                condimentum semper faucibus. Maecenas feugiat purus eget interdum sagittis. Ut
                                pellentesque gravida justo non rhoncus. Nunc ullamcorper tortor id aliquet luctus. Proin
                                varius aliquam consequat. Curabitur a commodo diam, vitae pellentesque urna. Fusce
                                posuere turpis arcu, fringilla varius nunc dictum in. Praesent pulvinar sit amet nulla
                                nec elementum.
                            </p>
                        </div>
                    </div>
                    <div class="tags tags-blog">
                        <h3 class="widgettitle">
                            Tags:
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
                    <div class="view-share">
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
                        <div class="share">
                            <h3 class="title">share</h3>
                            <i class="icon fa fa-facebook-square" aria-hidden="true"></i>
                            <i class="icon fa fa-linkedin" aria-hidden="true"></i>
                            <i class="icon fa fa-twitter" aria-hidden="true"></i>
                        </div>
                    </div>
                    <div class="comments-area">
                        <h3 class="custom_blog_title">
                            评论 <span class="count">(2)</span>
                        </h3>
                        <form class="comment-form">
                            <p class="comment-reply-content">
                                <textarea rows="6" placeholder="Write your comment" class="input-form"></textarea>
                            </p>
                            <p class="form-submit">
									<span class="controll">
										<i class="icon fa fa-file-image-o" aria-hidden="true"></i>
										<i class="icon fa fa-paperclip" aria-hidden="true"></i>
										<i class="icon fa fa-smile-o" aria-hidden="true"></i>
										<button class="submit button">发布评论</button>
									</span>
                            </p>
                        </form>
                        <ul class="comment-list">
                            <li class="comment">
                                <div class="comment-item">
                                    <div class="author-view">
                                        <div class="author">
                                            <div class="avt">
                                                <img src="assets/images/avt-blog1.png" alt="img">
                                            </div>
                                            <h3 class="name">
                                                Adam Smith
                                            </h3>
                                        </div>
                                        <div class="date-reply-comment">
												<span class="date-comment">
													4 days ago
												</span>
                                        </div>
                                    </div>
                                    <div class="comment-body">
                                        <div class="comment-content">
                                            <p>
                                                Nam sed eleifend dui, eu eleifend leo.
                                                Mauris ornare eros quis placerat mollis.
                                                Duis ornare euismod risus at dictum.
                                                Proinat porttitor metus.
                                                Nunc luctus nisl suscipit, hendrerit ligula non.
                                            </p>
                                        </div>
                                        <div class="comment-reply-link">
												<span class="Comment">
													<i class="icon fa fa-commenting" aria-hidden="true"></i>
													Comment
												</span>
                                            <span class="like">
													<i class="icon fa fa-thumbs-o-up" aria-hidden="true"></i>
													1
												</span>
                                            <span class="dislike">
													<i class="icon fa fa-thumbs-o-down" aria-hidden="true"></i>
												</span>
                                        </div>
                                    </div>
                                </div>
                                <ul class="children">
                                    <li>
                                        <div class="comment-item">
                                            <div class="author-view">
                                                <div class="author">
                                                    <div class="avt">
                                                        <img src="assets/images/avt-blog1.png" alt="img">
                                                    </div>
                                                    <h3 class="name">
                                                        Samuel Godi
                                                    </h3>
                                                </div>
                                                <div class="date-reply-comment">
														<span class="date-comment">
															4 days ago
														</span>
                                                </div>
                                            </div>
                                            <div class="comment-body">
                                                <div class="comment-content">
                                                    <p>
                                                        Ut pellentesque gravida justo non rhoncus.
                                                        Nunc ullamcorper tortor id aliquet luctus.
                                                        Proin varius aliquam consequat.Curabitur a commodo diam, vitae
                                                        pellentesque urna.
                                                    </p>
                                                </div>
                                                <div class="comment-reply-link">
														<span class="Comment">
															<i class="fa fa-commenting" aria-hidden="true"></i>
															Comment
														</span>
                                                    <span class="like">
															<i class="fa fa-thumbs-o-up" aria-hidden="true"></i>
															9
														</span>
                                                    <span class="dislike">
															<i class="fa fa-thumbs-o-down" aria-hidden="true"></i>
															1
														</span>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <div class="pagination clearfix style1">
                        <div class="nav-link">
                            <a href="#" class="page-numbers"><i class="icon fa fa-angle-left"
                                                                aria-hidden="true"></i></a>
                            <a href="#" class="page-numbers">1</a>
                            <a href="#" class="page-numbers">2</a>
                            <a href="#" class="page-numbers current">3</a>
                            <a href="#" class="page-numbers"><i class="icon fa fa-angle-right"
                                                                aria-hidden="true"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="sidebar sidebar-single-blog col-lg-3 col-md-4 col-sm-12 col-xs-12">
                <div class="wrapper-sidebar">
                    <div class="widget widget-socials">
                        <h3 class="widgettitle">
                            关注我们
                        </h3>
                        <div class="content-socials">
                            <div class="social-list">
                                <a href="#" target="_blank" class="social-item">
                                    <i class="fa fa-facebook-square" aria-hidden="true"></i>
                                </a>
                                <a href="#" target="_blank" class="social-item">
                                    <i class="fa fa-twitter" aria-hidden="true"></i>
                                </a>
                                <a href="#" target="_blank" class="social-item">
                                    <i class="fa fa-instagram" aria-hidden="true"></i>
                                </a>
                            </div>
                        </div>
                    </div>
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
                    <div class="widget widget-post">
                        <h3 class="widgettitle">Popular Articles</h3>
                        <ul class="teamo-posts">
                            <li class="widget-post-item">
                                <div class="thumb-blog">
                                    <img src="assets/images/sidebar-post1.jpg" alt="img">
                                </div>
                                <div class="post-content">
                                    <div class="cat">
                                        <a href="#">Life Style</a>
                                    </div>
                                    <h5 class="post-title"><a href="#">9 Quicks Tips That Will Change <span>[...]</span></a>
                                    </h5>
                                </div>
                            </li>
                            <li class="widget-post-item">
                                <div class="thumb-blog">
                                    <img src="assets/images/sidebar-post2.jpg" alt="img">
                                </div>
                                <div class="post-content">
                                    <div class="cat">
                                        <a href="#">Lookbook</a>
                                    </div>
                                    <h5 class="post-title"><a href="#">9 Quicks Tips That Will Change <span>[...]</span></a>
                                    </h5>
                                </div>
                            </li>
                            <li class="widget-post-item">
                                <div class="thumb-blog">
                                    <img src="assets/images/sidebar-post3.jpg" alt="img">
                                </div>
                                <div class="post-content">
                                    <div class="cat">
                                        <a href="#">Street Style</a>
                                    </div>
                                    <h5 class="post-title"><a href="#">9 Quicks Tips That Will Change <span>[...]</span></a>
                                    </h5>
                                </div>
                            </li>
                        </ul>
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