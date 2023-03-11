<%@ page import="java.util.List" %>
<%@ page import="com.etc.plant.entity.Carts" %>
<%@ page import="com.etc.plant.entity.Plants" %>
<%@ page import="com.etc.plant.entity.Region" %>
<%@ page import="com.etc.plant.entity.Address" %>

<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/16
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Teamo - Checkout</title>
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
        function zhifu() {
            var zhiform = document.getElementById("zhiform");
            zhiform.action = "checkoutServlet.do";
            zhiform.method = "post";
            zhiform.submit();
        }
        function addAddress() {
            var code1 = $(".dyjjcity option:selected").get(0).value;
            var code2 = $(".dyjjcity option:selected").get(1).value;
            var code3 = $(".dyjjcity option:selected").get(2).value;
            var code4 = $(".dyjjcity option:selected").get(3).value;
            var zhiform1 = document.getElementById("zhiform");
            zhiform1.action = "addAddressServlet.do?code1=" + code1 + "&code2=" + code2 + "&code3=" + code3 + "&code4=" + code4 ;
            zhiform1.method = "post";
            zhiform1.submit();
        }

    </script>
</head>
<body class="inblog-page">
<jsp:include page="head.jsp"/>
<%
    double sum = (double) session.getAttribute("sumall");
    //    城市数据
    List<Region> citys = (List<Region>) session.getAttribute("citys");

%>
<%--只要内容--%>
<div class="main-content main-content-checkout">
    <form id="zhiform">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-trail breadcrumbs">
                        <ul class="trail-items breadcrumb">
                            <li class="trail-item trail-begin">
                                <a href="go.do?do=index.jsp">主页</a>
                            </li>
                            <li class="trail-item trail-end active">
                                支付
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <h3 class="custom_blog_title">
                支付
            </h3>
            <div class="checkout-wrapp">
                <div class="shipping-address-form-wrapp">
                    <div class="shipping-address-form  checkout-form">
                        <div class="row-col-1 row-col">
                            <h3 class="title-form">
                                收货地址
                            </h3>
                            <h6>${result1}</h6>
                            <p class="form-row" style="width: 100%;display: inline-block;width: calc(50% - 10px);overflow: visible;">
                                <label class="text">姓名</label>
                                <input title="first" type="text" class="input-text" name="uname" >
                            </p>
                            <p class="form-row" style="width: 100%;clear: left;display: inline-block;width: calc(50% - 10px);overflow: visible;float: none;">
                                <label class="text">电话号码</label>
                                <input title="last" type="text" class="input-text" name="phone" >
                            </p>

                            <div class="city dyjjcity">
                                    <label class="text">省</label><br>
                                    <select name="province" onchange="selectChange(1, this)" style="padding-left: 0;width: 235px;height: 43px;" >
                                        <%
                                            for (Region r: citys
                                            ) {
                                        %>
                                        <option value="<%=r.getCode()%>"><%=r.getName()%></option>
                                        <%
                                            }
                                        %>
                                    </select><br>

                                    <label class="text" style="float:left;margin-top: -71px;margin-left: 365px">城市/地区</label><br>
                                    <select onchange="selectChange(2, this)" name="city" style="padding-left: 0;width: 235px;height: 43px;float:left;margin-top: -67px;margin-left: 365px">
                                        <option value="城市/地区">城市/地区</option>
                                    </select>

                                    <label class="text">区/县</label><br>
                                    <select onchange="selectChange(3, this)" name="area" style="padding-left: 0;width: 235px;height: 43px;">
                                        <option value="区/县">区/县</option>
                                    </select>

                                    <label class="text" style="float:left;margin-top: -71px;margin-left: 365px">配送区域</label><br>
                                    <select onchange="selectChange(4, this)" name="street"  style="padding-left: 0;width: 235px;height: 43px;float:left;margin-top: -43px;margin-left: 365px">
                                        <option value="配送区域">配送区域</option>
                                    </select>
                                <br>
                            </div>
                            <p class="form-row" style="width: 100%;display: inline-block;width: calc(50% - 10px);overflow: visible;margin-top: 20px">
                                <label class="text">邮编</label>
                                <input title="zip" type="text" class="input-text" name="zipcode" >
                            </p>
                            <p class="form-row" style="width: 100%;clear: left;display: inline-block;width: calc(50% - 10px);overflow: visible;float: none;">
                                <label class="text">详细地址</label>
                                <input title="address" type="text" class="input-text" name="address">
                            </p>
                        </div>
                        <div class="button-control">
                            <a href="getPagePlantsServlet.do" class="button btn-back-to-shipping">继续购物</a>
                            <a onclick="addAddress()" class="button btn-pay-now">保存</a>
                        </div>
                        <div class="row-col-2 row-col">
                            <div class="your-order">
                                <h3 class="title-form">
                                    您的订单
                                </h3>
                                <%
                                    List<Carts> carts = (List<Carts>) session.getAttribute("shopcar");
                                    List<Plants> plants = (List<Plants>) session.getAttribute("plantall");
                                    for (int i = 0; i < carts.size(); i++) {
                                %>
                                <ul class="list-product-order">
                                    <li class="product-item-order">
                                        <div class="product-thumb">
                                            <a href="#">
                                                <img src="<%=plants.get(i).getPic()%>" alt="img">
                                            </a>
                                        </div>
                                        <div class="product-order-inner">
                                            <h5 class="product-name">
                                                <a href="#"><%=plants.get(i).getPlant_name()%></a>
                                            </h5>
                                            <span class="attributes-select attributes-color"><%=carts.get(i).getColour()%></span>&nbsp;&nbsp;&nbsp;
                                            <span class="attributes-select attributes-size"><%=carts.get(i).getSize()%></span>
                                            <div class="price">
                                                $<%=plants.get(i).getPrice()%>
                                                <span class="count">x<%=carts.get(i).getCartNum()%></span>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                                <%
                                    }
                                %>

                                <div class="order-total">
                                        <span class="title">
                                            总计:
                                        </span>
                                    <span class="total-price">
                                            ￥<%=sum%>
                                        </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="payment-method-wrapp">

                    <div class="payment-method-form checkout-form">
                        <div class="row-col-1 row-col">
                            <div class="payment-method">
                                <h3 class="title-form">
                                    支付方式
                                </h3>
                                <div class="group-button-payment">
                                    <a href="#" class="button btn-credit-card">信用卡</a>
                                    <a href="#" class="button btn-paypal">贝宝</a>
                                </div>
                                <p class="form-row form-row-card-number">
                                    <label class="text">银行卡号</label>
                                    <input type="text" class="input-text" placeholder="xxx - xxx - xxx - xxx" name="card">
                                </p>
                                <p class="form-row forn-row-col forn-row-col-2">
                                    <label class="text">年</label>
                                    <select title="Year" data-placeholder="2017" class="chosen-select" tabindex="1" name="year">
                                        <option value="2020">2020</option>
                                        <option value="2021">2021</option>
                                        <option value="2022">2022</option>
                                    </select>
                                </p>
                                <p class="form-row forn-row-col forn-row-col-1">
                                    <label class="text">月</label>
                                    <select title="month" data-placeholder="01" class="chosen-select" tabindex="1" name="moth">
                                        <option value="1">01</option>
                                        <option value="2">02</option>
                                        <option value="3">03</option>
                                        <option value="4">04</option>
                                        <option value="5">05</option>
                                        <option value="6">06</option>
                                        <option value="7">07</option>
                                        <option value="8">08</option>
                                        <option value="9">09</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                    </select>
                                </p>
                                <p class="form-row forn-row-col forn-row-col-3">
                                    <label class="text">日</label>
                                    <select title="CVV" data-placeholder="238" class="chosen-select" tabindex="1" name="day">
                                        <option value="1">1</option>
                                        <option value="5">5</option>
                                        <option value="10">10</option>
                                        <option value="15">15</option>
                                        <option value="20">20</option>
                                        <option value="25">25</option>
                                        <option value="30">30</option>
                                    </select>
                                </p>
                            </div>
                        </div>
                        <div class="row-col-2 row-col">
                            <div class="your-order">
                                <h3 class="title-form">
                                    您的订单
                                </h3>
                                <%
                                    for (int i = 0; i < carts.size(); i++) {
                                %>
                                <ul class="list-product-order">
                                    <li class="product-item-order">
                                        <div class="product-thumb">
                                            <a href="#">
                                                <img src="<%=plants.get(i).getPic()%>" alt="img">
                                            </a>
                                        </div>
                                        <div class="product-order-inner">
                                            <h5 class="product-name">
                                                <a href="#"><%=plants.get(i).getPlant_name()%></a>
                                            </h5>
                                            <span class="attributes-select attributes-color"><%=carts.get(i).getColour()%></span>&nbsp;&nbsp;&nbsp;
                                            <span class="attributes-select attributes-size"><%=carts.get(i).getSize()%></span>
                                            <div class="price">
                                                $<%=plants.get(i).getPrice()%>
                                                <span class="count">x<%=carts.get(i).getCartNum()%></span>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                                <%
                                    }
                                %>
                                <div class="order-total">
                                    <span class="title">
                                        总价:
                                    </span>
                                    <span class="total-price">
                                        $<%=sum%>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="button-control">
                        <a href="getPagePlantsServlet.do" class="button btn-back-to-shipping">继续购物</a>
                        <a onclick="zhifu()" class="button btn-pay-now">支付</a>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<script src="assets/js/jquery-1.12.4.min.js"></script>
<script src="assets/js/layer/layer.js"></script>
<script>
    //假设当前选中了一个省份 , 导致上面代码执行, 显示了市.
    //现在我们要联动 显示 县或区 , 要显示县或区,
    // 需要递归调用自身, 传递两个参数:
    // 1.   传递一个type=2 , 刚好是type+1
    // 2.   传递一个市的选择框 ,  因为当前函数 需要使用市的选择框,  得到被选中的市, 根据被选中的市 获取县信息
    // 3.   市的下标是1 , 刚好是type

    function selectChange(type, select) {

        if (type == 4){
            return;
        }
        //获取选中的值

        var code = $(select).find("option:selected").val();
        //单线程同步
        $.ajax({
            url:"getRegionByParentCode.do",
            type:"GET",
            async:false,
            data:"code=" + code,
            dataType:"JSON",
            success:function (data) {
                var $select;
                switch (type) {
                    case 1:
                        $select = $(".dyjjcity>select:eq(1)");
                        break;
                    case 2:
                        $select = $(".dyjjcity>select:eq(2)");
                        break;
                    case 3:
                        $select = $(".dyjjcity>select:eq(3)");
                        break;
                }
                $select.html("");
                for (var i = 0; i < data.data.length; i++) {
                    var city = data.data[i];
                    var $newOption = $("<option value = '" + city.code + "'>" + city.name + "</option>");
                    $select.append($newOption);
                }
                select = $(".dyjjcity>select:eq(" + type + ")").get(0);
                selectChange(type + 1, select)
            }
        });
    }


</script>
<jsp:include page="footer.jsp"/>
<a href="#" class="backtotop">
    <i class="fa fa-angle-double-up"></i>
</a>

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
