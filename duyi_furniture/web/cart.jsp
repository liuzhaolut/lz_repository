<%@ page import="java.util.List" %>

<%@ page import="com.dy.bean.Carts" %>

<%@ page import="com.dy.bean.Goods" %>

<%@ page import="com.dy.bean.User" %>

<%@ page import="com.dy.service.FindGoodsService" %>

<%@ page import="com.dy.serviceimpl.FindGoodsServiceImpl" %>

<%@ page import="java.util.ArrayList" %>

<%@ page import="com.google.gson.Gson" %>

<%@ page import="com.dy.serviceimpl.SqlCartsService" %><%--

  Created by IntelliJ IDEA.

  User: DELL

  Date: 2020/11/2

  Time: 19:10

  To change this template use File | Settings | File Templates.

--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html>

<head lang="en">

    <meta charset="utf-8"/>

    <title>cart</title>

    <link rel="stylesheet" type="text/css" href="css/public.css"/>

    <link rel="stylesheet" type="text/css" href="css/proList.css"/>

</head>

<body><!--------------------------------------cart--------------------->

<jsp:include page="head.jsp"/>

<%

    FindGoodsService findGoodsService = new FindGoodsServiceImpl();

    SqlCartsService sqlCartsService = new SqlCartsService();

    List<Carts> cs = null;

    List<Goods> gs = null;

    User user = (User) session.getAttribute("user");

    if (user == null){

        cs = (ArrayList<Carts>) session.getAttribute("carts");

    }else {

        cs = sqlCartsService.findByUserId(user.getId());

    }

    if (cs != null && cs.size() != 0) {

        gs = findGoodsService.findGoodsCart(cs);

    }

%>


<div class="cart mt">

    <!-----------------logo------------------->

    <!--<div class="logo"><h1 class="wrapper clearfix"><a href="index.jsp"><img class="fl" src="img/temp/logo.png"></a><img class="top" src="img/temp/cartTop01.png"></h1></div>-->

    <!-----------------site------------------->

    <div class="site"><p class=" wrapper clearfix">

        <span class="fl">购物车</span>

        <img class="top" src="img/temp/cartTop01.png">

        <a href="index.jsp" class="fr">继续购物&gt;</a></p>

    </div>

    <!-----------------table------------------->

    <div class="table wrapper">

        <%

            if (cs == null || cs.size() == 0 || gs.size() == 0){

        %>

        <div class="goOn">空空如也~<a href="index.jsp">去逛逛</a></div>

        <%

            } else {

        %>

        <div class="tr">

            <div>商品</div>

            <div>单价</div>

            <div>数量</div>

            <div>小计</div>

            <div>操作</div>

        </div>

        <%

            // 排序

            ArrayList<Goods> gs2 = new ArrayList<>();

            for (int i = 0; i < cs.size(); i++) {

                Carts c = cs.get(i);

                for (int j = 0; j < gs.size(); j++) {

                    if (c.getGoodsId() == gs.get(j).getId()){

                        gs2.add(gs.get(j));

                        break;

                    }

                }

            }

            gs = gs2;


            double priceAll = 0;

            for (int i = cs.size() - 1; i >= 0 ; i--) {

                Carts carts = cs.get(i);

                Goods goods = gs.get(i);

                priceAll += (carts.getCartNum() * goods.getPrice());


                Gson g = new Gson();

                String img = null;

                if ("[" .equals(goods.getImgs())) {

                    img = "img/imgs/errorGoodsImg.jpg";

                } else {

                    List<String> list = g.fromJson(goods.getImgs(), List.class);

                    img = "img/small/" + list.get(0);

                }



        %>

        <div class="th" <%=i==0?"style='border-bottom: none;'":""%>>

            <div class="pro clearfix">

                <label class="fl">

                    <input onclick="check(this,<%=goods.getId()%>)" type="checkbox" <%=carts.getIsCheck() == 0?"checked":""%>/>

                    <span></span>

                </label>

                <a class="fl"

                                                                                                        href="#">

                <dl class="clearfix">

                    <dt class="fl"><img src="<%=img%>" style="width:120px;height:120px"></dt>

                    <dd class="fl"><p><%=goods.getName().length()>18?(goods.getName().substring(0,15)+"…"):goods.getName()%></p>

                        <p>颜色分类:</p>

                        <p>此商品无分类</p></dd>

                </dl>

            </a></div>

            <div class="price">￥<%=goods.getPrice()%></div>

            <div class="number"><p class="num clearfix">

                <img class="fl sub" src="img/temp/sub.jpg" onclick="cartNumUpdate(-1, <%=goods.getId()%>,this)">

                <span class="fl num"><%=carts.getCartNum()%></span>

                <img class="fl add" src="img/temp/add.jpg" onclick="cartNumUpdate(1, <%=goods.getId()%>,this)"></p>

            </div>

            <div class="price sAll">￥<%=goods.getPrice() * carts.getCartNum()%></div>

            <div class="price"><a class="del" href="javascript:myDel(<%=goods.getId()%>)">删除</a></div>

        </div>

        <%

            }

        %>

        <div class="tr clearfix"><label class="fl"><input class="checkAll" type="checkbox"/><span></span></label>

            <p class="fl"><a href="#">全选</a>

                <a href="#" class="del">删除</a>

            </p>

            <p class="fr"><span>共<small id="sl"><%=cs.size()%></small>件商品</span>

                <span>合计:&nbsp;<small id="all">￥<%=priceAll%></small></span>

                <a href="order.jsp" class="count">结算</a>

            </p>

        </div>

    </div>


    <%

        }

    %>

</div>

<div class="mask"></div>

<div class="tipDel">

    <p>确定要删除该商品吗？</p>

    <p class="clearfix">

        <a class="fl cer" href="javascript:myDel2()">确定</a>

        <a class="fr cancel" href="#">取消</a>

    </p>

</div>

<!--返回顶部-->

<jsp:include page="right.jsp"/>

<%--<script>--%>

<%--    var gs = $("#input1").val();--%>

<%--    --%>

<%--</script>--%>

<%--<%--%>

<%--    System.out.println(gs);--%>

<%--%>--%>

<!----------------mask------------------->

<div class="mask"></div><!-------------------mask内容------------------->

<div class="proDets"><img class="off" src="img/temp/off.jpg"/>

    <div class="proCon clearfix">

        <div class="proImg fr"><img class="list" src="img/temp/proDet.jpg"/>

            <div class="smallImg clearfix"><img src="img/temp/proDet01.jpg" data-src="img/temp/proDet01_big.jpg"><img

                    src="img/temp/proDet02.jpg" data-src="img/temp/proDet02_big.jpg"><img src="img/temp/proDet03.jpg"

                                                                                          data-src="img/temp/proDet03_big.jpg"><img

                    src="img/temp/proDet04.jpg" data-src="img/temp/proDet04_big.jpg"></div>

        </div>

        <div class="fl">

            <div class="proIntro change"><p>颜色分类</p>

                <div class="smallImg clearfix"><p class="fl on"><img src="img/temp/prosmall01.jpg" alt="白瓷花瓶+20支快乐花"

                                                                     data-src="img/temp/proBig01.jpg"></p>

                    <p class="fl"><img src="img/temp/prosmall02.jpg" alt="白瓷花瓶+20支兔尾巴草"

                                       data-src="img/temp/proBig02.jpg"></p>

                    <p class="fl"><img src="img/temp/prosmall03.jpg" alt="20支快乐花" data-src="img/temp/proBig03.jpg"></p>

                    <p class="fl"><img src="img/temp/prosmall04.jpg" alt="20支兔尾巴草" data-src="img/temp/proBig04.jpg"></p>

                </div>

            </div>

            <div class="changeBtn clearfix">

                <a href="#2" class="fl" >

                    <p class="buy">确认</p>

                </a>

                <a href="#2" class="fr">

                    <p class="cart" >取消</p>

                </a>

            </div>

        </div>

    </div>

</div>

<div class="pleaseC"><p>请选择宝贝</p><img class="off" src="img/temp/off.jpg"/></div>


<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>

<script src="js/public.js" type="text/javascript" charset="utf-8"></script>

<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>

<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>

<script src="js/layer/layer.js" type="text/javascript" charset="utf-8"></script>

<script>

    var goodsId = null;

    function myDel(goodsId2) {

        goodsId = goodsId2;

    }

    function myDel2() {

        $.get("cartDel.do","goodsId=" + goodsId, function (data) {});

        console.log(goodsId);

        var e = 0;

        var c = $(".th input[type='checkbox']:checked").parents(".th").find(".num span");

        var d = c.length;

        if (d == 0) {

            $("#sl").text(0)

        } else {

            c.each(function () {

                e += parseInt($(this).text());

                $("#sl").text(e)

                var $goCartSpan = $(".goCart>span");

                $goCartSpan.jsp(e);

            })

        }

        if ($("#sl").text() > 0) {

            $(".count").css("background", "#c10000")

        } else {

            $(".count").css("background", "#8e8e8e")

            $("#all").text("0.0");

        }


        var c = 0;

        var d = $(".th input[type='checkbox']:checked").length;

        if (d == 0) {

            $("#all").text("￥" + parseFloat(0).toFixed(2))

        } else {

            $(".th input[type='checkbox']:checked").each(function () {

                var e = $(this).parents(".pro").siblings(".sAll").text().substring(1);

                c += parseFloat(e);

                $("#all").text("￥" + c.toFixed(2))

            })

        }

    }

    function check(input,goodsId) {

        $.get("cartCheck.do","goodsId="+ goodsId + "&isCheck=" + (input.checked?0:1),function (data) {});



    }

    function cartNumUpdate(type, goodsId, element) {

        // console.log(type + " , " + goodsId);

        //判断是否可减少

        var $e = $(element).parent().find(".num");

        if ($e.jsp() == "1" && type == -1){

            return;

        }


        //计算总数并显示

        var $goCartSpan = $(".goCart>span");

        var num = Number($goCartSpan.jsp()) + type;

        $goCartSpan.jsp(num);


        //把操作发送给服务器

        $.get("cartNumUpdate.do", "goodsId=" + goodsId + "&num=" + type, function (data) {


        })

    }


    $(function () {

        var e = 0;

        var c = $(".th input[type='checkbox']:checked").parents(".th").find(".num span");

        var d = c.length;

        if (d == 0) {

            $("#sl").text(0)

        } else {

            c.each(function () {

                e += parseInt($(this).text());

                $("#sl").text(e)

            })

        }


        // var c = 0;

        // var d = $(".th input[type='checkbox']:checked").length;

        // if (d == 0) {

        //     $("#all").text("￥" + parseFloat(0).toFixed(2))

        // } else {

        //     $(".th input[type='checkbox']:checked").each(function () {

        //         var e = $(this).parents(".pro").siblings(".sAll").text().substring(1);

        //         c += parseFloat(e);

        //         $("#all").text("￥" + c.toFixed(2))

        //     })

        // }


        if ($("#sl").text() > 0) {

            $(".count").css("background", "#c10000")

        } else {

            $(".count").css("background", "#8e8e8e")

            $("#all").text("0.0");

        }

    })


</script>

</body>

</html>


