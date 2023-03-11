<%@ page import="com.dy.service.FindGoodsService" %>
<%@ page import="com.dy.serviceimpl.FindGoodsServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dy.bean.Goods" %>
<%@ page import="com.google.gson.Gson" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/27
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>布艺软饰</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<%
    List<Goods> goodsData = null;
    FindGoodsService service = new FindGoodsServiceImpl();
    String type = request.getParameter("type");
    String classId1 = request.getParameter("classId1");
    String classId2 = request.getParameter("classId2");
    String goodsName = request.getParameter("goodsName");
    String orderBy = request.getParameter("orderBy");
    String class1Name = request.getParameter("class1Name");
    String class2Name = request.getParameter("class2Name");
    int orderByInt = orderBy == null?0:Integer.parseInt(orderBy);
    if (type == null) {
        type = "";
    }
    switch (type){
        case "0":
            goodsData = service.findAll(orderByInt);
            break;
        case "1":
            goodsData = service.findGoodsByClass1(Integer.parseInt(classId1), 1, 20, orderByInt);
            break;
        case "2":
            goodsData = service.findGoodsByClass2(Integer.parseInt(classId2), 1, 20, orderByInt);
            break;
        case "3":
            goodsData = service.findGoodsLikeName(goodsName, 1, 20, orderByInt);
            class1Name = goodsName;
            break;
    }
%>
<body><!------------------------------head------------------------------>
<jsp:include page="head.jsp"/>
<!------------------------------banner------------------------------>
<div class="banner"><a href="#"><img src="img/temp/banner1.jpg"/></a></div>
<!-----------------address------------------------------->
<div class="address">
    <div class="wrapper clearfix">
        <a href="index.jsp">首页</a>
        <span>/</span>
        <%
            if (class1Name.equals("所有商品") || type.equals("3")) {
                %>
             <a href="#" class="on"><%=class1Name%></a>
            <%
                }else {
                %>
        <a href="flowerDer.jsp?type=1&classId1=<%=classId1%>&class1Name=<%=class1Name%>" class="on"><%=class1Name%></a>
        <%
            }
        %>

        <%
            if (class2Name != null) {
            %>
                <span>/</span>
                <a href="flowerDer.jsp?type=2&classId1=<%=classId1%>&classId2=<%=classId2%>&class1Name=<%=class1Name%>&class2Name=<%=class2Name%>" class="on"><%=class2Name%></a>
             <%
            }
        %>
    </div>
</div><!-------------------current---------------------->
<div class="current">
    <div class="wrapper clearfix">

            <%
                if (class2Name != null) {
            %>
                <h3 class="fl"><%=class2Name%></h3>
            <%
                } else {
            %>
                 <h3 class="fl"><%=class1Name%></h3>
             <%
                }
             %>


        <div class="fr choice">
            <p class="default"><%=orderByInt==0?"价格从低到高":"价格从高到低"%></p>
            <ul class="select">
                <%
//                    js中的window.location.href 进行页面的跳转
//                    js中的window.location.replace 进行页面替换

                %>
                <li onclick="orderBy(0)">价格从高到低</li>
                <li onclick="orderBy(1)">价格从低到高</li>
                <script>
                    function orderBy(type) {
                        var url = window.location.href;
                        url = url.replace("&orderBy=1","");
                        if (type == 0){
                            url = url + "&orderBy=1";
                        }
                        if (url != window.location.href){
                            window.location.replace(url);
                        }
                    }
                </script>
            </ul>
        </div>
    </div>
</div><!----------------proList------------------------->
<ul class="proList wrapper clearfix">
    <%
        if (goodsData == null || goodsData.size() == 0) {
    %>
       <h1 align="center">抱歉，此商品不存在</h1>
    <%
        }else {
            for (Goods g:goodsData
            ) {
                String imgs = g.getImgs();
                String imgPath = null;
                if ("[" .equals(imgs)) {
                    imgPath = "errorGoodsImg.jpg";
                } else {
                    Gson gs = new Gson();
                    List<String> imgList = gs.fromJson(imgs, List.class);
                    imgPath = imgList.get(0);
                }

    %>
        <li>
            <a href="findGoods.do?goodsId=<%=g.getId()%>">
                <dl>
                    <dt><img src="img/imgs/<%=imgPath%>"></dt>
                    <dd><%=g.getName()%></dd>
                    <dd>￥<%=g.getPrice()%></dd>
                </dl>
            </a>
        </li>
    <%
            }
        }
    %>

</ul><!----------------mask------------------->
<div class="mask"></div><!-------------------mask内容------------------->
<div class="proDets"><img class="off" src="img/temp/off.jpg"/>
    <div class="tit clearfix"><h4 class="fl">【渡一】非洲菊仿真花干花</h4><span class="fr">￥17.90</span></div>
    <div class="proCon clearfix">
        <div class="proImg fl"><img class="list" src="img/temp/proDet.jpg"/>
            <div class="smallImg clearfix"><img src="img/temp/proDet01.jpg" data-src="img/temp/proDet01_big.jpg"><img
                    src="img/temp/proDet02.jpg" data-src="img/temp/proDet02_big.jpg"><img src="img/temp/proDet03.jpg"
                                                                                          data-src="img/temp/proDet03_big.jpg"><img
                    src="img/temp/proDet04.jpg" data-src="img/temp/proDet04_big.jpg"></div>
        </div>
        <div class="fr">
            <div class="proIntro"><p>颜色分类</p>
                <div class="smallImg clearfix categ"><p class="fl"><img src="img/temp/prosmall01.jpg" alt="白瓷花瓶+20支快乐花"
                                                                        data-src="img/temp/proBig01.jpg"></p>
                    <p class="fl"><img src="img/temp/prosmall02.jpg" alt="白瓷花瓶+20支兔尾巴草"
                                       data-src="img/temp/proBig02.jpg"></p>
                    <p class="fl"><img src="img/temp/prosmall03.jpg" alt="20支快乐花" data-src="img/temp/proBig03.jpg"></p>
                    <p class="fl"><img src="img/temp/prosmall04.jpg" alt="20支兔尾巴草" data-src="img/temp/proBig04.jpg"></p>
                </div>
                <p>数量</p>
                <div class="num clearfix"><img class="fl sub" src="img/temp/sub.jpg"><span class="fl"
                                                                                           contentEditable="true">1</span><img
                        class="fl add" src="img/temp/add.jpg">
                    <p class="please fl">请选择商品属性!</p></div>
            </div>
            <div class="btns clearfix"><a href="#2"><p class="buy fl">立即购买</p></a><a href="#2"><p class="cart fr">
                加入购物车</p></a></div>
        </div>
    </div>
    <a class="more" href="proDetail.jsp">查看更多细节</a></div><!--返回顶部-->
<div class="gotop"><a href="cart.jsp">
    <dl class="goCart">
        <dt><img src="img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
        <span>1</span></dl>
</a><a href="#" class="dh">
    <dl>
        <dt><img src="img/gt2.png"/></dt>
        <dd>联系<br/>客服</dd>
    </dl>
</a><a href="mygxin.jsp">
    <dl>
        <dt><img src="img/gt3.png"/></dt>
        <dd>个人<br/>中心</dd>
    </dl>
</a><a href="#" class="toptop" style="display: none;">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p>18516955565</p></div>
<div class="msk"></div><!--footer-->
<div class="footer">
    <div class="top">
        <div class="wrapper">
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot1.png"/></a><span class="fl">7天无理由退货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot2.png"/></a><span class="fl">15天免费换货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot3.png"/></a><span class="fl">满599包邮</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot4.png"/></a><span class="fl">手机特色服务</span>
            </div>
        </div>
    </div>
    <p class="dibu">渡一家居&copy;为您的家庭增添一抹温馨<br/>
        本网站所列数据仅作为学生作品展示 ， 学生作品如有侵权，请联系：18516955565</p></div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>

