<%@ page import="com.dy.bean.Goods" %>
<%@ page import="com.dy.bean.GoodClass" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.google.gson.Gson" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/28
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%
    Goods goods = (Goods) request.getAttribute("goods");
    GoodClass class1 = (GoodClass) request.getAttribute("class1");
    GoodClass class2 = (GoodClass) request.getAttribute("class2");
    if (goods == null || class1 == null || class2 == null) {
        response.sendError(404, "哈哈哈哈哈，商品找不到了");
        return;
    }

%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><%=goods.getName()%>></title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body><!------------------------------head------------------------------>
<jsp:include page="head.jsp"/>
<!-----------------address------------------------------->
<div class="address">
    <div class="wrapper clearfix"><a href="index.jsp">首页</a><span>/</span>
        <a href="#"><%=class1.getClassname()%></a><span>/</span>
        <a href="#"><%=class2.getClassname()%></a><span>/</span>
        <a href="#" class="on"><%=goods.getName()%></a>
    </div>
</div><!-----------------------Detail------------------------------>
<div class="detCon">
    <div class="proDet wrapper">
        <div class="proCon clearfix">
            <div class="proImg fl">
                <%
                    // 商品图片
                    String imgs = goods.getImgs();
                    List<String> imgList = null;
                    if ("[" .equals(imgs)) {
                        imgList = new ArrayList<>();
                        imgList.add("img/imgs/errorGoodsImg.jpg");
                    } else {
                        Gson gs = new Gson();
                        imgList = gs.fromJson(imgs, List.class);
                    }

                %>
                <img class="det" src="img/imgs/<%=imgList.get(0)%>"/>
                <div class="smallImg clearfix">
                    <%
                        for (String imgPath:imgList
                             ) {
                            %>
                    <img src="img/small/<%=imgPath%>" data-src="img/imgs/<%=imgPath%>">
                    <%
                        }
                    %>

                </div>
            </div>
            <div class="fr intro">
                <div class="title"><h4><%=goods.getName()%></h4>
                    <p>
                        <%
                        Gson g = new Gson();
                        List<String> descs = g.fromJson(goods.getGedsc(), List.class);
                        for (String str: descs
                             ) {
                        %>
                        【<%=str%>】&nbsp;&nbsp;
                        <%
                           }
                         %>
                        <%=goods.getGedsc()%></p><span>￥<%=goods.getPrice()%></span></div>
                <div class="proIntro">
                    <p>数量&nbsp;&nbsp;库存<span><%=goods.getStock()%></span>件</p>
                    <div class="num clearfix"><img class="fl sub" src="img/temp/sub.jpg">
                        <span class="fl number"
                                                                                               contentEditable="true">1</span><img
                            class="fl add" src="img/temp/add.jpg">
                        <p class="please fl">请选择商品属性!</p></div>
                </div>
                <div class="btns clearfix">
                    <a href="javascript:order()"><p class="buy fl">立即购买</p></a>
                    <script>
                        function order() {
                            var num = $(".number").text();
                            window.location.href = "order.jsp?id=<%=goods.getId()%>&num=" + num;
                        }
                    </script>

                    <a href="javascript:add()"><p class="cart fr">加入购物车</p></a>
                </div>
                <%
//                    jsp引擎的执行流程和原理：
//                    1.jsp引擎将.jsp,转换为servlet
//                    2.将请求转发到servlet
//                    3.servlet开始打印HTML响应体
//                    4.将打印完的相应体发送浏览器
                %>
                <script>
                    function add() {
                        layer.load();
                        <%--$.post("addGoodsCar.do", "goodsId=<%=goods.getId()%>", function (data) {--%>
                        <%--    layer.closeAll();--%>
                        <%--    layer.msg(data.msg);--%>
                        <%--})--%>
                        $.get("addGoodsCar.do", "goodsId=<%=goods.getId()%>", function (data) {
                            layer.closeAll();
                            layer.msg(data.msg);
                            var $goCartSpan = $(".goCart>span");
                            if ($goCartSpan.length == 0) {
                                $goCartSpan = $("<span>1</span>");
                                $(".goCart").append($goCartSpan);
                            } else {
                                var num = Number($goCartSpan.jsp()) + 1;
                                $goCartSpan.jsp(num);
                            }
                        });
                    }
                </script>
            </div>
        </div>
    </div>
</div>
<div class="introMsg wrapper clearfix">
    <div class="msgL fl">
        <div class="msgTit clearfix"><a class="on">商品详情</a><a>所有评价</a></div>
        <div class="msgAll">
            <div class="msgImgs">
                <%
                    String imgs2 = goods.getInfo();
                    List<String> imgList2 = null;
                    if ("[" .equals(imgs2)) {
                        imgList2 = new ArrayList<>();
                        imgList2.add("img/imgs/errorGoodsImg.jpg");
                    } else {
                        Gson gs = new Gson();
                        imgList2 = gs.fromJson(imgs2, List.class);
                    }
                %>
                <%
                    for (String imPath:imgList2
                         ) {
                        %>
                        <img src="img/imgs/<%=imPath%>">
                <%
                    }
                %>

            </div>
            <div class="eva">
                <div class="per clearfix"><img class="fl" src="img/temp/per01.jpg">
                    <div class="perR fl"><p>馨***呀</p>
                        <p>不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分</p>
                        <div class="clearfix">
                            <p><img src="img/temp/eva01.jpg"></p>
                            <p><img src="img/temp/eva02.jpg"></p>
                            <p><img src="img/temp/eva03.jpg"></p>
                            <p><img src="img/temp/eva04.jpg"></p>
                            <p><img src="img/temp/eva05.jpg"></p></div>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="img/temp/per02.jpg">
                    <div class="perR fl"><p>么***周</p>
                        <p>花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！</p>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="img/temp/per01.jpg">
                    <div class="perR fl"><p>馨***呀</p>
                        <p>不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分</p>
                        <div class="clearfix"><p><img src="img/temp/eva01.jpg"></p>
                            <p><img src="img/temp/eva02.jpg"></p>
                            <p><img src="img/temp/eva03.jpg"></p>
                            <p><img src="img/temp/eva04.jpg"></p>
                            <p><img src="img/temp/eva05.jpg"></p></div>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="img/temp/per02.jpg">
                    <div class="perR fl"><p>么***周</p>
                        <p>花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！</p>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="img/temp/per01.jpg">
                    <div class="perR fl"><p>馨***呀</p>
                        <p>不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分</p>
                        <div class="clearfix"><p><img src="img/temp/eva01.jpg"></p>
                            <p><img src="img/temp/eva02.jpg"></p>
                            <p><img src="img/temp/eva03.jpg"></p>
                            <p><img src="img/temp/eva04.jpg"></p>
                            <p><img src="img/temp/eva05.jpg"></p></div>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="img/temp/per02.jpg">
                    <div class="perR fl"><p>么***周</p>
                        <p>花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！</p>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="img/temp/per01.jpg">
                    <div class="perR fl"><p>馨***呀</p>
                        <p>不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分</p>
                        <div class="clearfix"><p><img src="img/temp/eva01.jpg"></p>
                            <p><img src="img/temp/eva02.jpg"></p>
                            <p><img src="img/temp/eva03.jpg"></p>
                            <p><img src="img/temp/eva04.jpg"></p>
                            <p><img src="img/temp/eva05.jpg"></p></div>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="img/temp/per02.jpg">
                    <div class="perR fl"><p>么***周</p>
                        <p>花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！</p>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="img/temp/per01.jpg">
                    <div class="perR fl"><p>馨***呀</p>
                        <p>不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分</p>
                        <div class="clearfix"><p><img src="img/temp/eva01.jpg"></p>
                            <p><img src="img/temp/eva02.jpg"></p>
                            <p><img src="img/temp/eva03.jpg"></p>
                            <p><img src="img/temp/eva04.jpg"></p>
                            <p><img src="img/temp/eva05.jpg"></p></div>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="img/temp/per02.jpg">
                    <div class="perR fl"><p>么***周</p>
                        <p>花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！</p>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
            </div>
        </div>
    </div>
    <div class="msgR fr"><h4>为你推荐</h4>
        <div class="seeList"><a href="#">
            <dl>
                <dt><img src="img/temp/see01.jpg"></dt>
                <dd>【渡一】复古文艺风玻璃花瓶</dd>
                <dd>￥193.20</dd>
            </dl>
        </a><a href="#">
            <dl>
                <dt><img src="img/temp/see02.jpg"></dt>
                <dd>【渡一】复古文艺风玻璃花瓶</dd>
                <dd>￥193.20</dd>
            </dl>
        </a><a href="#">
            <dl>
                <dt><img src="img/temp/see03.jpg"></dt>
                <dd>【渡一】复古文艺风玻璃花瓶</dd>
                <dd>￥193.20</dd>
            </dl>
        </a><a href="#">
            <dl>
                <dt><img src="img/temp/see04.jpg"></dt>
                <dd>【渡一】复古文艺风玻璃花瓶</dd>
                <dd>￥193.20</dd>
            </dl>
        </a></div>
    </div>
</div>
<div class="like"><h4>猜你喜欢</h4>
    <div class="bottom">
        <div class="hd"><span class="prev"><img src="img/temp/prev.png"></span><span class="next"><img
                src="img/temp/next.png"></span></div>
        <div class="imgCon bd">
            <div class="likeList clearfix">
                <div><a href="proDetail.jsp">
                    <dl>
                        <dt><img src="img/temp/like01.jpg"></dt>
                        <dd>【渡一】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a><a href="proDetail.jsp">
                    <dl>
                        <dt><img src="img/temp/like02.jpg"></dt>
                        <dd>【渡一】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a><a href="proDetail.jsp">
                    <dl>
                        <dt><img src="img/temp/like03.jpg"></dt>
                        <dd>【渡一】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a><a href="proDetail.jsp">
                    <dl>
                        <dt><img src="img/temp/like04.jpg"></dt>
                        <dd>【渡一】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a><a href="proDetail.jsp" class="last">
                    <dl>
                        <dt><img src="img/temp/like05.jpg"></dt>
                        <dd>【渡一】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a></div>
                <div><a href="proDetail.jsp">
                    <dl>
                        <dt><img src="img/temp/like01.jpg"></dt>
                        <dd>【渡一】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a><a href="proDetail.jsp">
                    <dl>
                        <dt><img src="img/temp/like02.jpg"></dt>
                        <dd>【渡一】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a><a href="proDetail.jsp">
                    <dl>
                        <dt><img src="img/temp/like03.jpg"></dt>
                        <dd>【渡一】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a><a href="proDetail.jsp">
                    <dl>
                        <dt><img src="img/temp/like04.jpg"></dt>
                        <dd>【渡一】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a><a href="proDetail.jsp" class="last">
                    <dl>
                        <dt><img src="img/temp/like05.jpg"></dt>
                        <dd>【渡一】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a></div>
            </div>
        </div>
    </div>
</div><!--返回顶部-->
<jsp:include page="right.jsp"/>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
<script src="js/layer/layer.js"></script>
<script type="text/javascript">jQuery(".bottom").slide({
    titCell: ".hd ul",
    mainCell: ".bd .likeList",
    autoPage: true,
    autoPlay: false,
    effect: "leftLoop",
    autoPlay: true,
    vis: 1
});</script>
</body>
</html>

