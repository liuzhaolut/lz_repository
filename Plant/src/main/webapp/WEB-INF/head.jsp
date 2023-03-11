
<%@ page import="java.util.List" %>
<%@ page import="com.etc.plant.entity.User" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="com.etc.plant.service.impl.CartServiceImpl" %>
<%@ page import="com.etc.plant.entity.Carts" %>
<%@ page import="com.etc.plant.service.CartService" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/10
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--    <script src="js/jquery.min.js"></script>--%>
    <script type="text/javascript">
        function judgeName(){
            var el = document.getElementById("el").value;
            $.ajax({
                type:"Post",
                url:"judgeNameServlet.do",
                data:"el=" + el,
                success:function(msg) {
                    var usernameSpan = document.getElementById("usernameSpan");
                    if (msg == "1") {
                        usernameSpan.innerHTML = "用户名或邮箱已存在";
                    }else if (msg == "0") {
                        usernameSpan.innerHTML = "用户名或邮箱合格";
                    } else {
                        usernameSpan.innerHTML = "网络出现异常";
                    }
                }
            });
        }

        function regist(){
            var el = document.getElementById("el").value;
            var pd = document.getElementById("pd").value;
            $.ajax({
                type:"POST",
                url:"reg.do",
                data:"el=" + el +
                    "&pd=" + pd,
                success:function(msg) {
                    if (msg == "1") {
                        alert("注册成功");
                    }else if (msg == "0") {
                        alert("注册失败");
                    } else {
                        alert("网络异常");
                    }
                }
            });
        }
    </script>

<header class="header style7">
    <div class="top-bar">
        <div class="container">
            <div class="top-bar-left">
                <div class="header-message">
                    欢迎光临我们的网店!
                </div>
            </div>
            <div class="top-bar-right">
                <div class="header-language">
                    <div class="teamo-language teamo-dropdown">
                        <a href="#" class="active language-toggle" data-teamo="teamo-dropdown">
                          <span>
                              English (USD)
                          </span>
                        </a>
                        <ul class="teamo-submenu">
                            <li class="switcher-option">
                                <a href="#">
                                    <span>
                                        French (EUR)
                                    </span>
                                </a>
                            </li>
                            <li class="switcher-option">
                                <a href="#">
                                    <span>
                                        Japanese (JPY)
                                    </span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <ul class="header-user-links">
                    <%
                        User user = (User) session.getAttribute("user");
                        if (user == null){
                    %>
                        <li>
                            <a href="go.do?go=login.jsp">登录/注册</a>
                        </li>
                    <%
                        } else if (user.getUser_name() != null || user.getUser_email() != null){
                    %>
                       <li style="font-size: 16px;margin-top: 13px;">
                           欢迎<span style="font-size: 15px"> &nbsp;&nbsp;<%=user.getUser_name()%></span>
                       </li>
                   <%
                       }
                   %>
                </ul>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="main-header">
            <div class="row">
                <div class="col-lg-3 col-sm-4 col-md-3 col-xs-7 col-ts-12 header-element">
                    <div class="logo">
                        <a href="index.jsp">
                            <img src="assets/images/logo.png" alt="img">
                        </a>
                    </div>
                </div>
                <div class="col-lg-7 col-sm-8 col-md-6 col-xs-5 col-ts-12">
                    <div class="block-search-block">
                        <form class="form-search form-search-width-category" action="SearchServlet">
                            <div class="form-content">
                                <div class="inner">
                                    <input type="text" class="input" name="s" value="" placeholder="查找">
                                </div>
                                <button class="btn-search" type="submit">
                                    <span class="icon-search"></span>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
                <%
                    ApplicationContext context1 = new ClassPathXmlApplicationContext("applicationContext.xml");
                    CartService cartService = (CartService) context1.getBean("cartServiceImpl");

                %>
                <div class="col-lg-2 col-sm-12 col-md-3 col-xs-12 col-ts-12">
                    <div class="header-control">
                        <div class="block-account block-header teamo-dropdown">
                            <%
                                if (user == null){
                            %>
                            <div class="block-minicart teamo-mini-cart block-header teamo-dropdown">
                                <a href="javascript:void(0);" class="shopcart-icon" data-teamo="teamo-dropdown" style="margin-left: -80px">
                                    Cart
                                    <span class="count">
                                        0
                                    </span>
                                </a>
                            </div>
                            <div class="block-account block-header teamo-dropdown">
                                <a href="#header-account" data-teamo="teamo-dropdown"  style="margin-right: 50px">
                                    <span class="flaticon-user"></span>
                                </a>
                            </div>

                            <%
                                } else {
                            %>
                                <div class="block-minicart teamo-mini-cart block-header teamo-dropdown">
                                    <a href="javascript:void(0);" class="shopcart-icon" data-teamo="teamo-dropdown" style="margin-left: -80px">
                                        Cart
                                        <%
                                            List<Carts> carts = cartService.getCart();
                                            int count = 0;
                                            for (int i = 0; i < carts.size(); i++) {
                                                 count += carts.get(i).getCartNum();
                                        %>
                                              <span class="count">
                                                    <%=count%>
                                              </span>
                                        <%
                                             }
                                        %>
                                    </a>
                                </div>
                                <div class="block-account block-header teamo-dropdown">
                                    <a href="#header-account" data-teamo="teamo-dropdown" style="margin-right: 80px">
                                        <span class="flaticon-user" style="font-size: 16px"><%=user.getUser_name()%></span>
                                    </a>
                                </div>
                                <span style="float:right;margin-top: -40px;margin-left: 105px">
                                    [<a href="logoutServlet.do" style="font-size: 15px;" >退出</a>]
                                </span>

                            <%
                            }
                        %>
                            <div class="header-account teamo-submenu" id="header-account">
                                <div class="header-user-form-tabs">
                                    <ul class="tab-link">
                                        <li class="active">
                                            <a data-toggle="tab" aria-expanded="true" href="#header-tab-login">登录</a>
                                        </li>
                                        <li>
                                            <a data-toggle="tab" aria-expanded="true" href="#header-tab-rigister">注册</a>
                                        </li>
                                    </ul>
                                    <div class="tab-container">
                                        <div id="header-tab-login" class="tab-panel active">
                                            <form method="post" action="loginServlet.do" class="login form-login">
                                                <p class="form-row form-row-wide">
                                                    <input type="email" placeholder="Email" id="email" name="email" class="input-text">
                                                </p>
                                                <p class="form-row form-row-wide">
                                                    <input type="password" class="input-text" id="pwd" name="pwd" placeholder="Password">
                                                </p>
                                                <p class="form-row">
                                                    <label class="form-checkbox">
                                                        <input type="checkbox" class="input-checkbox">
                                                        <span>
                                                            记住密码
                                                        </span>
                                                    </label>
                                                    <input type="submit" class="button" value="登录">
                                                </p>
                                                <p class="lost_password">
                                                    <a href="go.do?go=qpass.jsp">忘记密码 ?</a>
                                                </p>
                                            </form>
                                        </div>
                                        <div id="header-tab-rigister" class="tab-panel">
                                            <form method="post"  class="register form-register">
                                                <p class="form-row form-row-wide">
                                                    <input type="email" placeholder="Email" id="el" name="el" class="input-text" onblur="judgeName()">
                                                    <span style="color:red;font-size:10px;" id="usernameSpan"></span>
                                                </p>
                                                <p class="form-row form-row-wide">
                                                    <input type="password" class="input-text" id="pd" name="password" placeholder="Password">
                                                </p>
                                                <p class="form-row">
                                                    <input type="submit" class="button" value="注册" onclick="regist()">
                                                </p>
                                                <div style="font-size: 10px;color: brown" id="tips"></div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <a class="menu-bar mobile-navigation menu-toggle" href="#">
                            <span></span>
                            <span></span>
                            <span></span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="header-nav-container rows-space-20">
        <div class="container">
            <div class="header-nav-wapper main-menu-wapper">
                <div class="vertical-wapper block-nav-categori">
                    <div class="block-title">
							<span class="icon-bar">
								<span></span>
								<span></span>
								<span></span>
							</span>
                        <span class="text">所有种类</span>
                    </div>
                    <div class="block-content verticalmenu-content">
                        <ul class="teamo-nav-vertical vertical-menu teamo-clone-mobile-menu">
                            <li class="menu-item">
                                <a href="go.do?go=index.jsp" class="teamo-menu-item-title" >home</a>
                            </li>
                            <li class="menu-item">
                                <a href="getPagePlantsServlet.do" class="teamo-menu-item-title">shop</a>
                            </li>
                            <li class="menu-item menu-item-has-children">
                                <a title="Accessories" href="#" class="teamo-menu-item-title">operation</a>
                                <span class="toggle-submenu"></span>
                                <ul role="menu" class=" submenu">
                                    <li class="menu-item">
                                        <a href="getCollectionServlet.do" class="teamo-item-title">collection</a>
                                    </li>
                                    <li class="menu-item">
                                        <a href="getShopCarServlet.do" class="teamo-item-title">shopcart</a>
                                    </li>
                                    <li class="menu-item">
                                        <a title="Cacti" href="go.do?go=contact.jsp" class="teamo-item-title">Contact us</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="menu-item">
                                <a  href="go.do?go=inblog.jsp" class="teamo-menu-item-title">blog</a>
                            </li>
                            <li class="menu-item">
                                <a href="go.do?go=about.jsp" class="teamo-menu-item-title">about us</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="header-nav">
                    <div class="container-wapper">
                        <ul class="teamo-clone-mobile-menu teamo-nav main-menu " id="menu-main-menu">
                            <li class="menu-item  menu-item-has-children">
                                <a href="go.do?go=index.jsp" class="teamo-menu-item-title" title="Home">主页</a>
                                <ul class="submenu">
                                    <li class="menu-item">
                                        <a href="go.do?go=index.jsp">home</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="menu-item menu-item-has-children">
                                <a href="getPagePlantsServlet.do" class="teamo-menu-item-title" title="Shop">商店</a>
                                <span class="toggle-submenu"></span>
                                <ul class="submenu">
                                    <li class="menu-item">
                                        <a href="getPagePlantsServlet.do">shop</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="menu-item  menu-item-has-children item-megamenu">
                                <a href="#" class="teamo-menu-item-title" title="Pages">个人操作</a>
                                <span class="toggle-submenu"></span>
                                <div class="submenu mega-menu menu-page">
                                    <div class="row">
                                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-3 menu-page-item">
                                            <div class="teamo-custommenu default">
                                                <h2 class="widgettitle">shop page</h2>
                                                <ul class="menu">
                                                    <li class="menu-item">
                                                        <a href="getCollectionServlet.do" methods="post">收藏夹</a>
                                                    </li>
                                                    <li class="menu-item">
                                                        <a href="getShopCarServlet.do">购物车</a>
                                                    </li>
                                                    <li class="menu-item">
                                                        <a href="go.do?go=contact.jsp">联系我们</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="menu-item  menu-item-has-children">
                                <a href="go.do?go=inblog.jsp" class="teamo-menu-item-title"
                                   title="Blogs">博客</a>
                                <span class="toggle-submenu"></span>
                                <ul class="submenu">
                                    <li class="menu-item menu-item-has-children">
                                        <li class="menu-item">
                                            <a href="go.do?go=bloggrid.jsp">blog</a>
                                        </li>
                                    </li>
                                </ul>
                            </li>
                            <%
                                if (user != null){
                                    if (user.getRole_id() == 1){
                            %>
                                    <li class="menu-item ">
                                        <a href="go.do?go=bgindex.jsp" class="teamo-menu-item-title" title="background">后台</a>
                                    </li>
                            <%
                                    }
                                }
                            %>
                            <li class="menu-item">
                                <a href="go.do?go=about.jsp" class="teamo-menu-item-title" title="About">关于我们</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>

